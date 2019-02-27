package com.Sugarda.userManageService.dao.entity;

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
 * 用户身份类，标注用户身份信息中文名
 */
@Setter
@Getter
@Table(name = "user_role_type")
@Entity
public class User_role_type implements Serializable {

    @Id
    @Column(name = "id")
    @NotEmpty(message = "序号不能为空")
    @Size(message = "序号长度不符合要求，长度在0-6位之间", max = 6, min = 0)
    private int id;

    @Column(name = "role_type_name")
    @NotBlank(message = "用户身份名称不能为空")
    @Size(message = "用户身份名称长度错误，长度范围在0-12位之间", max = 12, min = 0)
    private String roleTypeName;
}
