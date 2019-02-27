package com.staff.staffManager.dao;

import com.staff.staffManager.dao.entity.Position;
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
public interface PositionDao extends JpaRepository<Position, Long> {
    //通过返回岗位下的人员信息
    @Query(value = "SELECT * FROM staff_info WHERE staff_position_id=?1", nativeQuery = true)
    List<Staff> staffOfPosition(long positionId);

    //通过岗位Id或者岗位名称或者岗位类型查找部门信息
    @Query(value = "SELECT * FROM position_info WHERE IF(?1 !=0,position_id=?1,1=1) AND IF(?2 !='',position_name=?2,1=1) AND IF(?3 !='',position_type=?3,1=1)", nativeQuery = true)
    List<Position> searchPosition(long positionId, String positionName, String positionType);

    //删除岗位接口
    @Transactional
    int removePositionByPositionId(long positionId);
}
