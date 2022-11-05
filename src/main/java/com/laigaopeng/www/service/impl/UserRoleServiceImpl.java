package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.UserRoleDao;
import com.laigaopeng.www.pojo.UserRole;
import com.laigaopeng.www.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色-用户绑定业务功能实现
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public boolean save(Integer userId, Integer roleId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        return userRoleDao.save(userRole) == 1;
    }

    @Override
    public boolean deleteUserRole(Integer id) {
        return userRoleDao.delete(id) == 1;
    }

    @Override
    public boolean deleteRoleUser(Integer roleId) {
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRoleDao.deleteByConditions(userRole);
        return true;
    }
}
