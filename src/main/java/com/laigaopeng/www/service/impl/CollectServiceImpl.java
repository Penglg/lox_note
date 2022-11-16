package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.CollectDao;
import com.laigaopeng.www.pojo.Collect;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.service.CollectService;
import com.laigaopeng.www.service.NoteService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 收藏业务功能实现
 *
 */
@Service("collectService")
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectDao collectDao;

    @Autowired
    private NoteService noteService;

    @Override
    public boolean save(Collect collect) {
        if (EmptyCheckerUtil.isIntegerEmpty(collect.getUserId()) || EmptyCheckerUtil.isIntegerEmpty(collect.getNoteId()))
            return false;
        if (isCollectRepeat(collect.getUserId(), collect.getNoteId())) return false;
        // 笔记收藏量加1
        Note note = noteService.getById(collect.getNoteId());
        note.setCollect(note.getCollect() + 1);
        return collectDao.save(collect) == 1 && noteService.updateNote(note);
    }

    @Override
    public boolean delete(Integer noteId, Integer userId) {
        if (EmptyCheckerUtil.isIntegerEmpty(noteId)) return false;
        Note note = noteService.getById(noteId);
        if (note != null) { // 收藏数减1
            note.setCollect(note.getCollect() - 1);
            noteService.updateNote(note);
        }

        Collect collect = new Collect();
        collect.setNoteId(noteId);
        collect.setUserId(userId);
        return collectDao.deleteByConditions(collect) == 1;
    }

    @Override
    public boolean deleteNoteCollects(Integer noteId) {
        Collect collect = new Collect();
        collect.setNoteId(noteId);
        Note note = noteService.getById(noteId);
        if (note != null) { // 将笔记收藏数置为0
            note.setCollect(0);
            noteService.updateNote(note);
            collectDao.deleteByConditions(collect);
        }
        return true;
    }

    @Override
    public boolean isCollectRepeat(Integer userId, Integer noteId) {
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setNoteId(noteId);
        return collectDao.getByConditions(collect) != null;
    }
}
