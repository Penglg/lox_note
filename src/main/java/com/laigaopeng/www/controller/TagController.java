package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Tag;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.TagService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签控制控制器类
 *
 */
@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 保存标签
     *
     * @param tag
     * @return
     */
    @PostMapping
    public Result save(@RequestBody Tag tag) {
        boolean result = tagService.save(tag);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除标签
     *
     * @param id 标签id
     * @return 结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = tagService.delete(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 更新标签信息
     *
     * @param tag 标签
     * @return 结果
     */
    @PutMapping
    public Result update(@RequestBody Tag tag) {
        boolean result = tagService.update(tag);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 获取所有标签
     *
     * @return 结果
     */
    @GetMapping
    public Result listAll() {
        List<Tag> tagList = tagService.listAll();
        return new Result(tagList, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 检查标签是否重名
     *
     * @param name 标签名
     * @return 结果
     */
    @GetMapping("/check")
    public Result isNameRepeat(@RequestParam String name) {
        boolean result = tagService.isNameRepeat(name);
        return new Result(result, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }
}
