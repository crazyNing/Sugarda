package com.Sugarda.uaaService.dao;

import com.Sugarda.uaaService.dao.entity.User_role_type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *  用户身份类
 */
@Repository
public interface RoleDao extends JpaRepository<User_role_type,String>, JpaSpecificationExecutor<User_role_type> {
    /**
     * 查询所有用户身份
     * @return
     */
    @Transactional
    List<User_role_type> findAll();

    /**
     * 通过序号查询用户信息
     * @param id
     * @return
     */
    @Transactional
    User_role_type findAllById(int id);
}
