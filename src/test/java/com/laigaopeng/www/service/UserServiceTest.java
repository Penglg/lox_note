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
    public void save() {
        User user = new User();
        user.setName("saveTest");
        user.setAccount("saveTest");
        user.setPassword("saveTest");
        user.setSex("男");
        Boolean result = userService.save(user);
        System.out.println("com.laigaopeng.www.service.UserServiceTest.save: " + result);
    }
}
