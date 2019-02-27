package com.Sugarda.userManageService.service;


import com.Sugarda.userManageService.dao.entity.SugardaUser;

public interface SugardaUserService {
    SugardaUser getUserByUserId(String userId);
}
