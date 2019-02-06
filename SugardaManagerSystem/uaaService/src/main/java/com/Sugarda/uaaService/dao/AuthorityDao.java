package com.Sugarda.uaaService.dao;

import com.Sugarda.uaaService.dao.entity.Role_authorities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限Dao层
 */
@Repository
public interface AuthorityDao extends JpaRepository<Role_authorities,String>, JpaSpecificationExecutor<Role_authorities> {
    /**
     * 查询所有权限
     * @return
     */
    @Transactional
    List<Role_authorities> findAll();
}
