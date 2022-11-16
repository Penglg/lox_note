package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Section;

import java.util.List;

/**
 * 分区业务逻辑层
 *
 */
public interface SectionService {

    /**
     * 新建分区
     *
     * @param section 分区
     * @return 执行结果
     */
    boolean save(Section section);

    /**
     * 删除分区
     *
     * @param id 分区主键
     * @return 执行结果
     */
    boolean delete(Integer id);

    /**
     * 修改分区名或描述
     *
     * @param section 分区
     * @return 执行结果
     */
    boolean update(Section section);

    /**
     * 判断分区名是否重复
     *
     * @param sectionName 分区名
     * @return 重复返回true，否则返回false
     */
    boolean isNameRepeat(String sectionName);

    /**
     * 获取分区
     *
     * @param id 主键
     * @return 结果
     */
    Section get(Integer id);

    /**
     * 查看所有分区
     *
     * @return 查询结果
     */
    List<Section> listAll();
}
