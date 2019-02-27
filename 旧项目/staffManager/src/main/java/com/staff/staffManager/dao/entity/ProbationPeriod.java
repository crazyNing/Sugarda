package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 试用期实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "probation_period_manage_info")
public class ProbationPeriod {

    @Id
    @Column(name = "pp_id")
    private long ppId;

    @Column(name = "pp_result")
    private String ppResult;

    @Column(name = "pp_state")
    private String ppState;

    @Temporal(TemporalType.DATE)
    @Column(name = "pp_start_time")
    private Date ppStartTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "pp_end_time")
    private Date ppEndTime;

    @Column(name = "pp_dept_remark")
    private String ppDeptRemark;

    @Temporal(TemporalType.DATE)
    @Column(name = "pp_operate_date")
    private Date ppOperateDate;

    @Column(name = "pp_staff_id")
    private long ppStaffId;

    @Column(name = "pp_department_id")
    private long ppDepartmentId;

    @Column(name = "pp_position_id")
    private long ppPositionId;
}
