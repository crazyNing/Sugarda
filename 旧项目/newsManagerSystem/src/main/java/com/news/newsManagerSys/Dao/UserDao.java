package com.news.newsManagerSys.Dao;

import com.news.newsManagerSys.Dao.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserDao extends JpaRepository<User, String> {

    @Transactional
    User findUserByUserNameAndUserPwd(String userName, String userPwd);
}