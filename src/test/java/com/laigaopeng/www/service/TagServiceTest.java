package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.Tag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TagServiceTest {

    @Autowired
    private TagService tagService;

    @Test
    public void testSave() {
        Tag tag = new Tag();
        tag.setName("tagSaveTest");
        tag.setDesc("tagSaveTest");

        boolean result = tagService.save(tag);
        System.out.println("com.laigaopeng.www.service.TagServiceTest.testSave: " + result);
    }

    @Test
    public void testDelete() {
        Tag tag = new Tag();
        tag.setName("tagDeleteTest");
        tag.setDesc("tagDeleteTest");
        tagService.save(tag);

        boolean result = tagService.delete(tag.getId());
        System.out.println("com.laigaopeng.www.service.TagServiceTest.testDelete: " + result);
    }

    @Test
    public void testUpdate() {
        Tag tag = new Tag();
        tag.setName("tagUpdateTest");
        tag.setDesc("tagUpdateTest");
        tagService.save(tag);

        tag.setDesc("AllForTest!!!");
        boolean result = tagService.update(tag);
        System.out.println("com.laigaopeng.www.service.TagServiceTest.testUpdate: " + result);
    }

    @Test
    public void testListAll() {
        Tag tag = new Tag();
        tag.setName("tagListTest");
        tag.setDesc("tagListTest");
        tagService.save(tag);

        List<Tag> tags = tagService.listAll();
        System.out.println("com.laigaopeng.www.service.TagServiceTest.testListAll: " + tags);
    }

    @Test
    public void testIsNameRepeat() {
        Tag tag = new Tag();
        tag.setName("tagRepeatTest");
        tag.setDesc("tagRepeatTest");
        tagService.save(tag);

        boolean resultNO = tagService.isNameRepeat("Jesus Christ");
        boolean resultYES = tagService.isNameRepeat(tag.getName());
        System.out.println("com.laigaopeng.www.service.TagServiceTest.testIsNameRepeat: " + "result1(shoule be no): " +
                resultNO + ", result2(shoule be yes): " + resultYES);
    }
}
