package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 其他信息实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "other_info")
public class Other {
    @Id
    @Column(name = "o_id")
    private long oId;

    @Column(name = "o_my_relation")
    private String oMyRelation;

    @Column(name = "o_name")
    private String oName;

    @Column(name = "o_company_place")
    private String oCompanyPlace;

    @Column(name = "o_position")
    private String oPosition;

    @Column(name = "o_phone")
    private String oPhone;
}
