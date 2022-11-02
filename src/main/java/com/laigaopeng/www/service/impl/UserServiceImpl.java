package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.UserDao;
import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.service.UserRoleService;
import com.laigaopeng.www.service.UserService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import com.laigaopeng.www.util.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层实现类
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean save(User user) {
        // 是否重名或重账号
        if (ifRepeatByNameOrAccount(user.getName(), user.getAccount())) return false;
        userDao.save(user);
        User thisUser;
        if (userDao.save(user) == 1) {
            thisUser = userDao.getByAccount(user.getAccount());
            return userRoleService.saveUserRole(thisUser.getId(), RoleEnum.NORMAL_USER.getPermissionLevel());
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean ifRepeatByNameOrAccount(String name, String account) {
        User user = null;
        if (!EmptyCheckerUtil.isStringEmpty(name)) user = userDao.getByName(name);
        if (user != null) return true;
        if (!EmptyCheckerUtil.isStringEmpty(account)) user = userDao.getByAccount(account);
        return user != null;
    }

    @Override
    public User get(String account, String password) {
        return null;
    }

    @Override
    public boolean ban(Integer userId) {
        return false;
    }
}
