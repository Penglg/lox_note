package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.NoteDao;
import com.laigaopeng.www.exception.BusinessException;
import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.NoteTag;
import com.laigaopeng.www.pojo.vo.Page;
import com.laigaopeng.www.service.*;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 笔记业务功能实现
 *
 */
@Service("noteService")
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;

    @Autowired
    private ApprovalService approvalService;
    @Autowired
    private LikeService likeService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private NoteTagService noteTagService;
    @Autowired
    private CommentService commentService;

    @Override
    public boolean save(Note note, List<Integer> tagIds, String approvalContent) {
        if (EmptyCheckerUtil.isStringEmpty(approvalContent)) {
            throw new BusinessException();
        }
        if (noteDao.save(note) != 1) return false;
        if (tagIds != null) {
            for (int tag : tagIds) { // 建立笔记和标签的绑定
                NoteTag noteTag = new NoteTag();
                noteTag.setNoteId(note.getId());
                noteTag.setTagId(tag);
                noteTagService.save(noteTag);
            }
        }
        Approval approval = new Approval();
        approval.setNoteId(note.getId());
        approval.setUserId(note.getUserId());
        approval.setContent(approvalContent);
        approvalService.save(approval);
        return true;
    }

    @Override
    public boolean updateNote(Note note) {
        return noteDao.update(note) == 1;
    }

    @Override
    public boolean deleteNote(Integer id) {
        likeService.deleteNoteLikes(id); // 删除对应的点赞
        collectService.deleteNoteCollects(id); // 删除对应收藏
        commentService.deleteNoteComments(id); // 删除对应评论
        noteTagService.deleteNoteTags(id); // 删除对应笔记标签的绑定
        return noteDao.delete(id) == 1;
    }

    @Override
    public Note getById(Integer id) {
        return noteDao.getById(id);
    }

    @Override
    public Page<Note> listAll(Integer pageNum) {
        Page<Note> page = new Page<>(pageNum, noteDao.recordTotalCount());
        page.setItems(noteDao.listAll(page.getBegin(), page.getPageSize()));
        return page;
    }

    @Override
    public Page<Note> listAll(Integer pageNum, Integer isLegal) {
        if (EmptyCheckerUtil.isIntegerEmpty(pageNum) || EmptyCheckerUtil.isIntegerEmpty(isLegal)) {
            throw new BusinessException();
        }
        Note note = new Note();
        note.setLegal(isLegal);
        Page<Note> page = new Page<>(pageNum, noteDao.recordTotalCountByConditions(note));
        List<Note> notes = noteDao.listByConditions(null, isLegal, page.getBegin(), page.getPageSize());
        page.setItems(notes);
        return page;
    }

    @Override
    public Page<Note> listSectionNotes(Integer sectionId, Integer isLegal, Integer pageNum) {
        if (EmptyCheckerUtil.isIntegerEmpty(pageNum) || EmptyCheckerUtil.isIntegerEmpty(isLegal) ||
                EmptyCheckerUtil.isIntegerEmpty(sectionId)) {
            throw new BusinessException();
        }
        Note note = new Note();
        note.setSectionId(sectionId);
        note.setLegal(isLegal);
        Page<Note> page = new Page<>(pageNum, noteDao.recordTotalCountByConditions(note));
        List<Note> notes = noteDao.listByConditions(sectionId, isLegal, page.getBegin(), page.getPageSize());
        page.setItems(notes);
        return page;
    }

    @Override
    public Page<Note> listUserNotes(Integer userId, Integer isLegal, Integer pageNum) {
        if (EmptyCheckerUtil.isIntegerEmpty(pageNum) || EmptyCheckerUtil.isIntegerEmpty(isLegal) ||
                EmptyCheckerUtil.isIntegerEmpty(userId)) {
            throw new BusinessException();
        }
        Page<Note> page = new Page<>(pageNum, noteDao.recordTotalByUserId(userId, isLegal));
        List<Note> notes = noteDao.listByUserId(userId, isLegal, page.getBegin(), page.getPageSize());
        page.setItems(notes);
        return page;
    }

    @Override
    public Page<Note> listLikeNotes(Integer userId, Integer pageNum) {
        if (EmptyCheckerUtil.isIntegerEmpty(pageNum) || EmptyCheckerUtil.isIntegerEmpty(userId)) {
            throw new BusinessException();
        }
        Page<Note> page = new Page<>(pageNum, noteDao.recordTotalLikes(userId));
        page.setItems(noteDao.listLikes(userId, page.getBegin(), page.getPageSize()));
        return page;
    }

    @Override
    public Page<Note> listCollectNotes(Integer userId, Integer pageNum) {
        if (EmptyCheckerUtil.isIntegerEmpty(pageNum) || EmptyCheckerUtil.isIntegerEmpty(userId)) {
            throw new BusinessException();
        }
        Page<Note> page = new Page<>(pageNum, noteDao.recordTotalCollect(userId));
        page.setItems(noteDao.listCollections(userId, page.getBegin(), page.getPageSize()));
        return page;
    }


}
