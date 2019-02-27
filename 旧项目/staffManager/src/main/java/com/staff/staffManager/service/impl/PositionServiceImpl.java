package com.staff.staffManager.service.impl;

import com.staff.staffManager.dao.PositionDao;
import com.staff.staffManager.dao.entity.Position;
import com.staff.staffManager.dao.entity.Staff;
import com.staff.staffManager.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    /**
     * 实现查询岗位所有员工方法
     *
     * @param positionId
     * @return 返回查询到的员工列表
     */
    @Override
    public List<Staff> staffOfPosition(long positionId) {
        return positionDao.staffOfPosition(positionId);
    }

    /**
     * 实现模糊查询岗位方法
     *
     * @param positionId
     * @param positionName
     * @param positionType
     * @return 返回查询到的岗位信息
     */
    @Override
    public List<Position> searchPosition(long positionId, String positionName, String positionType) {
        return positionDao.searchPosition(positionId, positionName, positionType);
    }

    /**
     * 实现新增岗位方法
     *
     * @param position
     * @return 返回新增后的数据库信息
     */
    @Override
    public Position addPosition(Position position) {
        return positionDao.save(position);
    }

    /**
     * 实现部门更新方法
     *
     * @param position
     * @return 返回更新后的岗位信息
     */
    @Override
    public Position updatePosition(Position position) {
        return positionDao.saveAndFlush(position);
    }

    /**
     * 实现岗位删除方法
     *
     * @param positionId
     * @return 返回0或1，0失败，1成功
     */
    @Override
    public int deletePosition(long positionId) {
        return positionDao.removePositionByPositionId(positionId);
    }
}
