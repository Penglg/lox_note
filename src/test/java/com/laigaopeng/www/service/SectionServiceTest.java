package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.Section;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SectionServiceTest {

    @Autowired
    private SectionService sectionService;

    @Test
    public void testSave() {
        Section section = new Section();
        section.setName("sectionSaveTest");
        section.setDesc("sectionSaveTest");
        boolean result = sectionService.save(section);
        System.out.println("com.laigaopeng.www.service.SectionServiceTest.testSave: " + result + ", " +
                "section.id:" + section.getId());
    }

    @Test
    public void testUpdate() {
        Section section = new Section();
        section.setName("sectionUpdateTest");
        section.setDesc("sectionUpdateTest");
        sectionService.save(section);

        section.setDesc("AllForTest!");
        boolean result = sectionService.update(section);
        System.out.println("com.laigaopeng.www.service.SectionServiceTest.testUpdate: " + result);
    }

    @Test
    public void testIsNameRepeat() {
        Section section = new Section();
        section.setName("sectionRepeatTest");
        section.setDesc("sectionRepeatTest");
        sectionService.save(section);

        boolean resultForNot = sectionService.isNameRepeat("Jesus Christ");
        boolean resultForYes = sectionService.isNameRepeat(section.getName());
        System.out.println("com.laigaopeng.www.service.SectionServiceTest.testIsNameRepeat: " + "result(shouldBeNot):" +
                resultForNot + ", result(should be yes):" + resultForYes);
    }

    @Test
    public void testDelete() {
        Section section = new Section();
        section.setName("sectionDeleteTest");
        section.setDesc("sectionDeleteTest");
        sectionService.save(section);

        boolean result = sectionService.delete(section.getId());
        System.out.println("com.laigaopeng.www.service.SectionServiceTest.testDelete: " + result);
    }

    @Test
    public void testListAll() {
        Section section = new Section();
        section.setName("sectionListTest1");
        section.setDesc("sectionListTest1");
        sectionService.save(section);

        section.setName("sectionListTest2");
        section.setDesc("sectionListTest2");
        sectionService.save(section);

        List<Section> sections = sectionService.listAll();
        System.out.println("com.laigaopeng.www.service.SectionServiceTest.testListAll: " + sections);
    }
}
