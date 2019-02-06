package com.Sugarda.uaaService.service.impl;

import com.Sugarda.uaaService.dao.UserDao;
import com.Sugarda.uaaService.dao.entity.SugardaUser;
import com.Sugarda.uaaService.service.SugardaUserService;
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
