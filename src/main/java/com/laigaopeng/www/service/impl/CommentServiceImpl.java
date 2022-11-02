package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.CommentDao;
import com.laigaopeng.www.pojo.Comment;
import com.laigaopeng.www.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public boolean save(Comment comment) {
        return commentDao.save(comment) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return commentDao.delete(id) == 1;
    }

    @Override
    public List<Comment> listNoteComments(Integer noteId) {
        return commentDao.listByNoteId(noteId);
    }
}
