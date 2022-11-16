package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.pojo.vo.Page;
import org.springframework.transaction.annotation.Transactional;

/**
 * 审批申请业务逻辑层
 *
 */
public interface ApprovalService {
    /**
     * 发出审批申请
     *
     * @param approval 审批申请
     * @return 执行结果
     */
    @Transactional
    boolean save(Approval approval);

    /**
     * 删除审批申请
     *
     * @param id 审批申请id
     * @return 执行结果
     */
    @Transactional
    boolean delete(Integer id);

    /**
     * 审批
     *
     * @param approval 审批申请
     * @return 执行结果
     */
    @Transactional
    boolean handle(Approval approval);

    /**
     * 获取分区所有笔记的申请
     *
     * @param sectionId 分区
     * @param pageNum 页数
     * @return 结果
     */
    Page<Approval> listUnprocessedBySectionId(Integer sectionId, Integer pageNum);
}
