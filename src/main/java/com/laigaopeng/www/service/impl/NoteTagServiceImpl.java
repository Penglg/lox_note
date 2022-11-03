package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.NoteTagDao;
import com.laigaopeng.www.pojo.NoteTag;
import com.laigaopeng.www.service.NoteTagService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteTagServiceImpl implements NoteTagService {

    @Autowired
    private NoteTagDao noteTagDao;

    @Override
    public boolean save(Integer noteId, Integer tagId) {
        NoteTag noteTag = new NoteTag();
        noteTag.setNoteId(noteId);
        noteTag.setTagId(tagId);
        return noteTagDao.save(noteTag) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return noteTagDao.delete(id) == 1;
    }

    @Override
    public boolean deleteNoteTags(Integer noteId) {
        NoteTag noteTag = new NoteTag();
        noteTag.setNoteId(noteId);
        return noteTagDao.deleteByConditions(noteTag) == 1;
    }
}
