package com.staff.staffManager.service.impl;

import com.staff.staffManager.dao.DepartmentDao;
import com.staff.staffManager.dao.entity.Department;
import com.staff.staffManager.dao.entity.Staff;
import com.staff.staffManager.service.DepartmentService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    /**
     * 实现查询部门所有员工方法
     *
     * @param departmentId
     * @return 返回查询到的员工列表
     */
    @Override
    public List<Staff> staffOfDepartment(long departmentId) {
        return departmentDao.staffOfDepartment(departmentId);
    }

    /**
     * 实现模糊查询部门方法
     *
     * @param departmentId
     * @param departmentName
     * @param departmentType
     * @return 返回查询到的部门信息
     */
    @Override
    public List<Department> searchDepartment(long departmentId, String departmentName, String departmentType) {
        return departmentDao.searchDepartment(departmentId, departmentName, departmentType);
    }

    /**
     * 实现新增部门方法
     *
     * @param department
     * @return 返回新增后的数据库信息
     */
    @Override
    public Department addDepartment(Department department) {
        return departmentDao.save(department);
    }

    /**
     * 实现部门更新方法
     *
     * @param department
     * @return 返回更新后的部门信息
     */
    @Override
    public Department updateDepartment(Department department) {
        return departmentDao.saveAndFlush(department);
    }

    /**
     * 实现部门删除方法
     *
     * @param departmentId
     * @return
     */
    @Override
    public int deleteDepartment(long departmentId) {
        return departmentDao.removeDepartmentByDepartmentId(departmentId);
    }
}
