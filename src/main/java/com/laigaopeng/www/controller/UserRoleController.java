package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.UserRole;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.UserRoleService;
import com.laigaopeng.www.util.enumhelper.CodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户-角色绑定功能控制类
 *
 */
@RestController
@RequestMapping("/user_roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 新增用户-角色绑定
     *
     * @param userRole 用户角色绑定
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestParam UserRole userRole) {
        boolean result = userRoleService.save(userRole.getUserId(), userRole.getRoleId());
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除用户-角色绑定
     *
     * @param id 用户-角色
     * @return 结果
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = userRoleService.deleteUserRole(id);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    @DeleteMapping("/role/{roleId}}")
    public Result deleteRoleUser(@PathVariable Integer roleId) {
        boolean result = userRoleService.deleteRoleUser(roleId);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }
}
