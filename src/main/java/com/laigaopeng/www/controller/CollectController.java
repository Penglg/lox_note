package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Collect;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.CollectService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/collects")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @PostMapping
    public Result save(@RequestBody Collect collect) {
        boolean result = collectService.save(collect);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = collectService.delete(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    @DeleteMapping("/note_collects/{noteId}")
    public Result deleteNoteCollects(@PathVariable Integer noteId) {
        boolean result = collectService.deleteNoteCollects(noteId);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }
}
