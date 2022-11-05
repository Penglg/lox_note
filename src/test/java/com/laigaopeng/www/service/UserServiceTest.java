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
}
