package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.Role;
import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.RoleService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 角色功能控制器类
 *
 */
@RestController("roleController")
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private HttpSession session;

    /**
     * 保存角色
     *
     * @param role 角色
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody Role role) {
        boolean result = roleService.save(role);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除角色
     *
     * @param id 角色id
     * @return 结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = roleService.delete(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 更新角色信息
     *
     * @param role 角色
     * @return Result
     */
    @PutMapping
    public Result update(@RequestBody Role role) {
        boolean result = roleService.update(role);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 获取所有角色信息
     *
     * @return 结果
     */
    @GetMapping
    public Result listAll() {
        List<Role> roleList = roleService.listAll();
        return new Result(roleList, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 查询角色名是否重复
     *
     * @param name 名
     * @return 结果
     */
    @GetMapping("/check")
    public Result isNameRepeat(@RequestParam String name) {
        boolean result = roleService.isNameRepeat(name);
        return new Result(result, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }

    /**
     * 获取用户角色
     *
     * @return
     */
    @GetMapping("/user")
    public Result ListUserRoles() {
        User user = (User) session.getAttribute("user");
        List<Role> roleList = user.getRoles();
        return new Result(roleList, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }
}
