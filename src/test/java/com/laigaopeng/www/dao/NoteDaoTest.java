package com.laigaopeng.www.dao;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.vo.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class NoteDaoTest {

    @Autowired
    private NoteDao noteDao;

    @Test
    public void testPages() {
        Page<Note> page = new Page<>();
        page.setPageNum(2);
        page.setPageSize(3);
        page.setRecordSum(noteDao.recordTotalCount());
        page.setPageSum(page.getRecordSum() / page.getPageSize() + ((page.getRecordSum() % page.getPageSize() != 0) ? 1 : 0));
        page.setItems(noteDao.listAllInPages((page.getPageNum() - 1) % page.getPageSize(), page.getPageSize()));

        System.out.println(page.getItems());
    }
}
