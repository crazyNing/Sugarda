package com.Sugarda.uaaService.service.impl;

import com.Sugarda.uaaService.dao.entity.SugardaUser;
import com.Sugarda.uaaService.dao.entity.SugardaUserDetail;
import com.Sugarda.uaaService.service.RoleService;
import com.Sugarda.uaaService.service.SugardaUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SugardaUserDetailServiceImpl implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SugardaUserService sugardaUserService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {

        // 调用FeignClient查询用户
        SugardaUser sugardaUser = sugardaUserService.getUserByUserId(userId);
        if (sugardaUser == null) {
            logger.error("找不到该用户，用户名：" + userId);
            throw new UsernameNotFoundException("找不到该用户，用户名：" + userId);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 返回带有用户权限信息的User
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(sugardaUser.getUserName(), sugardaUser.getUserPassword(), authorities);
        return new SugardaUserDetail(sugardaUser, user);
    }
}
