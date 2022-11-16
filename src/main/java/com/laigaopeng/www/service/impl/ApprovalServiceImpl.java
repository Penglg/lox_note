package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.ApprovalDao;
import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.vo.Page;
import com.laigaopeng.www.service.ApprovalService;
import com.laigaopeng.www.service.NoteService;
import com.laigaopeng.www.util.enumhelper.ApprovalEnum;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import com.laigaopeng.www.util.enumhelper.NoteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 审批申请业务实现
 *
 */
@Service("approvalService")
public class ApprovalServiceImpl implements ApprovalService {
    @Autowired
    private ApprovalDao approvalDao;

    @Autowired
    private NoteService noteService;

    @Override
    public boolean save(Approval approval) {
        return approvalDao.save(approval) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        if (EmptyCheckerUtil.isIntegerEmpty(id)) return false;
        return approvalDao.delete(id) == 1;
    }

    @Override
    public boolean handle(Approval approval) {
        if (approval == null || approval.getResult().equals(ApprovalEnum.UNPROCESSED.getResult())) return false;

        if (approval.getResult().equals(ApprovalEnum.PASSED.getResult())) { // 审批通过的处理
            // 更新审批申请信息
            if (approvalDao.update(approval) != 1) return false;
            Note note = new Note();
            note.setId(approval.getNoteId());
            note.setLegal(NoteEnum.LEGAL.getCode());
            // 修改笔记为合法
            return noteService.updateNote(note);
        } else { // 审批不通过的处理
            return approvalDao.update(approval) == 1;
        }
    }

    @Override
    public Page<Approval> listUnprocessedBySectionId(Integer sectionId, Integer pageNum) {
        Page<Approval> page = new Page<>(pageNum, approvalDao.totalCountUnprocessed(sectionId));
        page.setItems(approvalDao.listUnprocessed(sectionId, page.getBegin(), page.getPageSize()));
        return page;
    }
}
