package com.staff.staffManager.controller;

import com.staff.staffManager.dao.entity.DepartmentMove;
import com.staff.staffManager.dao.entity.vo.DPMoveIn;
import com.staff.staffManager.dao.entity.vo.DPMoveVo;
import com.staff.staffManager.dao.entity.vo.ResponseDto;
import com.staff.staffManager.dao.entity.vo.StaffVo;
import com.staff.staffManager.service.DMService;
import com.staff.staffManager.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 部门调动Controller层
 *
 * @Author 汪宁
 */
@RestController
@RequestMapping(value = "/dmMove")
public class DMController {
    @Autowired
    private DMService dmService;

    private CommonUtil commonUtil = new CommonUtil();

    private ResponseDto responseDto = new ResponseDto();

    /**
     * 查询部门调动方法
     *
     * @param departmentMoveVo
     * @return
     */
    @PostMapping(value = "/searchDM")
    public ResponseDto searchDM(@RequestBody DPMoveVo departmentMoveVo) {
        List<DepartmentMove> departmentMoveList = dmService.searchDM(departmentMoveVo.getStartTime(), departmentMoveVo.getEndTime(), departmentMoveVo.getStaffId(), departmentMoveVo.getStaffName(), departmentMoveVo.getMoveType());
        if (departmentMoveList.size() == 0) {
            responseDto = commonUtil.error("error", "查询的信息不存在！", "查询的信息不存在");
        } else {
            responseDto = commonUtil.success(departmentMoveList);
        }
        return responseDto;
    }

    @PostMapping(value = "/addDM")
    public ResponseDto addDMove(@RequestBody DPMoveIn dpMoveIn) {
        DepartmentMove departmentMove = new DepartmentMove();
        departmentMove.setDmId((int) Math.random() * (100000000 - 0 + 1));
        departmentMove.setDmDate(dpMoveIn.getMoveTime());
        departmentMove.setDmEndTime(dpMoveIn.getMoveTime());
        departmentMove.setDmStartTime(dpMoveIn.getMoveTime());
        departmentMove.setDmDepartmentNewId(dpMoveIn.getAfterDepartment());
        departmentMove.setDmDepartmentOldId(dpMoveIn.getOldDepartment());
        departmentMove.setDmReason(dpMoveIn.getMoveReason());
        departmentMove.setDmRemark(dpMoveIn.getNotice());
        departmentMove.setDmType(dpMoveIn.getMoveType());
        departmentMove.setDmStaffId(dpMoveIn.getStaffId());
        responseDto = commonUtil.success(dmService.addDM(departmentMove));
        return responseDto;
    }
}
