package com.Sugarda.uaaService.dao;

import com.Sugarda.uaaService.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
     
}
