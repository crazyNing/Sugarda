package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工离职实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "staff_dismiss_info")
public class StaffDismiss {
    @Id
    @Column(name = "sd_id")
    private long sdId;

    @Temporal(TemporalType.DATE)
    @Column(name = "sd_date")
    private Date sdDate;

    @Column(name = "sd_type")
    private String sdType;

    @Column(name = "sd_direct")
    private String sdDirect;

    @Temporal(TemporalType.DATE)
    @Column(name = "sd_start_time")
    private Date sdStartTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "sd_end_time")
    private Date sdEndTime;

    @Column(name = "sd_remark")
    private String sdRemark;

    @Column(name = "sd_staff_id")
    private long sdStaffId;

    @Column(name = "sd_department_id")
    private long sdDepartmentId;

    @Column(name = "sd_position_id")
    private long sdPositionId;
}
