package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.Approval;
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
    public void testHandle() {
        Approval approval = new Approval();
        approval.setUserId(0);
        approval.setNoteId(0);
        approval.setContent("approvalHandleTest1");
        approvalService.save(approval);

        Approval approval2 = new Approval();
        approval2.setUserId(0);
        approval2.setNoteId(0);
        approval2.setContent("approvalHandleTest2");
        approvalService.save(approval2);

        /*approval.setResult(ApprovalEnum.PASSED.getResult());
        boolean result = approvalService.handle(approval);*/
    }
}
