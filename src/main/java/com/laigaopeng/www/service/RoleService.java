package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Role;

import java.util.List;

public interface RoleService {

    /**
     * 新增角色
     *
     * @param role 角色信息
     * @return 执行结果
     */
    boolean save(Role role);

    /**
     * 删除角色
     *
     * @param id 角色主键
     * @return 执行结果
     */
    boolean delete(Integer id);

    /**
     * 更新角色信息
     *
     * @param role 角色
     * @return 执行结果
     */
    boolean update(Role role);

    /**
     * 获取所有角色
     *
     * @return 查询结果
     */
    List<Role> listAll();
}
