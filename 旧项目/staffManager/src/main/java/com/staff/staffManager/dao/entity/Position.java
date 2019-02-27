package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 岗位实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "position_info")
public class Position {
    @Id
    @Column(name = "position_id")
    private int positionId;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "position_type")
    private String positionType;

    @Column(name = "position_orga")
    private int positionOrga;
}
