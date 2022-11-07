package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.util.enumhelper.ApprovalEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ApprovalServiceTest {

    @Autowired
    private ApprovalService approvalService;
    @Autowired
    private NoteService noteService;

    @Test
    public void testSave() {
        Approval approval = new Approval();
        approval.setUserId(0);
        approval.setNoteId(0);
        approval.setContent("approvalSaveTest");

        boolean result = approvalService.save(approval);
        System.out.println("com.laigaopeng.www.service.ApprovalServiceTest.testSave: " + result);
    }

    @Test
    public void testDelete() {
        Approval approval = new Approval();
        approval.setUserId(0);
        approval.setNoteId(0);
        approval.setContent("approvalDeleteTest");
        approvalService.save(approval);

        boolean result = approvalService.delete(approval.getId());
        System.out.println("com.laigaopeng.www.service.ApprovalServiceTest.testDelete: " + result);
    }

    @Test
    public void testHandle() {
        Note note1 = new Note();
        note1.setTitle("approvalHandleTest1");
        note1.setContent("approvalHandleTest1");
        note1.setUserId(0);
        note1.setSectionId(0);
        noteService.save(note1, null, "approvalHandleTest1");
        Approval approval1 = new Approval();
        approval1.setUserId(0);
        approval1.setNoteId(note1.getId());
        approval1.setContent("approvalHandleTest1");
        approvalService.save(approval1);

        Note note2 = new Note();
        note2.setTitle("approvalHandleTest2");
        note2.setContent("approvalHandleTest2");
        note2.setUserId(0);
        note2.setSectionId(0);
        noteService.save(note2, null, "approvalHandleTest2");
        Approval approval2 = new Approval();
        approval2.setUserId(0);
        approval2.setNoteId(note2.getId());
        approval2.setContent("approvalHandleTest2");
        approvalService.save(approval2);

        // 审批通过
        approval1.setResult(ApprovalEnum.PASSED.getResult());
        boolean resultOfYes = approvalService.handle(approval1);
        // 审批不通过
        approval2.setResult(ApprovalEnum.NOT_PASSED.getResult());
        boolean resultOfNo = approvalService.handle(approval2);
        System.out.println("com.laigaopeng.www.service.ApprovalServiceTest.testHandle: result1(passed): " +
                resultOfYes + ", result2(not passed): " + resultOfNo);
    }
}
