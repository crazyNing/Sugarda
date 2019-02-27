package com.staff.staffManager.service;

import com.staff.staffManager.dao.entity.Department;
import com.staff.staffManager.dao.entity.Staff;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DepartmentService {
    //查找传入的departmentId下的所有员工
    List<Staff> staffOfDepartment(long departmentId);

    //模糊查询部门信息
    List<Department> searchDepartment(long departmentId, String departmentName, String departmentType);

    //新增部门
    Department addDepartment(Department department);

    //修改部门
    Department updateDepartment(Department department);

    //删除部门
    @Transactional
    int deleteDepartment(long departmentId);
}
