package com.laigaopeng.www.service;

import com.laigaopeng.www.pojo.Note;
import com.laigaopeng.www.pojo.Tag;
import com.laigaopeng.www.pojo.vo.Page;
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
     * @param pageNum 第几页笔记
     * @return 查找结果
     */
    Page<Note> listAll(Integer pageNum);

    /**
     * 获取所有非法/合法的笔记
     *
     * @param isLegal 是否合法，1合法，0不合法
     * @return 查找结果
     */
    List<Note> listAll(Integer pageNum, Integer isLegal);

    /**
     * 获取分区所有笔记
     *
     * @param sectionId sectionid
     * @param isLegal 是否合法
     * @return 查询结果
     */
    List<Note> listSectionNotes(Integer sectionId, Integer isLegal);

    /**
     * 查找用户的所有笔记
     *
     * @param userId 用户id
     * @param isLegal 是否合法
     * @return 查询结果
     */
    List<Note> listUserNotes(Integer userId, Integer isLegal);

    /**
     * 查找笔记
     *
     * @param id 笔记主键
     * @return 查询结果
     */
    Note getById(Integer id);

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
     * @param id 删除的笔记主键
     * @return 删除结果
     */
    boolean deleteNote(Integer id);

    /**
     * 新增笔记
     *
     * @param note 新增的笔记
     * @param tagIds 笔记的标签
     * @return 新增结果
     */
    boolean save(Note note, List<Integer> tagIds, String approvalContent);

    /**
     * 获取点赞的笔记
     *
     * @param userId 用户主键
     * @return 结果
     */
    List<Note> listLikeNotes(Integer userId);

    /**
     * 用户获取收藏笔记
     *
     * @param userId 用户主键
     * @return 结果
     */
    List<Note> listCollectNotes(Integer userId);
}
