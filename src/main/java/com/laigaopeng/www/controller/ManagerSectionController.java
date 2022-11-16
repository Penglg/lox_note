package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.ManagerSection;
import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.ManagerSectionService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/managerSections")
public class ManagerSectionController {

    @Autowired
    private ManagerSectionService msService;

    @Autowired
    private HttpSession session;

    @GetMapping
    public Result get() {
        User user = (User) session.getAttribute("user");
        ManagerSection ms = msService.getByUserId(user.getId());
        return ms != null ? new Result(ms, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(null, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }
}
