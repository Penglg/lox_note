package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.UserService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(@RequestBody User user, HttpSession session) {
        User targetUser = userService.get(user.getAccount(), user.getPassword());
        if (targetUser != null) {
            // 设置返回码和信息
            session.setAttribute("user", targetUser);
            return new Result(targetUser, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
        } else {
            session.setAttribute("user", null);
            return new Result(null, CodeEnum.FAIL.getCode(), CodeEnum.SUCCESS.getMsg());
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody User user) {
        boolean result = userService.save(user);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    @RequestMapping(value = "/check")
    public Result isNameOrAccountRepeat(@RequestBody User user) {
        boolean result = userService.ifRepeatByNameOrAccount(user.getName(), user.getAccount());
        return new Result(result, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    @PutMapping
    public Result update(@RequestBody User user) {
        boolean result = userService.update(user);
        return new Result(result, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }
}
