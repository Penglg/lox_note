package com.laigaopeng.www.service;

public interface UserRoleService {

    /**
     * 设置用户角色
     *
     * @param userId 用户主键
     * @param roleId 角色主键
     * @return 执行结果
     */
    boolean saveUserRole(Integer userId, Integer roleId);

    /**
     * 删除用户和角色的绑定
     *
     * @param id 用户-角色绑定主键
     * @return 执行结果
     */
    boolean deleteUserRole(Integer id);

    /**
     * 删除角色及角色与用户的绑定
     *
     * @param roleId 角色主键
     * @return 执行结果
     */
    boolean deleteRoleUser(Integer roleId);
}
