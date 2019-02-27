package com.staff.staffManager.controller;

import com.staff.staffManager.dao.entity.Staff;
import com.staff.staffManager.dao.entity.vo.ResponseDto;
import com.staff.staffManager.dao.entity.vo.StaffVo;
import com.staff.staffManager.service.StaffService;
import com.staff.staffManager.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工controller类
 *
 * @Author 汪宁
 */
@RestController
@RequestMapping(value = "/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;

    private ResponseDto responseDto;

    private CommonUtil commonUtil = new CommonUtil();

    /**
     * 实现查询方法，传入StaffVo所有内容，可通过序号、姓名、是否试用期、所属部门、是否离职、入职日期、所属岗位查询员工
     *
     * @param staffVo
     * @return 返回查询到的员工的所有信息
     * @Author 汪宁
     */
    @PostMapping(value = "/searchStaff")
    public ResponseDto searchStaff(@RequestBody StaffVo staffVo) {
        if (staffVo == null) {
            staffVo = new StaffVo();
        }
        List<Staff> listStaff = staffService.searchStaff(staffVo.getId(), staffVo.getStaffName(), staffVo.getIsTrial(), staffVo.getStaffDepartmentId(), staffVo.getIsDismiss(), staffVo.getStaffHireDate(), staffVo.getStaffPositionId());
        if (listStaff.size() > 0) {
            responseDto = commonUtil.success(listStaff);
        } else {
            responseDto = commonUtil.error("error", "很抱歉，没有查询到数据！", "很抱歉，没有返回数据！");
        }
        return responseDto;
    }

    /**
     * 新增员工方法，传入所有员工值
     *
     * @param staff
     * @return 返回规定格式的值
     * @Author 汪宁
     */
    @PostMapping(value = "addStaff")
    public ResponseDto addStaff(@RequestBody Staff staff) {
        if (staff == null) {
            responseDto = commonUtil.error("error", "很抱歉，要储存的值不符合要求！", "很抱歉，发生错误！");
        } else {
            Staff returnStaff = staffService.addStaff(staff);
            if (returnStaff.getStaffId() != staff.getStaffId()) {
                responseDto = commonUtil.error("error", "很抱歉，储存失败！", "很抱歉，发生错误！");
            } else {
                responseDto = commonUtil.success(returnStaff);
            }
        }
        return responseDto;
    }

    /**
     * 更新员工方法，通过Id修改员工信息
     *
     * @param staff
     * @return 返回一个规定格式的JSON串
     * @Author 汪宁
     */
    @PostMapping(value = "/updateStaff")
    public ResponseDto updateStaff(@RequestBody Staff staff) {
        if (staff == null) {
            responseDto = commonUtil.error("error", "很抱歉，要更新的值不符合要求！", "很抱歉，发生错误！");
        } else {
            Staff returnStaff = staffService.updateStaff(staff);
            if (returnStaff.getStaffId() != staff.getStaffId()) {
                responseDto = commonUtil.error("error", "很抱歉，更新失败！", "很抱歉，发生错误！");
            } else {
                responseDto = commonUtil.success(returnStaff);
            }
        }
        return responseDto;
    }

    /**
     * 删除员工方法，从数据库中删除传入Id所对应的员工
     *
     * @param staffId
     * @return
     */
    @DeleteMapping(value = "/deleteStaff")
    public ResponseDto deleteStaff(@RequestParam long staffId) {
        if (staffId == 0) {
            responseDto = commonUtil.error("error", "很抱歉，要删除的值不符合要求！", "很抱歉，发生错误！");
        } else if (staffService.searchStaff(staffId, "", 0, 0, 0, null, 0).size() >= 1) {
            int returnId = staffService.deleteStaff(staffId);
            responseDto = commonUtil.success(returnId == 1 ? "删除成功！" : "删除失败！");
        } else {
            responseDto = commonUtil.error("error", "很抱歉，未知原因删除失败！", "很抱歉，发生错误！");
        }
        return responseDto;
    }
}
