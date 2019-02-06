package com.Sugarda.uaaService.dao;

import com.Sugarda.uaaService.dao.entity.SugardaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Map;

/**
 * 用户Dao层
 */
@Repository
public interface UserDao extends JpaRepository<SugardaUser, String>, JpaSpecificationExecutor<SugardaUser> {

    /**
     * 通过用户编号查询用户信息
     * @param userId
     * @return
     */
    @Transactional
    SugardaUser findAllByUserId(String userId);
}
