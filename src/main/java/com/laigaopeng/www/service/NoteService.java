package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.Tag;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 笔记业务逻辑层
 *
 */
public interface NoteService {

    /**
     * 获取所有笔记
     *
     * @return 查找结果
     */
    List<Note> findAll();

    /**
     * 获取所有非法/合法的笔记
     *
     * @param isLegal 是否合法，1合法，0不合法
     * @return 查找结果
     */
    List<Note> findAll(Integer isLegal);

    /**
     * 获取分区所有笔记
     *
     * @param sectionId sectionid
     * @param isLegal 是否合法
     * @return 查询结果
     */
    List<Note> findSectionNotes(Integer sectionId, Integer isLegal);

    /**
     * 查找用户的所有笔记
     *
     * @param userId 用户id
     * @return 查询结果
     */
    List<Note> findUserNotes(Integer userId);

    /**
     * 修改笔记
     *
     * @param note 修改的笔记
     * @return 修改结果
     */
    @Transactional
    boolean updateNote(Note note);

    /**
     * 删除笔记
     *
     * @param note 删除的笔记
     * @return 删除结果
     */
    boolean deleteNote(Note note);

    /**
     * 新增笔记
     *
     * @param note 新增的笔记
     * @param tags 笔记的标签
     * @return 新增结果
     */
    boolean save(Note note, List<Tag> tags);

    /**
     * 获取点赞的笔记
     *
     * @param userId 用户主键
     * @return 结果
     */
    List<Note> findLikeNotes(Integer userId);

    /**
     * 用户获取收藏笔记
     *
     * @param userId 用户主键
     * @return 结果
     */
    List<Note> findCollectNotes(Integer userId);
}
