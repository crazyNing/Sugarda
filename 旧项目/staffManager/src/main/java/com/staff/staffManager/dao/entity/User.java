package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "user_info")
public class User {

    @Id
    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String password;
}
