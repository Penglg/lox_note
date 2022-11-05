package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.CommentDao;
import com.laigaopeng.www.pojo.Comment;
import com.laigaopeng.www.service.CommentService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评论业务功能实现
 *
 */
@Service("commentService")
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

    @Override
    public boolean deleteNoteComments(Integer noteId) {
        if (EmptyCheckerUtil.isIntegerEmpty(noteId)) return false;
        Comment comment = new Comment();
        comment.setNoteId(noteId);
        commentDao.deleteByConditions(comment);
        return true;
    }
}
