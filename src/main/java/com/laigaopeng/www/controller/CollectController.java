package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Collect;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.CollectService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评论功能控制类
 *
 */
@RestController
@RequestMapping("/collects")
public class CollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 保存评论
     *
     * @param collect 评论
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody Collect collect) {
        boolean result = collectService.save(collect);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除评论
     *
     * @param id 评论
     * @return 结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = collectService.delete(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除笔记下所有评论
     *
     * @param noteId 评论
     * @return 结果
     */
    @DeleteMapping("/note_collects/{noteId}")
    public Result deleteNoteCollects(@PathVariable Integer noteId) {
        boolean result = collectService.deleteNoteCollects(noteId);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 检查是否重复收藏
     *
     * @param collect 收藏
     * @return 结果
     */
    @PostMapping("/check")
    public Result isCollectRepeat(@RequestBody Collect collect) {
        boolean result = collectService.isCollectRepeat(collect.getUserId(), collect.getNoteId());
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }
}
