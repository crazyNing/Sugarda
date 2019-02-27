package com.Sugarda.uaaService.controller;


import com.Sugarda.uaaService.controller.myLoginPage.OauthPageProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author wangNing
 * @description
 * @date 2018/11/22 0022 11:54
 */
@ConfigurationProperties(prefix = "system")
@Data
public class SecurityProperties {

    private OauthPageProperties oauthLogin = new OauthPageProperties();

}
