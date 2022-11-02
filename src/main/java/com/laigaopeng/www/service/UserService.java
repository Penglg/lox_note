package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务逻辑层
 *
 */
public interface UserService {
    /**
     * 新增用户
     *
     * @param user user
     * @return 执行成功结果
     */
    @Transactional
    boolean save(User user);

    /**
     * 用户更新信息
     *
     * @param user user
     * @return 执行成功结果
     */
    @Transactional
    boolean update(User user);

    /**
     * 查询用户昵称及账号是否重复
     *
     * @param name name
     * @param account account
     * @return 是否重复，重复为1，不重复为0
     */
    boolean ifRepeatByNameOrAccount(String name, String account);

    /**
     * 根据账号密码获取用户
     *
     * @param account 账号
     * @param password 密码
     * @return 获取结果
     */
    User get(String account, String password);

    /**
     * 禁止或解禁用户发布笔记的功能
     *
     * @param userId 用户主键
     * @return 禁止结果
     */
    @Transactional
    boolean manageUser(Integer userId, Integer disabled);
}
