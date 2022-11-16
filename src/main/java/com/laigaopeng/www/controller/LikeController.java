package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Like;
import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.LikeService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 点赞功能控制层
 *
 */
@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Autowired
    private HttpSession session;

    /**
     * 保存点赞
     *
     * @param like 点赞
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody Like like) {
        User user = (User) session.getAttribute("user");
        like.setUserId(user.getId());
        boolean result = likeService.save(like);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 取消对笔记点赞
     *
     * @param noteId 笔记
     * @return 结果
     */
    @DeleteMapping("/{noteId}")
    public Result delete(@PathVariable Integer noteId) {
        User user = (User) session.getAttribute("user");
        boolean result = likeService.delete(noteId, user.getId());
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false ,CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除笔记下所有的点赞
     *
     * @param noteId 笔记
     * @return 结果
     */
    @DeleteMapping("/note_like/{noteId}")
    public Result deleteNoteLikes(@PathVariable Integer noteId) {
        boolean result = likeService.deleteNoteLikes(noteId);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false ,CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 判断是否重复点赞
     *
     * @param like 点赞
     * @return 结果
     */
    @PostMapping("/check")
    public Result isLikeRepeat(@RequestBody Like like) {
        boolean result = likeService.isLikeRepeat(like.getUserId(), like.getNoteId());
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false ,CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }
}
