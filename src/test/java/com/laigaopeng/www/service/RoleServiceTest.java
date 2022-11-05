package com.laigaopeng.www.service;

import com.laigaopeng.www.config.SpringConfig;
import com.laigaopeng.www.pojo.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testSave() {
        Role role = new Role();
        role.setName("roleSaveTest");
        role.setDesc("roleSaveTest");
        role.setPermissionLevel(0);

        boolean result = roleService.save(role);
        System.out.println("com.laigaopeng.www.service.RoleServiceTest.testSave: " + result);
    }

    @Test
    public void testDelete() {
        Role role = new Role();
        role.setName("roleDeleteTest");
        role.setDesc("roleDeleteTest");
        role.setPermissionLevel(0);
        roleService.save(role);

        boolean result = roleService.delete(role.getId());
        System.out.println("com.laigaopeng.www.service.RoleServiceTest.testDelete: " + result);
    }

    @Test
    public void testUpdate() {
        Role role = new Role();
        role.setName("roleUpdateTest");
        role.setDesc("roleUpdateTest");
        role.setPermissionLevel(0);
        roleService.save(role);

        role.setDesc("AllForTest!!!");
        boolean result = roleService.update(role);
        System.out.println("com.laigaopeng.www.service.RoleServiceTest.testUpdate: " + result);
    }

    @Test
    public void testListAll() {
        Role role = new Role();
        role.setName("roleListTest");
        role.setDesc("roleListTest");
        role.setPermissionLevel(0);
        roleService.save(role);

        List<Role> roles = roleService.listAll();
        System.out.println("com.laigaopeng.www.service.RoleServiceTest.testListAll: " + roles);
    }

    @Test
    public void testIsNameRepeat() {
        Role role = new Role();
        role.setName("roleRepeatTest");
        role.setDesc("roleRepeatTest");
        role.setPermissionLevel(0);
        roleService.save(role);

        boolean result1 = roleService.isNameRepeat("Jesus Christ");
        boolean result2 = roleService.isNameRepeat(role.getName());
        System.out.println("com.laigaopeng.www.service.RoleServiceTest.testIsNameRepeat: result1(should be no): " +
                result1 + ", result2(should be yes):" + result2);
    }
}