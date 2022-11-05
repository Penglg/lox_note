package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.LikeDao;
import com.laigaopeng.www.pojo.Like;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.service.LikeService;
import com.laigaopeng.www.service.NoteService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 点赞业务功能实现
 *
 */
@Service("likeService")
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeDao likeDao;

    @Autowired
    private NoteService noteService;

    @Override
    public boolean save(Integer userId, Integer noteId) {
        Like like = new Like();
        like.setNoteId(noteId);
        like.setUserId(userId);
        // 笔记点赞数加1
        Note note = noteService.getById(noteId);
        note.setLikes(note.getLikes() + 1);
        return likeDao.save(like) == 1 && noteService.updateNote(note);
    }

    @Override
    public boolean delete(Integer id) {
        if (EmptyCheckerUtil.isIntegerEmpty(id)) return false;
        // 笔记点赞数减1
        Note note = noteService.getById(likeDao.getById(id).getNoteId());
        note.setLikes(note.getLikes() - 1);
        return likeDao.delete(id) == 1 && noteService.updateNote(note);
    }

    @Override
    public boolean deleteNoteLikes(Integer noteId) {
        Like like = new Like();
        like.setNoteId(noteId);
        likeDao.deleteByConditions(like);

        Note note = noteService.getById(noteId);
        note.setLikes(0);
        return noteService.updateNote(note);
    }

    @Override
    public boolean isLikeRepeat(Integer userId, Integer noteId) {
        Like like = new Like();
        like.setUserId(userId);
        like.setNoteId(noteId);
        return likeDao.getByConditions(like) != null;
    }
}
