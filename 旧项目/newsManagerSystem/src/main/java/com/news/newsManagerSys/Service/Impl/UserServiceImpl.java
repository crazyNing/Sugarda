package com.news.newsManagerSys.Service.Impl;

import com.news.newsManagerSys.Dao.Entity.User;
import com.news.newsManagerSys.Dao.UserDao;
import com.news.newsManagerSys.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public User findUserByUserNameAndUserPwd(String userName, String userPwd) {
        return userDao.findUserByUserNameAndUserPwd(userName, userPwd);
    }


}
