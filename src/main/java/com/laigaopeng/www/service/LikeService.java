package com.laigaopeng.www.service;

/**
 * 点赞业务逻辑层
 *
 */
public interface LikeService {

    /**
     * 用户点赞笔记
     *
     * @param userId 用户
     * @param noteId 笔记
     * @return 结果
     */
    boolean save(Integer userId, Integer noteId);

    /**
     * 取消点赞
     *
     * @param id 点赞主键
     * @return 结果
     */
    boolean delete(Integer id);

    /**
     * 删除笔记下所有的点赞
     *
     * @param noteId 笔记主键
     * @return 执行结果
     */
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
