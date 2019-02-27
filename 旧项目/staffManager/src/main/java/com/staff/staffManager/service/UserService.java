package com.staff.staffManager.service;

import com.staff.staffManager.dao.entity.vo.ResponseDto;

/**
 * 用户Service接口
 *
 * @Author 汪宁
 */
public interface UserService {
    ResponseDto login(String userName, String password);
}
