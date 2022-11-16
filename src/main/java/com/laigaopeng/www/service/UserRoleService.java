package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.UserRole;
import org.springframework.transaction.annotation.Transactional;

public interface UserRoleService {

    /**
     * 设置用户角色
     *
     * @param userId 用户主键
     * @param roleId 角色主键
     * @return 执行结果
     */
    @Transactional
    boolean save(Integer userId, Integer roleId);

    /**
     * 删除用户和角色的绑定
     *
     * @param userRole 用户-角色绑定
     * @return 执行结果
     */
    @Transactional
    boolean deleteUserRole(UserRole userRole);

    /**
     * 删除角色及角色与用户的绑定
     *
     * @param roleId 角色主键
     * @return 执行结果
     */
    @Transactional
    boolean deleteRoleUser(Integer roleId);
}
