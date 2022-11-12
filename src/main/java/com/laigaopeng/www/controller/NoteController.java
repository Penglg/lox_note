package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.Tag;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.NoteService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import com.laigaopeng.www.util.enumhelper.NoteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

/**
 * 笔记业务功能前端控制器
 *
 */
@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    /**
     * 获取所有的笔记
     * 包括合法和不合法的
     *
     * @return 结果
     */
    @GetMapping("/all")
    public Result list() {
        List<Note> notes = noteService.listAll();
        return new Result(notes, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取合法/不合法的笔记
     *
     * @param isLegal 是否合法
     * @return 结果
     */
    @GetMapping("/all/{isLegal}")
    public Result list(@PathVariable Integer isLegal) {
        if (EmptyCheckerUtil.isIntegerEmpty(isLegal) || (!isLegal.equals(NoteEnum.LEGAL.getCode())
                && !isLegal.equals(NoteEnum.ILLEGAL.getCode()))) // 参数不合法
                return new Result(false, CodeEnum.WRONG_PARAMETER.getCode(), CodeEnum.WRONG_PARAMETER.getMsg());
        List<Note> notes = noteService.listAll(isLegal);
        return new Result(notes, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取用户合法的笔记
     *
     * @param userId 用户主键
     * @return 结果
     */
    @GetMapping("/user/{userId}")
    public Result listUserLegalNotes(@PathVariable Integer userId) {
        List<Note> notes = noteService.listUserNotes(userId, NoteEnum.LEGAL.getCode());
        return new Result(notes, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取用户不合法笔记
     *
     * @param userId 用户主键
     * @return 结果
     */
    @GetMapping("/user/illegal/{userId}")
    public Result listUserIllegalNotes(@PathVariable(required = false) Integer userId) {
        if (EmptyCheckerUtil.isIntegerEmpty(userId)) // 参数不合法
            return new Result(false, CodeEnum.WRONG_PARAMETER.getCode(), CodeEnum.WRONG_PARAMETER.getMsg());
        List<Note> notes = noteService.listUserNotes(userId, NoteEnum.ILLEGAL.getCode());
        return new Result(notes, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 新增笔记
     *
     * @param note 笔记
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody Note note) {
        List<Integer> tagIds = new LinkedList<>();
        for (Tag tag : note.getTags()) {
            tagIds.add(tag.getId());
        }
        boolean result = noteService.save(note, tagIds, note.getApprovalContent());
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }
}
