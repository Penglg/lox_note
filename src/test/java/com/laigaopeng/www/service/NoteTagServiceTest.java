package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.dao.NoteTagDao;
import com.laigaopeng.www.pojo.NoteTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class NoteTagServiceTest {

    @Autowired
    private NoteTagDao noteTagDao;

    @Autowired
    private NoteTagService noteTagService;

    @Test
    public void testSave() {
        boolean result = noteTagService.save(0, 0);
        System.out.println("com.laigaopeng.www.service.NoteTagServiceTest.testSave: " + result);
    }

    @Test
    public void testDelete() {
        NoteTag noteTag = new NoteTag();
        noteTag.setNoteId(0);
        noteTag.setTagId(0);
        noteTagDao.save(noteTag);
        boolean result = noteTagService.delete(noteTag.getId());
        System.out.println("com.laigaopeng.www.service.NoteTagServiceTest.testDelete: " + result);
    }

    @Test
    public void testDeleteNoteTags() {
        noteTagService.save(-1, 0);
        noteTagService.save(-1, -1);
        noteTagService.save(-1, -2);

        boolean result = noteTagService.deleteNoteTags(-1);
        System.out.println("com.laigaopeng.www.service.NoteTagServiceTest.testDeleteNoteTags: " + result);
    }
}
