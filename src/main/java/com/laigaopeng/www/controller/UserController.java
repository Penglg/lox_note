package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.pojo.vo.Page;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.UserService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 用户业务功能前端控制器
 *
 */
@RestController("userController")
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * 登录成功则将用户放进session域中
     *
     * @param user 信息
     * @param session session
     * @return 结果
     */
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

    /**
     * 注册
     *
     * @param user 用户
     * @return 结果
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(@RequestBody User user) {
        boolean result = userService.save(user);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 检查重名重账号
     *
     * @param user user
     * @return 结果
     */
    @RequestMapping(value = "/check")
    public Result isNameOrAccountRepeat(@RequestBody User user) {
        boolean result = userService.ifRepeatByNameOrAccount(user.getName(), user.getAccount());
        return new Result(result, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 更新用户信息
     *
     * @param user 用户
     * @return 结果
     */
    @PutMapping
    public Result update(@RequestBody User user, HttpSession session) {
        User userObj = (User)session.getAttribute("user");
        if (userObj == null) return new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
        user.setId(userObj.getId());
        boolean result = userService.update(user);
        return result ?  new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
             new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }


    @GetMapping
    public Result listAll(@RequestParam Integer pageNum) {
        Page<User> page = userService.listAll(pageNum);
        return new Result(page, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    @PutMapping("/manage")
    public Result manage(@RequestBody User user) {
        boolean result = userService.manageUser(user.getId(), user.getDisabled());
        return result ?  new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }
}
