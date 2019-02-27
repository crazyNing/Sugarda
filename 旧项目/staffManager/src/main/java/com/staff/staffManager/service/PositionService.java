package com.staff.staffManager.service;

import com.staff.staffManager.dao.entity.Position;
import com.staff.staffManager.dao.entity.Staff;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PositionService {
    //查找传入的positionId下的所有员工
    List<Staff> staffOfPosition(long positionId);

    //模糊查询部门信息
    List<Position> searchPosition(long positionId, String positionName, String positionType);

    //新增部门
    Position addPosition(Position position);

    //修改部门
    Position updatePosition(Position position);

    //删除部门
    @Transactional
    int deletePosition(long positionId);
}
