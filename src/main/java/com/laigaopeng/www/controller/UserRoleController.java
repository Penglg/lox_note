package com.laigaopeng.www.controller;

import com.laigaopeng.www.pojo.UserRole;
import com.laigaopeng.www.pojo.vo.Result;
import com.laigaopeng.www.service.ManagerSectionService;
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

    @Autowired
    private ManagerSectionService msService;

    /**
     * 新增用户-角色绑定
     *
     * @param userRole 用户角色绑定
     * @return 结果
     */
    @PostMapping
    public Result save(@RequestBody UserRole userRole, @RequestParam Integer sectionId) {
        boolean result = userRoleService.save(userRole.getUserId(), userRole.getRoleId()) &&
                msService.save(userRole.getUserId(), sectionId);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    /**
     * 删除分区管理员
     *
     * @param userRole 用户-角色绑定
     * @return 结果
     */
    @DeleteMapping("/section_manager/delete/{sectionId}")
    public Result delete(@RequestBody UserRole userRole, @PathVariable Integer sectionId) {
        boolean result = msService.deleteByConditions(userRole.getUserId(), sectionId) &&
                userRoleService.deleteUserRole(userRole);
        return result ? new Result(true, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg()) :
                new Result(false, CodeEnum.FAIL.getCode(), CodeEnum.FAIL.getMsg());
    }

    @DeleteMapping("/role/{roleId}")
    public Result deleteRoleUser(@PathVariable Integer roleId) {
        boolean result = userRoleService.deleteRoleUser(roleId);
        return new Result(result, CodeEnum.SUCCESS.getCode(), CodeEnum.SUCCESS.getMsg());
    }
}
