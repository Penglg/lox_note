package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Approval;
import com.laigaopeng.www.pojo.vo.Page;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.ApprovalService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 审批申请业务控制层
 * 
 */
@RestController("approvalController")
@RequestMapping("/approvals")
public class ApprovalController {
    
    @Autowired
    private ApprovalService approvalService;

    /**
     * 增添申请
     *
     * @param approval 申请
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody Approval approval) {
        boolean result = approvalService.save(approval);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除申请
     *
     * @param id 申请
     * @return 结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean result = approvalService.delete(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 处理申请
     *
     * @param approval 申请
     * @return 结果
     */
    @PutMapping()
    public Result handle(@RequestBody Approval approval) {
        boolean result = approvalService.handle(approval);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    @GetMapping("/section/{sectionId}")
    public Result listAll(@PathVariable("sectionId") Integer sectionId, @RequestParam Integer pageNum) {
        Page<Approval> page = approvalService.listUnprocessedBySectionId(sectionId, pageNum);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }
}
