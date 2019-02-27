package com.staff.staffManager.dao;

import com.staff.staffManager.dao.entity.DepartmentMove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 部门调动Dao层
 */
@Repository
public interface DepartmentMoveDao extends JpaRepository<DepartmentMove, Long> {
    //模糊查询岗位调动方法，传入开始时间，结束时间，人员Id，人员姓名，调动方式
    @Query(value = "SELECT * FROM department_move_info WHERE IF(?1 !=null,dm_start_time>?1,1=1) AND IF(?2 !=null,dm_end_time<?2,1=1) AND IF(?3 !=0,dm_staff_id=?3,1=1) AND IF(?4 !='',dm_staff_name=?4,1=1) AND IF(?5 !='',dm_type=?5,1=1)", nativeQuery = true)
    List<DepartmentMove> searchDepartmentMove(Date startTime, Date endTime, long staffId, String staffName, String moveType);
}
