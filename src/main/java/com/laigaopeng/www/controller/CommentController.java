package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Comment;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.CommentService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论业务功能控制层
 *
 */
@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 新增评论
     *
     * @param comment 评论
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody Comment comment) {
        boolean result = commentService.save(comment);
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
    public Result delete(@PathVariable int id) {
        boolean result = commentService.delete(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 获取笔记所有评论
     *
     * @param noteId 评论
     * @return 结果
     */
    @GetMapping("/note/{noteId}")
    public Result listNoteComments(@PathVariable Integer noteId) {
        if (EmptyCheckerUtil.isIntegerEmpty(noteId)) return new Result(null, CodeEnum.FAIL.getCode(),
                                                                        CodeEnum.FAIL.getMsg());
        List<Comment> comments = commentService.listNoteComments(noteId);
        return new Result(comments, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 删除笔记下所有评论
     *
     * @param noteId 评论
     * @return 结果
     */
    @DeleteMapping("/note/{noteId}")
    public Result deleteNoteComments(@PathVariable Integer noteId) {
        if (EmptyCheckerUtil.isIntegerEmpty(noteId)) return new Result(null, CodeEnum.FAIL.getCode(),
                CodeEnum.FAIL.getMsg());
        boolean result = commentService.deleteNoteComments(noteId);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }
}
