package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CommentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    public void testSave() {
        Comment comment = new Comment();
        comment.setNoteId(0);
        comment.setUserId(0);
        comment.setContent("commentSaveTest");

        boolean result = commentService.save(comment);
        System.out.println("com.laigaopeng.www.service.CommentServiceTest.testSave: " + result);
    }

    @Test
    public void testDelete() {
        Comment comment = new Comment();
        comment.setNoteId(0);
        comment.setUserId(0);
        comment.setContent("commentDeleteTest");
        commentService.save(comment);

        boolean result = commentService.delete(comment.getId());
        System.out.println("com.laigaopeng.www.service.CommentServiceTest.testDelete: " + result);
    }

    @Test
    public void testListNoteComments() {
        Comment comment = new Comment();
        comment.setNoteId(-1);
        comment.setUserId(0);
        comment.setContent("commentDeleteTest");
        commentService.save(comment);

        List<Comment> comments = commentService.listNoteComments(-1);
        System.out.println("com.laigaopeng.www.service.CommentServiceTest.testListNoteComments: " + comments);
    }

    @Test
    public void testDeleteNoteComments() {
        Comment comment = new Comment();
        comment.setNoteId(-1);
        comment.setUserId(0);
        comment.setContent("commentDeleteTest");
        commentService.save(comment);

        boolean result = commentService.deleteNoteComments(-1);
        System.out.println("com.laigaopeng.www.service.CommentServiceTest.testDeleteNoteComments: " + result);
    }
}
