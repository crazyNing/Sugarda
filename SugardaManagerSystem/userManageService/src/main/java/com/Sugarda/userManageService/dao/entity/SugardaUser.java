package com.Sugarda.userManageService.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * 核心用户类，包含用户信息以及用户权限，包含参数：序号、用户编号、用户姓名、用户密码、用户角色，使用Lombok实现set、get方法
 */
@Setter
@Getter
@Table(name = "user_info")
@Entity
public class SugardaUser implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "序号不能为空")
    @Size(message = "序号长度不符合要求，长度需要在0-6位之间", max = 6, min = 0)
    private int id;

    @Column(name = "user_id")
    @NotBlank(message = "用户编号不能为空")
    @Size(message = "用户编号长度不符合要求，长度需要在0-16位之间", max = 16, min = 0)
    private String userId;

    @Column(name = "user_name")
    @NotBlank(message = "用户姓名不能为空")
    @Size(message = "用户姓名长度不符合要求，长度需要在0-16位之间", max = 16, min = 0)
    private String userName;

    @Column(name = "user_password")
    @NotBlank(message = "用户密码不能为空")
    private String userPassword;

    @Column(name = "user_role")
    @NotBlank(message = "用户角色不能为空")
    @Size(message = "用户角色长度不符合要求，长度需要在0-6位之间", max = 6, min = 0)
    private int userRole;

}
