package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.TagDao;
import com.laigaopeng.www.pojo.Tag;
import com.laigaopeng.www.service.TagService;
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
        if (isNameRepeat(tag.getName())) return false;
        return tagDao.save(tag) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return tagDao.delete(id) == 1;
    }

    @Override
    public boolean update(Tag tag) {
        if (isNameRepeat(tag.getName())) return false;
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
