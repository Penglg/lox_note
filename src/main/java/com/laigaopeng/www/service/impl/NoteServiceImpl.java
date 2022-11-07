package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.NoteDao;
import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.Tag;
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
    public boolean save(Note note, List<Tag> tags, String approvalContent) {
        if (EmptyCheckerUtil.isStringEmpty(approvalContent)) return false;
        if (noteDao.save(note) != 1) return false;
        if (tags != null) {
            for (Tag tag : tags) { // 建立笔记和标签的绑定
                noteTagService.save(note.getId(), tag.getId());
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
    public List<Note> listAll() {
        return noteDao.listAll();
    }

    @Override
    public List<Note> listAll(Integer isLegal) {
        return noteDao.listByConditions(null, isLegal);
    }

    @Override
    public List<Note> listSectionNotes(Integer sectionId, Integer isLegal) {
        return noteDao.listByConditions(sectionId, isLegal);
    }

    @Override
    public List<Note> listUserNotes(Integer userId) {
        return noteDao.listByUserId(userId);
    }

    @Override
    public List<Note> listLikeNotes(Integer userId) {
        return noteDao.listLikes(userId);
    }

    @Override
    public List<Note> listCollectNotes(Integer userId) {
        return noteDao.listCollections(userId);
    }

}
