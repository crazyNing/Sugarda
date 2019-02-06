package com.Sugarda.uaaService.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 权限类，显示用户所有权限，使用lombok插件实现get、set方法，包含序号、权限名称两个参数
 */
@Entity
@Setter
@Getter
@Table(name = "role_authorities")
public class Role_authorities implements Serializable {
    @Id
    @Column(name = "id")
    @NotEmpty(message = "序号不能为空")
    @Size(message = "序号长度不符合要求，长度在0-6位之间", max = 6, min = 0)
    private int id;

    @Column(name = "authority_name")
    @NotBlank(message = "用户权限名称不能为空")
    @Size(message = "用户权限名称长度错误，长度范围在0-12位之间", max = 12, min = 0)
    private String authorityName;
}

