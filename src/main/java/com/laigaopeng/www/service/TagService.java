package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Tag;

import java.util.List;

/**
 * 标签业务逻辑层
 *
 */
public interface TagService {

    /**
     * 获取所有标签
     *
     * @return 查询结果
     */
    List<Tag> findAll();

    /**
     * 添加标签
     *
     * @param tag 标签
     * @return 执行结果
     */
    boolean save(Tag tag);

    /**
     * 删除标签
     *
     * @param id 标签主键
     * @return 执行结果
     */
    boolean delete(Integer id);

    /**
     * 修改标签名或描述
     *
     * @param name 标签名
     * @param desc 标签描述
     * @return 执行结果
     */
    boolean update(String name, String desc);
}
