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
    public boolean save(Integer userId, Integer noteId) {
        if (EmptyCheckerUtil.isIntegerEmpty(userId) || EmptyCheckerUtil.isIntegerEmpty(noteId)) return false;
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setNoteId(noteId);
        // 笔记收藏量加1
        Note note = noteService.getById(noteId);
        note.setCollect(note.getCollect() + 1);
        return collectDao.save(collect) == 1 && noteService.updateNote(note);
    }

    @Override
    public boolean delete(Integer id) {
        if (EmptyCheckerUtil.isIntegerEmpty(id)) return false;
        // 笔记收藏量减1
        Note note = noteService.getById(id);
        note.setCollect(note.getCollect() - 1);
        return collectDao.delete(id) == 1 && noteService.updateNote(note);
    }

    @Override
    public boolean deleteNoteCollects(Integer noteId) {
        Collect collect = new Collect();
        collect.setNoteId(noteId);
        return collectDao.deleteByConditions(collect) == 1;
    }

    @Override
    public boolean isCollectRepeat(Integer userId, Integer noteId) {
        Collect collect = new Collect();
        collect.setUserId(userId);
        collect.setNoteId(noteId);
        return collectDao.getByConditions(collect) != null;
    }
}
