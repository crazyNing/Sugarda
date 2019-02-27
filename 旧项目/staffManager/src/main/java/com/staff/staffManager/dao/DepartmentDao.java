package com.staff.staffManager.dao;

import com.staff.staffManager.dao.entity.Department;
import com.staff.staffManager.dao.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门Dao层
 *
 * @Author 汪宁
 */
@Repository
public interface DepartmentDao extends JpaRepository<Department,Long> {
    //通过返回部门下的人员信息
    @Query(value = "SELECT * FROM staff_info WHERE staff_department_id=?1", nativeQuery = true)
    List<Staff> staffOfDepartment(long departmentId);

    //通过部门Id或者部门名称或者部门类型查找部门信息
    @Query(value = "SELECT * FROM department_info WHERE IF(?1 !=0,department_id=?1,1=1) AND IF(?2 !='',department_name=?2,1=1) AND IF(?3 !='',department_type=?3,1=1)", nativeQuery = true)
    List<Department> searchDepartment(long departmentId,String departmentName,String departmentType);

    //删除部门接口
    @Transactional
    int removeDepartmentByDepartmentId(long departmentId);
}
