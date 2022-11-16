package com.laigaopeng.www.service.impl;

import com.laigaopeng.www.dao.ManagerSectionDao;
import com.laigaopeng.www.pojo.ManagerSection;
import com.laigaopeng.www.service.ManagerSectionService;
import com.laigaopeng.www.util.EmptyCheckerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerSectionServiceImpl implements ManagerSectionService {

    @Autowired
    private ManagerSectionDao managerSectionDao;

    @Override
    public boolean save(Integer userId, Integer sectionId) {
        ManagerSection managerSection = new ManagerSection();
        managerSection.setUserId(userId);
        managerSection.setSectionId(sectionId);
        return managerSectionDao.save(managerSection) == 1;
    }

    @Override
    public boolean deleteByConditions(Integer userId, Integer sectionId) {
        ManagerSection managerSection = new ManagerSection();
        managerSection.setUserId(userId);
        managerSection.setSectionId(sectionId);
        System.out.println(managerSection);
        return managerSectionDao.delete(managerSection) == 1;
    }

    @Override
    public ManagerSection getById(Integer id) {
        if (EmptyCheckerUtil.isIntegerEmpty(id)) return null;
        return managerSectionDao.getById(id);
    }

    @Override
    public ManagerSection getByUserId(Integer userId) {
        if (EmptyCheckerUtil.isIntegerEmpty(userId)) return null;
        return managerSectionDao.getByUserId(userId);
    }
}
