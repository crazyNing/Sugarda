package com.staff.staffManager.service.impl;

import com.staff.staffManager.dao.StaffDao;
import com.staff.staffManager.dao.entity.Staff;
import com.staff.staffManager.dao.entity.vo.ResponseDto;
import com.staff.staffManager.service.StaffService;
import com.staff.staffManager.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 员工Service实现类
 *
 * @Authoe 汪宁
 */
@Service
public class StaffServiceImpl implements StaffService {
    //自动装配StaffSerice层
    @Autowired
    private StaffDao staffDao;

    //实例化Staff
    private Staff staff;

    //实例化CommonUtil类，预备调用工具方法
    private CommonUtil commonUtil;

    //实例化返回值方法
    private ResponseDto responseDto;

    /**
     * 传入相关值对员工进行查询，并返回相关结果集
     *
     * @param staffId
     * @param staffName
     * @param isTrial
     * @param belongDepartment
     * @param isDismiss
     * @param hireDate
     * @param belongPosition
     * @return 返回一个结果集合，显示所有符合条件的值
     * @Author 汪宁
     */
    @Override
    public List<Staff> searchStaff(long staffId, String staffName, int isTrial, long belongDepartment, int isDismiss, Date hireDate, long belongPosition) {
        return staffDao.findStaff(staffId, staffName, isTrial, belongDepartment, isDismiss, hireDate, belongPosition);
    }

    /**
     * 新增员工接口实现
     *
     * @param staff
     * @Author 汪宁
     */
    @Override
    public Staff addStaff(Staff staff) {
        return staffDao.save(staff);
    }

    /**
     * 修改员工接口实现
     *
     * @param staff
     * @Author 汪宁
     */
    @Override
    public Staff updateStaff(Staff staff) {
        return staffDao.saveAndFlush(staff);
    }

    /**
     * 删除员工接口实现
     *
     * @param staffId
     * @Author 汪宁
     */
    @Override
    public int deleteStaff(long staffId) {
        return staffDao.deleteStaffByStaffId(staffId);
    }
}
