package com.Sugarda.uaaService.service;

import com.Sugarda.uaaService.dao.entity.SugardaUser;

public interface SugardaUserService {
    SugardaUser getUserByUserId(String userId);
}
