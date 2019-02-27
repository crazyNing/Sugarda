package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 语言能力实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "language_info")
public class Language {
    @Id
    @Column(name = "la_id")
    private long laId;

    @Column(name = "la_type")
    private String laType;

    @Column(name = "la_proficiency")
    private String laProficiency;
}
