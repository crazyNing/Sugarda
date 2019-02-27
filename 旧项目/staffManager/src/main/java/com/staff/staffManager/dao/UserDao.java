package com.staff.staffManager.dao;

import com.staff.staffManager.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 用户Dao层
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
    //通过用户名查找用户信息
    User findUserByUserName(String userName);
}
