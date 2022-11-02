package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Approval;

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
    boolean save(Approval approval);

    /**
     * 删除审批申请
     *
     * @param id 审批申请id
     * @return 执行结果
     */
    boolean delete(Integer id);

    /**
     * 审批
     *
     * @param approval 审批申请
     * @return 执行结果
     */
    boolean handle(Approval approval);
}
