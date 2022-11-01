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
}
