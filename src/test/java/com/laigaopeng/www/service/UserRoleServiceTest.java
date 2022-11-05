package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.dao.UserRoleDao;
import com.laigaopeng.www.pojo.UserRole;
import com.laigaopeng.www.util.enumhelper.RoleEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserRoleServiceTest {
    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void testSave() {
        boolean result = userRoleService.save(0, 0);
        System.out.println("com.laigaopeng.www.service.UserRoleServiceTest.testSave: " + result);
    }

    @Test
    public void testDeleteUserRole() {
        UserRole userRole = new UserRole();
        userRole.setUserId(0);
        userRole.setRoleId(-1);
        userRoleDao.save(userRole);
        boolean result = userRoleService.deleteUserRole(userRole.getId());
        System.out.println("com.laigaopeng.www.service.UserRoleServiceTest.testDeleteUserRole: " + result);
    }

    @Test
    public void testDeleteRoleUser() {
        userRoleService.save(0, -1);
        userRoleService.save(-1, -1);

        boolean result = userRoleService.deleteRoleUser(-1);
        System.out.println("com.laigaopeng.www.service.UserRoleServiceTest.testDeleteRoleUser: " + result);
    }
}
