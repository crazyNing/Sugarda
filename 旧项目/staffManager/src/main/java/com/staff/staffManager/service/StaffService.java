package com.staff.staffManager.service;

import com.staff.staffManager.dao.entity.Staff;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 员工Service接口
 *
 * @Author 汪宁
 */
public interface StaffService {

    //查询用户接口，传入用户信息
    List<Staff> searchStaff(long staffId, String staffName, int isTrial, long belongDepartment, int isDismiss, Date hireDate, long belongPosition);

    //新增用户接口
    Staff addStaff(Staff staff);

    //修改用户接口
    Staff updateStaff(Staff staff);

    //删除用户接口
    @Transactional
    int deleteStaff(long staffId);
}
