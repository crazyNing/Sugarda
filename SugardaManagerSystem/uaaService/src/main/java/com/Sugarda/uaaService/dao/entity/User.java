package com.Sugarda.uaaService.dao.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class User {
    @Id
    @Column(name = "id")
    private long Id;

    @Column(name = "password")
    private StringBuffer password;

    @Column(name = "user-name")
    private StringBuffer userName;
}
