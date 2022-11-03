package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.SectionDao;
import com.laigaopeng.www.pojo.Section;
import com.laigaopeng.www.service.SectionService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SectionServiceImpl implements SectionService {
    @Autowired
    private SectionDao sectionDao;

    @Override
    public boolean save(Section section) {
        if (isNameRepeat(section.getName())) return false;
        return sectionDao.save(section) == 1;
    }

    @Override
    public boolean delete(Integer id) {
        return sectionDao.delete(id) == 1;
    }

    @Override
    public boolean update(Section section) {
        // 判断分区名是否重复
        if ((!EmptyCheckerUtil.isStringEmpty(section.getName())) && (isNameRepeat(section.getName()))) return false;
        return sectionDao.update(section) == 1;
    }

    @Override
    public List<Section> listAll() {
        return sectionDao.listAll();
    }

    @Override
    public boolean isNameRepeat(String sectionName) {
        return sectionDao.getByName(sectionName) != null;
    }
}
