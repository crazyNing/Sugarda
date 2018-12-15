package com.news.newsManagerSys.Service;

import java.util.List;

import com.news.newsManagerSys.Dao.Entity.User;

public interface UserService {

	List<User> getAll();

	User findUserByUserNameAndUserPwd(String userName,String userPwd);
}
