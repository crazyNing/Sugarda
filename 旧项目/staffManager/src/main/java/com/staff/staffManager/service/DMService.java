package com.staff.staffManager.service;

import com.staff.staffManager.dao.entity.DepartmentMove;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 部门调动Service接口
 */
public interface DMService {
    //查询部门调动表
    List<DepartmentMove> searchDM(Date startTime, Date endTime, long staffId, String staffName, String moveType);

    //新增部门调动
    DepartmentMove addDM(DepartmentMove departmentMove);
}
