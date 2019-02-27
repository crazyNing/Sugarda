package com.Sugarda.userManageService.service.impl;

import com.Sugarda.userManageService.dao.UserDao;
import com.Sugarda.userManageService.dao.entity.SugardaUser;
import com.Sugarda.userManageService.service.SugardaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SugardaUserServiceImpl implements SugardaUserService {
    @Autowired
    private UserDao userDao;


    @Override
    public SugardaUser getUserByUserId(String userId) {
        return userDao.findAllByUserId(userId);
    }
}
