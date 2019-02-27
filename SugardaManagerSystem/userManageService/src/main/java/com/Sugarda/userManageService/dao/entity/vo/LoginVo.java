package com.Sugarda.userManageService.dao.entity.vo;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Setter
@Getter
public class LoginVo implements Serializable {
    @NotBlank(message = "用户编号不能为空")
    @Size(message = "用户编号长度不符合要求，长度需要在0-16位之间", max = 16, min = 0)
    private StringBuffer user_name;

    @NotBlank(message = "用户密码不能为空")
    private StringBuffer user_password;
}
