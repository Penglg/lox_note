package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.Tag;
import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.pojo.vo.Page;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.NoteService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import com.laigaopeng.www.util.enumhelper.NoteEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;

/**
 * 笔记业务功能前端控制器
 *
 */
@RestController("noteController")
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
    public Result list(@RequestParam Integer pageNum) {
        Page<Note> page = noteService.listAll(pageNum);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取合法/不合法的笔记
     *
     * @param isLegal 是否合法
     * @return 结果
     */
    @GetMapping("/all/{isLegal}")
    public Result list(@PathVariable Integer isLegal, @RequestParam Integer pageNum) {
        if (EmptyCheckerUtil.isIntegerEmpty(isLegal) || (!isLegal.equals(NoteEnum.LEGAL.getCode())
                && !isLegal.equals(NoteEnum.ILLEGAL.getCode()))) // 参数不合法
                return new Result(false, CodeEnum.WRONG_PARAMETER.getCode(), CodeEnum.WRONG_PARAMETER.getMsg());
        Page<Note> page = noteService.listAll(pageNum, isLegal);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取用户合法的笔记
     *
     * @param session session域中存有user
     * @return 结果
     */
    @GetMapping("/my_notes/legal")
    public Result listUserLegalNotes(@RequestParam Integer pageNum, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Page<Note> page = noteService.listUserNotes(user.getId(), NoteEnum.LEGAL.getCode(), pageNum);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取用户不合法笔记
     *
     * @param session session域中存有user
     * @return 结果
     */
    @GetMapping("/my_notes/illegal")
    public Result listUserIllegalNotes(HttpSession session) {
        User user = (User) session.getAttribute("user");
        Page<Note> page = noteService.listUserNotes(user.getId(), NoteEnum.ILLEGAL.getCode(), 1);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 新增笔记
     *
     * @param session session域中存有user
     * @param note 笔记
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody Note note, HttpSession session) {
        User user = (User)session.getAttribute("user");
        note.setUserId(user.getId());
        List<Integer> tagIds = new LinkedList<>();
        for (Tag tag : note.getTags()) {
            tagIds.add(tag.getId());
        }
        boolean result = noteService.save(note, tagIds, note.getApprovalContent());
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }


    /**
     * 更新笔记信息
     *
     * @param note 笔记
     * @return 结果
     */
    @PutMapping
    public Result update(@RequestBody Note note) {
        boolean result = noteService.updateNote(note);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除笔记
     *
     * @param id 笔记主键
     * @return 结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = noteService.deleteNote(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 获取指定笔记
     *
     * @param id 笔记主键
     * @return 结果
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable int id) {
        Note note = noteService.getById(id);
        return note != null ? new Result(note, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(null, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 获取分区内笔记
     *
     * @param id 分区id
     * @return 结果
     */
    @GetMapping("/section/{id}")
    public Result listSectionNotes(@PathVariable Integer id, @RequestParam(value = "isLegal", required = false,
            defaultValue = "1") int isLegal, @RequestParam Integer pageNum) {
        Page<Note> page = noteService.listSectionNotes(id, isLegal, pageNum);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取用户点赞笔记
     *
     * @param session session域中存有user
     * @return 结果
     */
    @GetMapping("/my_notes/like")
    public Result listLikeNotes(@RequestParam Integer pageNum, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Page<Note> page = noteService.listLikeNotes(user.getId(), pageNum);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取用户收藏笔记
     *
     * @param session session域中存有user
     * @return 结果
     */
    @GetMapping("/my_notes/collect")
    public Result listCollectNotes(@RequestParam Integer pageNum, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Page<Note> page = noteService.listCollectNotes(user.getId(), pageNum);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }
}
