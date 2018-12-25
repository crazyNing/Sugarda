package com.Sugarda.uaaService.dao.entity.vo;

import com.Sugarda.uaaService.dao.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginVo {
    private StringBuffer userName;

    public LoginVo(User user) {
        this.userName = user.getUserName();
    }
}
