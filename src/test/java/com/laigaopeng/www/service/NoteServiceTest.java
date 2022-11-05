package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.dao.NoteDao;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.util.enumhelper.NoteEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class NoteServiceTest {

    @Autowired
    private NoteDao noteDao;

    @Autowired
    private NoteService noteService;

    @Test
    public void testSave() {
        Note note = new Note();
        note.setTitle("noteSaveTest");
        note.setContent("noteSaveTest");
        note.setUserId(0);
        note.setSectionId(0);

        boolean result = noteService.save(note, null, "noteSaveTest");
        System.out.println("com.laigaopeng.www.service.NoteServiceTest.testSave: " + result);
    }

    @Test
    public void testUpdateNote() {
        Note note = new Note();
        note.setTitle("noteUpdateTest");
        note.setContent("noteUpdateTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteService.save(note, null,  "noteUpdateTest");

        note.setContent("AllForTest!!!");
        boolean result = noteService.updateNote(note);
        System.out.println("com.laigaopeng.www.service.NoteServiceTest.testUpdateNote: " + result);
    }

    @Test
    public void testDeleteNote() {
        Note note = new Note();
        note.setTitle("noteDeleteTest");
        note.setContent("noteDeleteTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteService.save(note, null,  "noteDeleteTest");

        boolean result = noteService.deleteNote(note.getId());
        System.out.println("com.laigaopeng.www.service.NoteServiceTest.testDeleteNote: " + result);
    }

    @Test
    public void testGetById() {
        Note note = new Note();
        note.setTitle("noteGetByIdTest");
        note.setContent("noteGetByIdTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteService.save(note, null,  "noteGetByIdTest");

        Note result = noteService.getById(note.getId());
        System.out.println("com.laigaopeng.www.service.NoteServiceTest.testGetById: " + result);
    }

    @Test
    public void testListAll() {
        Note note = new Note();
        note.setTitle("noteListAllTest");
        note.setContent("noteListAllTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteService.save(note, null,  "noteListAllTest");

        List<Note> notes = noteService.listAll();
        System.out.println("com.laigaopeng.www.service.NoteServiceTest.testListAll: " + notes);
    }

    @Test
    public void testListLegal() {
        Note note = new Note();
        note.setTitle("noteListLegalTest");
        note.setContent("noteListLegalTest");
        note.setUserId(0);
        note.setSectionId(0);
        noteService.save(note, null,  "noteListLegalTest");
        note.setLegal(NoteEnum.LEGAL.getCode());
        noteDao.update(note);

        List<Note> notes = noteService.listAll(NoteEnum.LEGAL.getCode());
        System.out.println("com.laigaopeng.www.service.NoteServiceTest.testListAllByLegal: " + notes);
    }

    @Test
    public void testListSectionNotes() {
        Note note = new Note();
        note.setTitle("noteListSectionTest");
        note.setContent("noteListSectionTest");
        note.setUserId(0);
        note.setSectionId(-1);
        noteService.save(note, null,  "noteListSectionTest");

        List<Note> notes = noteService.listSectionNotes(-1, 0);
        System.out.println("com.laigaopeng.www.service.NoteServiceTest.testListSectionNotes: " + notes);
    }

    @Test
    public void testListUserNotes() {
        Note note = new Note();
        note.setTitle("noteListUserTest");
        note.setContent("noteListUserTest");
        note.setUserId(-1);
        note.setSectionId(0);
        noteService.save(note, null,  "noteListLegalTest");

        List<Note> notes = noteService.listUserNotes(-1);
        System.out.println("com.laigaopeng.www.service.NoteServiceTest.testListUserNotes: " + notes);
    }
}
