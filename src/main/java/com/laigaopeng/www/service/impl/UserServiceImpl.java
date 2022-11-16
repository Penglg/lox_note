package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.UserDao;
import com.laigaopeng.www.exception.BusinessException;
import com.laigaopeng.www.pojo.User;
import com.laigaopeng.www.pojo.vo.Page;
import com.laigaopeng.www.service.UserRoleService;
import com.laigaopeng.www.service.UserService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import com.laigaopeng.www.util.enumhelper.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务层实现类
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public boolean save(User user) {
        // 是否重名或重账号
        if (ifRepeatByNameOrAccount(user.getName(), user.getAccount())) throw new BusinessException();
        if (userDao.save(user) == 1) {
            return userRoleService.save(user.getId(), RoleEnum.NORMAL_USER.getPermissionLevel());
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        if (EmptyCheckerUtil.isIntegerEmpty(user.getId())) throw new BusinessException();
        return userDao.update(user) == 1;
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
        if (EmptyCheckerUtil.isStringEmpty(account) || EmptyCheckerUtil.isStringEmpty(password)) throw new BusinessException();
        return userDao.getByAccAndPwd(account, password);
    }

    @Override
    public boolean manageUser(Integer userId, Integer disabled) {
        if (EmptyCheckerUtil.isIntegerEmpty(userId) || EmptyCheckerUtil.isIntegerEmpty(disabled)) throw new BusinessException();
        User target = new User();
        target.setId(userId);
        target.setDisabled(disabled);
        return userDao.update(target) == 1;
    }

    @Override
    public Page<User> listAll(Integer pageNum) {
        Page<User> page = new Page<>(pageNum, userDao.totalRecord());
        page.setItems(userDao.listAll(page.getBegin(), page.getPageSize()));
        return page;
    }
}
