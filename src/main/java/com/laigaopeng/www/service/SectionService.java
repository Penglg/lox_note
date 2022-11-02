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
     * @param name 分区名
     * @param desc 分区描述
     * @return 执行结果
     */
    boolean update(String name, String desc);

    /**
     * 查看所有分区
     *
     * @return 查询结果
     */
    List<Section> listAll();
}
