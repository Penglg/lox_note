package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.dao.CollectDao;
import com.laigaopeng.www.dao.NoteDao;
import com.laigaopeng.www.pojo.Collect;
import com.laigaopeng.www.pojo.Note;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CollectServiceTest {

    @Autowired
    private NoteDao noteDao;
    @Autowired
    private CollectDao collectDao;

    @Autowired
    private CollectService collectService;

    @Test
    public void testSave() {
        Note note = new Note();
        note.setTitle("collectSaveTest");
        note.setContent("collectSaveTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteDao.save(note);

        boolean result = collectService.save(0, note.getId());
        System.out.println("com.laigaopeng.www.service.CollectServiceTest.testSave: " + result);
    }

    @Test
    public void testDelete() {
        // 新增笔记
        Note note = new Note();
        note.setTitle("collectDeleteTest");
        note.setContent("collectDeleteTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteDao.save(note);
        // 增加收藏
        Collect collect = new Collect();
        collect.setNoteId(note.getId());
        collect.setUserId(0);
        collectDao.save(collect);

        boolean result = collectService.delete(collect.getId());
        System.out.println("com.laigaopeng.www.service.CollectServiceTest.testDelete: " + result);
    }

    @Test
    public void testDeleteNoteCollects() {
        // 新增笔记
        Note note = new Note();
        note.setTitle("collectDeleteTest");
        note.setContent("collectDeleteTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteDao.save(note);
        // 增加收藏
        collectService.save(-3, note.getId());
        collectService.save(-2, note.getId());

        boolean result = collectService.deleteNoteCollects(note.getId());
        System.out.println("com.laigaopeng.www.service.CollectServiceTest.testDeleteNoteCollects: " + result);
    }

    @Test
    public void testIsCollectRepeat() {
        // 新增笔记
        Note note = new Note();
        note.setTitle("collectRepeatTest");
        note.setContent("collectRepeatTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteDao.save(note);
        collectService.save(0, note.getId());

        boolean result1 = collectService.isCollectRepeat(-10, -10);
        boolean result2 = collectService.isCollectRepeat(0, note.getId());
        System.out.println("com.laigaopeng.www.service.CollectServiceTest.testIsCollectRepeat: 获取不存在的结果: " +
                result1 + ", 获取存在的结果: " + result2);
    }
}
