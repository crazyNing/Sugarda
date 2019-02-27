package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


/**
 * 部门实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "department_info")
public class Department {

    @Id
    @Column(name = "department_id")
    private long departmentId;

    @Column(name = "department_type")
    private String departmentType;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_phone")
    private String departmentPhone;

    @Column(name = "department_fax")
    private String departmentFax;

    @Column(name = "department_desc")
    private String departmentDesc;

    @Column(name = "department_parent_id")
    private long departmentParentId;

    @Temporal(TemporalType.DATE)
    @Column(name = "department_date")
    private Date departmentDate;

}
