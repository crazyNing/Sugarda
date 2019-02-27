package com.Sugarda.uaaService.config.oauthConfig.accessTokenConfig;

import com.Sugarda.uaaService.controller.myLoginPage.FromLoginConstant;
import com.Sugarda.uaaService.controller.myLoginPage.OauthPageProperties;
import com.Sugarda.uaaService.dao.entity.SugardaUserDetail;
import com.Sugarda.uaaService.service.SugardaUserService;
import com.Sugarda.uaaService.service.impl.SugardaUserDetailServiceImpl;
import com.Sugarda.uaaService.service.impl.SugardaUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.ManagementServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(ManagementServerProperties.ACCESS_OVERRIDE_ORDER)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 自动注入UserDetailsService
    @Autowired
    private SugardaUserDetailServiceImpl sugardaUserDetailServiceImpl;

    private OauthPageProperties oauthLogin = new OauthPageProperties();

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http    // 配置登陆页/login并允许访问
                .formLogin().permitAll().loginPage(FromLoginConstant.LOGIN_PAGE).loginProcessingUrl(FromLoginConstant.LOGIN_PROCESSING_URL)//允许访问
                .and().authorizeRequests().antMatchers(
                "/user/hello",
                FromLoginConstant.LOGIN_PROCESSING_URL,
                FromLoginConstant.LOGIN_PAGE,
                oauthLogin.getOauthLogin(),
                oauthLogin.getOauthGrant()).permitAll().anyRequest().authenticated()
                // 登出页
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                // 其余所有请求全部需要鉴权认证
                .and().authorizeRequests().anyRequest().authenticated()
                // 由于使用的是JWT，我们这里不需要csrf
                .and().csrf().disable();
    }

    /**
     * 用户验证
     * @param auth
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }


    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService(sugardaUserDetailServiceImpl);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash，此处不对密码进行加密
        //provider.setPasswordEncoder();
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(6));
        return provider;
    }
}