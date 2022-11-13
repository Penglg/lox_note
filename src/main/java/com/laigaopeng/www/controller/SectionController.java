package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Section;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.SectionService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 分区控制类
 */
@RestController
@RequestMapping("/sections")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    /**
     * 保存分区
     *
     * @param section 分区
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody Section section) {
        boolean result = sectionService.save(section);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除分区
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = sectionService.delete(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 更新分区信息
     *
     * @param section 分区
     * @return 结果
     */
    @PutMapping
    public Result update(@RequestBody Section section) {
        boolean result = sectionService.update(section);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 获取所有分区
     *
     * @return 结果
     */
    @GetMapping
    public Result listAll() {
        List<Section> sections = sectionService.listAll();
        return new Result(sections, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    @GetMapping
    public Result isNameRepeat(@RequestParam String sectionName) {
        boolean result = sectionService.isNameRepeat(sectionName);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

}
