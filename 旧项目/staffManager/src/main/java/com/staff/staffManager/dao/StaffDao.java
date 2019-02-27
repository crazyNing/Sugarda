package com.staff.staffManager.dao;

import com.staff.staffManager.dao.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 员工Dao层
 *
 * @Author 汪宁
 */
@Repository
public interface StaffDao extends JpaRepository<Staff, Long> {
    //多条件查询
    @Query(value = "SELECT * FROM staff_info WHERE IF(?1 !=0,staff_id=?1,1=1) AND IF(?2 !='',staff_name=?2,1=1) AND IF(?3 !=0,staff_is_trial=?3,1=1) AND IF(?4 !=0,staff_department_id=?4,1=1) AND IF(?5 !=0,staff_is_dismiss=?5,1=1) AND IF(?6!=null,staff_hire_date=?6,1=1) AND IF(?7 !=0,staff_position_id=?7,1=1)", nativeQuery = true)
    List<Staff> findStaff(long staffId, String staffName, int staffIsTrial, long staffDepartmentId, int staffIsDismiss, Date staffHireDate, long staffPositionId);

    @Transactional
    int deleteStaffByStaffId(long id);
}
