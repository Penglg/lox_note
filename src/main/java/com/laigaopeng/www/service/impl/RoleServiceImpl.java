package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.RoleDao;
import com.laigaopeng.www.pojo.Role;
import com.laigaopeng.www.service.RoleService;
import com.laigaopeng.www.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean save(Role role) {
        return roleDao.save(role) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        if (!userRoleService.deleteRoleUser(id)) return false; // 删除角色和用户的对应
        return roleDao.delete(id) == 1;
    }

    @Override
    public boolean update(Role role) {
        return roleDao.update(role) == 1;
    }

    @Override
    public List<Role> listAll() {
        return roleDao.listAll();
    }
}
