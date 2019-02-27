package com.staff.staffManager.controller;

import com.staff.staffManager.dao.entity.Department;
import com.staff.staffManager.dao.entity.vo.DPVo;
import com.staff.staffManager.dao.entity.vo.ResponseDto;
import com.staff.staffManager.service.DepartmentService;
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
@RequestMapping(value = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private CommonUtil commonUtil = new CommonUtil();

    private ResponseDto responseDto = new ResponseDto();

    /**
     * 实现模糊查询部门功能，对部门信息进行模糊查询
     *
     * @param departmentVo
     * @return
     */
    @PostMapping(value = "/searchDepartment")
    public ResponseDto searchDepartment(@RequestBody DPVo departmentVo) {
        List<Department> departmentList = departmentService.searchDepartment(departmentVo.getId(), departmentVo.getName(), departmentVo.getType());
        responseDto = commonUtil.DPHelp(departmentVo, departmentList);
        return responseDto;
    }

    /**
     * 实现查询部门下人员信息方法
     *
     * @param departmentId
     * @return
     */
    @GetMapping(value = "/staffOfDepartment")
    public ResponseDto staffOfDepartment(@RequestParam long departmentId) {
        if (departmentService.searchDepartment(departmentId, "", "").size() == 0) {
            responseDto = commonUtil.error("error", "很抱歉，没有返回值", "很抱歉，数据库查询失败");
        } else {
            responseDto = commonUtil.success(departmentService.staffOfDepartment(departmentId));
        }
        return responseDto;
    }

    /**
     * 实现新增部门方法
     *
     * @param department
     * @return
     */
    @PostMapping(value = "/addDepartment")
    public ResponseDto addDepartment(@RequestBody Department department) {
        if (department == null) {
            responseDto = commonUtil.error("error", "很抱歉，输入值不能为空", "很抱歉，输入错误！");
        } else if (departmentService.searchDepartment(department.getDepartmentId(), "", "").size() > 0) {
            responseDto = commonUtil.error("error", "该部门Id已存在", "部门Id输入有误！");
        } else {
            responseDto = commonUtil.success(departmentService.addDepartment(department));
        }
        return responseDto;
    }

    /**
     * 实现部门更新方法
     *
     * @param department
     * @return
     */
    @PostMapping(value = "/updateDepartment")
    public ResponseDto updateDepartment(@RequestBody Department department) {
        if (department == null) {
            responseDto = commonUtil.error("error", "很抱歉，输入不能为空！", "很抱歉，输入为空不能返回值！");
        } else if (departmentService.searchDepartment(department.getDepartmentId(), "", "").size() == 0) {
            responseDto = commonUtil.error("error", "很抱歉，该部门不存在", "很抱歉，输入有误！");
        } else {
            responseDto = commonUtil.success(departmentService.updateDepartment(department));
        }
        return responseDto;
    }

    /**
     * 实现部门删除方法
     *
     * @param departmentId
     * @return
     */
    @DeleteMapping(value = "/deleteDepartment")
    public ResponseDto deleteDepartment(@RequestParam long departmentId) {
        if (departmentService.searchDepartment(departmentId, "", "").size() <= 0) {
            responseDto = commonUtil.error("error", "很抱歉，该部门不存在", "很抱歉，输入有误！");
        } else if (departmentService.staffOfDepartment(departmentId).size() > 0) {
            responseDto = commonUtil.error("error", "很抱歉，该部门下仍然有员工，请将所有员工转移或开除后再删除部门", "删除失败");
        } else {
            responseDto = commonUtil.success(departmentService.deleteDepartment(departmentId) == 1 ? "删除成功" : "删除失败");
        }
        return responseDto;
    }
}