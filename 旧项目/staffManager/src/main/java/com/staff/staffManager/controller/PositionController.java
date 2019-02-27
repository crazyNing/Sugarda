package com.staff.staffManager.controller;

import com.staff.staffManager.dao.entity.Position;
import com.staff.staffManager.dao.entity.vo.DPVo;
import com.staff.staffManager.dao.entity.vo.ResponseDto;
import com.staff.staffManager.service.PositionService;
import com.staff.staffManager.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门Controller层
 *
 * @Author 汪宁
 */
@RestController
@RequestMapping(value = "/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    private CommonUtil commonUtil = new CommonUtil();

    private ResponseDto responseDto = new ResponseDto();

    /**
     * 实现模糊查询部门功能，对部门信息进行模糊查询
     *
     * @param positionVo
     * @return
     */
    @PostMapping(value = "/searchPosition")
    public ResponseDto searchPosition(@RequestBody DPVo positionVo) {
        List<Position> positionList = positionService.searchPosition(positionVo.getId(), positionVo.getName(), positionVo.getType());
        responseDto=commonUtil.DPHelp(positionVo,positionList);
        return responseDto;
    }

    /**
     * 实现查询部门下人员信息方法
     *
     * @param positionId
     * @return
     */
    @GetMapping(value = "/staffOfPosition")
    public ResponseDto staffOfPosition(@RequestParam long positionId) {
        if (positionService.searchPosition(positionId, "", "").size() == 0) {
            responseDto = commonUtil.error("error", "很抱歉，没有返回值", "很抱歉，数据库查询失败");
        } else {
            responseDto = commonUtil.success(positionService.staffOfPosition(positionId));
        }
        return responseDto;
    }

    /**
     * 实现新增部门方法
     *
     * @param position
     * @return
     */
    @PostMapping(value = "/addPosition")
    public ResponseDto addPosition(@RequestBody Position position) {
        if (position == null) {
            responseDto = commonUtil.error("error", "很抱歉，输入值不能为空", "很抱歉，输入错误！");
        } else if (positionService.searchPosition(position.getPositionId(), "", "").size() > 0) {
            responseDto = commonUtil.error("error", "该崗位Id已存在", "崗位Id输入有误！");
        } else {
            responseDto = commonUtil.success(positionService.addPosition(position));
        }
        return responseDto;
    }

    /**
     * 实现部门更新方法
     *
     * @param position
     * @return
     */
    @PostMapping(value = "/updatePosition")
    public ResponseDto updatePosition(@RequestBody Position position) {
        if (position == null) {
            responseDto = commonUtil.error("error", "很抱歉，输入不能为空！", "很抱歉，输入为空不能返回值！");
        } else if (positionService.searchPosition(position.getPositionId(), "", "").size() <= 0) {
            responseDto = commonUtil.error("error", "很抱歉，该部门不存在", "很抱歉，输入有误！");
        } else {
            responseDto = commonUtil.success(positionService.updatePosition(position));
        }
        return responseDto;
    }

    /**
     * 实现部门删除方法
     *
     * @param positionId
     * @return
     */
    @DeleteMapping(value = "/deletePosition")
    public ResponseDto deletePosition(@RequestParam long positionId) {
        if (positionService.searchPosition(positionId, "", "").size() <= 0) {
            responseDto = commonUtil.error("error", "很抱歉，该部门不存在", "很抱歉，输入有误！");
        } else if (positionService.staffOfPosition(positionId).size() > 0) {
            responseDto = commonUtil.error("error", "很抱歉，该部门下仍然有员工，请将所有员工转移或开除后再删除部门", "删除失败");
        } else {
            responseDto = commonUtil.success(positionService.deletePosition(positionId) == 1 ? "删除成功" : "删除失败");
        }
        return responseDto;
    }
}