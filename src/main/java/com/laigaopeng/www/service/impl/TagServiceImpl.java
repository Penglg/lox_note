package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.TagDao;
import com.laigaopeng.www.exception.BusinessException;
import com.laigaopeng.www.pojo.Tag;
import com.laigaopeng.www.service.TagService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签业务功能实现
 *
 */
@Service("tagService")
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public boolean save(Tag tag) {
        if (isNameRepeat(tag.getName())) throw new BusinessException();
        return tagDao.save(tag) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return tagDao.delete(id) == 1;
    }

    @Override
    public boolean update(Tag tag) {
        // 判断名不为空时是否重复
        if ((!EmptyCheckerUtil.isStringEmpty(tag.getName())) && isNameRepeat(tag.getName())) {
            tag.setName(tagDao.getById(tag.getId()).getName()); // 修改为原名
        }
        return tagDao.update(tag) == 1;
    }

    @Override
    public List<Tag> listAll() {
        return tagDao.listAll();
    }

    @Override
    public boolean isNameRepeat(String tagName) {
        return tagDao.getByName(tagName) != null;
    }
}
