package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.NoteDao;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.Tag;
import com.laigaopeng.www.service.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteDao noteDao;

    @Autowired
    private LikeService likeService;
    @Autowired
    private CollectService collectService;
    @Autowired
    private NoteTagService noteTagService;
    @Autowired
    private CommentService commentService;

    @Override
    public boolean save(Note note, List<Tag> tags) {
        if (noteDao.save(note) != 1) return false;
        for (Tag tag : tags) { // 建立笔记和标签的绑定
            noteTagService.save(note.getId(), tag.getId());
        }
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
    public List<Note> listLikeNotes(Integer userId) {
        return noteDao.listByUserId(userId);
    }

    @Override
    public List<Note> listCollectNotes(Integer userId) {
        return noteDao.listCollections(userId);
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
}
