package com.staff.staffManager.service.impl;

import com.staff.staffManager.dao.DepartmentMoveDao;
import com.staff.staffManager.dao.entity.DepartmentMove;
import com.staff.staffManager.service.DMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 部门调动Service实现类
 */
@Service
public class DMServiceImpl implements DMService {
    @Autowired
    private DepartmentMoveDao departmentMoveDao;

    @Override
    public List<DepartmentMove> searchDM(Date startTime, Date endTime, long staffId, String staffName, String moveType) {
        return departmentMoveDao.searchDepartmentMove(startTime, endTime, staffId, staffName, moveType);
    }

    @Override
    public DepartmentMove addDM(DepartmentMove departmentMove) {
        return departmentMoveDao.save(departmentMove);
    }
}
