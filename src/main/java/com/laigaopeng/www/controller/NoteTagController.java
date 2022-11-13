package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.NoteTag;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.NoteTagService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 笔记标签控制层
 *
 */
@RestController
@RequestMapping("/note_tags")
public class NoteTagController {

    @Autowired
    private NoteTagService noteTagService;

    /**
     * 保存笔记和标签的绑定
     *
     * @return
     */
    @PostMapping
    public Result save(@RequestBody NoteTag noteTag) {
        boolean result = noteTagService.save(noteTag);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除笔记和标签的绑定
     *
     * @param id 笔记和标签的绑定
     * @return 结果
     */
    @RequestMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = noteTagService.delete(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除笔记的所有标签
     *
     * @param noteId 笔记
     * @return 结果
     */
    @RequestMapping("/note_note_tags/{noteId}")
    public Result deleteNoteTags(@PathVariable Integer noteId) {
        boolean result = noteTagService.deleteNoteTags(noteId);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }
}
