package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("saveTest");
        user.setAccount("saveTest");
        user.setPassword("saveTest");
        user.setSex("男");
        boolean result = userService.save(user);
        System.out.println("com.laigaopeng.www.service.UserServiceTest.testSave: " + result);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("updateTest");
        user.setAccount("updateTest");
        user.setPassword("updateTest");
        user.setSex("男");
        userService.save(user);

        // 修改
        user.setSex("女");
        boolean result = userService.update(user);
        System.out.println("com.laigaopeng.www.service.UserServiceTest.testUpdate:" + result);
    }

    @Test
    public void testIfRepeatByNameOrAccount() {
        User user = new User();
        user.setName("repeatNameTest");
        user.setAccount("repeatAccountTest");
        user.setPassword("repeatTest");
        user.setSex("男");
        userService.save(user);

        boolean result1 = userService.ifRepeatByNameOrAccount(user.getName(), user.getAccount());
        boolean result2 = userService.ifRepeatByNameOrAccount(user.getName(), null);
        boolean result3 = userService.ifRepeatByNameOrAccount(null, user.getAccount());

        System.out.println("com.laigaopeng.www.service.UserServiceTest.testIfRepeatByNameOrAccount: " +
                "result1(name and account):" + result1 + ", result2(name only):" + result2 + ", result3(" +
                "account only):" + result3);
    }

    @Test
    public void testGet() {
        User user = new User();
        user.setName("getTest");
        user.setAccount("getTest");
        user.setPassword("getTest");
        user.setSex("男");
        userService.save(user);

        User result = userService.get(user.getAccount(), user.getPassword());
        System.out.println("com.laigaopeng.www.service.UserServiceTest.testGet: " + result);
    }

    @Test
    public void testManageUser() {
        User user = new User();
        user.setName("manageTest");
        user.setAccount("manageTest");
        user.setPassword("manageTest");
        user.setSex("男");
        userService.save(user);

        boolean result = userService.manageUser(user.getId(), 1);
        User user1 = userService.get(user.getAccount(), user.getPassword());
        System.out.println("com.laigaopeng.www.service.UserServiceTest.testManageUser: " + result + ", " +
                "user.disabled: " + user1.getDisabled());
    }
}
