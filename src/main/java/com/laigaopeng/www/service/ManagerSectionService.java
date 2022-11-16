package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.ManagerSection;

/**
 * 区域管理员-区域绑定业务功能类
 *
 */
public interface ManagerSectionService {

    /**
     * 新增绑定
     *
     * @param userId 用户
     * @param sectionId 分区
     * @return 结果
     */
    boolean save(Integer userId, Integer sectionId);

    /**
     * 删除绑定
     *
     * @param managerSection 条件
     * @return 结果
     */
    boolean deleteByConditions(ManagerSection managerSection);

    /**
     * 根据id获取
     *
     * @param id id
     * @return 结果
     */
    ManagerSection getById(Integer id);

    /**
     * 根据用户id获取
     *
     * @param userId 用户id
     * @return 结果
     */
    ManagerSection getByUserId(Integer userId);

}
