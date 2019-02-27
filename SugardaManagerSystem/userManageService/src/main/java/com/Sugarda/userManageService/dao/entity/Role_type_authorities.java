package com.Sugarda.userManageService.dao.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 用户身份与权限对照类，将用户身份与用户权限对照起来，包含参数序号、用户身份编号、用户权限编号，使用lombok插件实现get、set方法
 */
@Entity
@Setter
@Getter
@Table(name = "role_type_authorities")
public class Role_type_authorities implements Serializable {

    @Id
    @Column(name = "id")
    @NotEmpty(message = "序号不能为空")
    @Size(message = "序号长度不符合要求，长度在0-6位之间", max = 6, min = 0)
    private int id;

    @Column(name = "user_role_type_id")
    @NotEmpty(message = "用户身份编号不能为空")
    @Size(message = "用户身份编号长度不符合要求，长度在0-6位之间", max = 6, min = 0)
    private int userRoleTypeId;

    @Column(name = "user_authority_id")
    @NotEmpty(message = "用户权限编号不能为空")
    @Size(message = "用户权限编号长度不符合要求，长度在0-6位之间", max = 6, min = 0)
    private int userAuthorityId;
}
