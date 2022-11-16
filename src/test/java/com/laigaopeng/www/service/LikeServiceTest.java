package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.dao.LikeDao;
import com.laigaopeng.www.dao.NoteDao;
import com.laigaopeng.www.pojo.Like;
import com.laigaopeng.www.pojo.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class LikeServiceTest {

    @Autowired
    private NoteDao noteDao;
    @Autowired
    private LikeDao likeDao;

    @Autowired
    private LikeService likeService;

    @Test
    public void testSave() {
        Note note = new Note();
        note.setTitle("likeSaveTest");
        note.setContent("likeSaveTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteDao.save(note);

        Like like = new Like();
        like.setUserId(0);
        like.setNoteId(note.getId());
        boolean result = likeService.save(like);
        System.out.println("com.laigaopeng.www.service.LikeServiceTest.testSave: " + result);
    }

    @Test
    public void testDelete() {
        Note note = new Note();
        note.setTitle("likeDeleteTest");
        note.setContent("likeDeleteTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteDao.save(note);

        Like like = new Like();
        like.setNoteId(note.getId());
        like.setUserId(0);
        likeDao.save(like);

        boolean result = likeService.delete(like.getId(), 0);
        System.out.println("com.laigaopeng.www.service.LikeServiceTest.testDelete: " + result);
    }

    @Test
    public void testDeleteNoteLikes() {
        Note note = new Note();
        note.setTitle("likeDeleteTest");
        note.setContent("likeDeleteTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteDao.save(note);

        Like like = new Like();
        like.setUserId(-2);
        like.setNoteId(note.getId());
        likeService.save(like);
        Like like1 = new Like();
        like1.setUserId(-3);
        like1.setNoteId(note.getId());
        likeService.save(like1);

        boolean result = likeService.deleteNoteLikes(note.getId());
        System.out.println("com.laigaopeng.www.service.LikeServiceTest.testDeleteNoteLikes: " + result);
    }

    @Test
    public void testIsLikeRepeat() {
        Note note = new Note();
        note.setTitle("likeRepeatTest");
        note.setContent("likeRepeatTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteDao.save(note);

        Like like = new Like();
        like.setUserId(0);
        like.setNoteId(note.getId());
        likeService.save(like);

        boolean result1 = likeService.isLikeRepeat(-10, -10);
        boolean result2 = likeService.isLikeRepeat(0, note.getId());
        System.out.println("com.laigaopeng.www.service.LikeServiceTest.testIsLikeRepeat: 获取不存在的结果: " +
                result1 + ", 获取存在的结果: " + result2);
    }
}
