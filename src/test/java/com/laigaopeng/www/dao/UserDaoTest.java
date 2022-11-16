package com.laigaopeng.www.dao;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserDaoTest {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("saveDaoTest");
        user.setAccount("saveDaoTest");
        user.setPassword("123456");
        user.setSex("男");
        int result = userDao.save(user);
        System.out.println("result:" + result);
        System.out.println("User.id:" + user.getId());
    }

    @Test
    public void testDelete() {
        int result = userDao.delete(2);
        System.out.println("result:" + result);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("testUpdate");
        user.setId(1);
        user.setPassword("testUpdate");
        int result = userDao.update(user);
        System.out.println("result:" + result);
    }

    @Test
    public void testGetById() {
        User user = userDao.getById(1);
        System.out.println(user);
    }

    @Test
    public void testListAll() {
        List<User> userList = userDao.listAll(0, 5);
        System.out.println(userList);
    }

    @Test
    public void testGetUserAndRoleById() {
        User user = userDao.getUserAndRolesById(1);
        System.out.println("user:" + user);
        System.out.println("roles:" + user.getRoles());
    }

    @Test
    public void testGetByAccount() {
        User user = userDao.getByAccount("111111");
        System.out.println("user:" + user);
    }

    @Test
    public void testGetByName() {
        User user = userDao.getByName("testUpdate");
        System.out.println("user:" + user);
    }
}
