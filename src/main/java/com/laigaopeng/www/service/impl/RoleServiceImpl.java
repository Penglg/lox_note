package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.RoleDao;
import com.laigaopeng.www.pojo.Role;
import com.laigaopeng.www.service.RoleService;
import com.laigaopeng.www.service.UserRoleService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色业务功能实现
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean save(Role role) {
        // 判断是否重名
        if (isNameRepeat(role.getName())) return false;
        return roleDao.save(role) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        if (!userRoleService.deleteRoleUser(id)) return false; // 删除角色和用户的对应
        return roleDao.delete(id) == 1;
    }

    @Override
    public boolean update(Role role) {
        // 判断是否重名
        if ((!EmptyCheckerUtil.isStringEmpty(role.getName())) && isNameRepeat(role.getName())) {
            role.setName(roleDao.getById(role.getId()).getName());
        }
        return roleDao.update(role) == 1;
    }

    @Override
    public List<Role> listAll() {
        return roleDao.listAll();
    }

    @Override
    public boolean isNameRepeat(String name) {
        return roleDao.getByName(name) != null;
    }
}
