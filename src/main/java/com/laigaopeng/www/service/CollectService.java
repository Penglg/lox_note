package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Collect;
import org.springframework.transaction.annotation.Transactional;

/**
 * 收藏业务逻辑层
 *
 */
public interface CollectService {

    /**
     * 用户收藏笔记
     *
     * @param collect 收藏
     * @return 结果
     */
    @Transactional
    boolean save(Collect collect);

    /**
     * 用户取消收藏
     *
     * @param id 收藏id
     * @return 执行结果
     */
    @Transactional
    boolean delete(Integer id);

    /**
     * 删除笔记的所有收藏记录
     *
     * @param noteId 笔记主键
     * @return 执行成功结果
     */
    boolean deleteNoteCollects(Integer noteId);

    /**
     * 是否重复收藏
     *
     * @param userId 用户主键
     * @param noteId 笔记主键
     * @return 重复返回true，不重复返回false
     */
    boolean isCollectRepeat(Integer userId, Integer noteId);
}
