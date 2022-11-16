package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Tag;
import org.springframework.transaction.annotation.Transactional;

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
    List<Tag> listAll();

    /**
     * 添加标签
     *
     * @param tag 标签
     * @return 执行结果
     */
    @Transactional
    boolean save(Tag tag);

    /**
     * 删除标签
     *
     * @param id 标签主键
     * @return 执行结果
     */
    @Transactional
    boolean delete(Integer id);

    /**
     * 修改标签名或描述
     *
     * @param tag 标签
     * @return 执行结果
     */
    @Transactional
    boolean update(Tag tag);

    /**
     * 判断标签名是否重复
     *
     * @param tagName 标签名
     * @return 重复返回true，否则返回false
     */
    boolean isNameRepeat(String tagName);
}
