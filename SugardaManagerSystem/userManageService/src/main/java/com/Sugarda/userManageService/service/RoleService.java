package com.Sugarda.userManageService.service;

import com.Sugarda.userManageService.dao.entity.User_role_type;

import java.util.List;

public interface RoleService {
    List<User_role_type> findAll();

    User_role_type findAllById(int id);
}
