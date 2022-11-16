package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Like;
import org.springframework.transaction.annotation.Transactional;

/**
 * 点赞业务逻辑层
 *
 */
public interface LikeService {

    /**
     * 用户点赞笔记
     *
     * @param like 点赞
     * @return 结果
     */
    @Transactional
    boolean save(Like like);

    /**
     * 取消对笔记点赞
     *
     * @param noteId 笔记主键
     * @param userId 用户主键
     * @return 结果
     */
    @Transactional
    boolean delete(Integer noteId, Integer userId);

    /**
     * 删除笔记下所有的点赞
     *
     * @param noteId 笔记主键
     * @return 执行结果
     */
    @Transactional
    boolean deleteNoteLikes(Integer noteId);

    /**
     * 点赞是否重复
     *
     * @param userId
     * @param noteId
     * @return
     */
    boolean isLikeRepeat(Integer userId, Integer noteId);
}
