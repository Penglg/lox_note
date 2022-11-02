package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.LikeDao;
import com.laigaopeng.www.pojo.Like;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.service.LikeService;
import com.laigaopeng.www.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

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
        Note note = noteService.getById(noteId);
        note.setLikes(note.getLikes() + 1);
        return likeDao.save(like) == 1 && noteService.updateNote(note);
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
