package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 部门调动实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "department_move_info")
public class DepartmentMove {
    @Id
    @Column(name = "dm_id")
    private long dmId;

    @Column(name = "dm_type")
    private String dmType;

    @Column(name = "dm_reason")
    private String dmReason;

    @Column(name = "dm_remark")
    private String dmRemark;

    @Temporal(TemporalType.DATE)
    @Column(name = "dm_start_time")
    private Date dmStartTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "dm_date")
    private Date dmDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "dm_end_time")
    private Date dmEndTime;

    @Column(name = "dm_staff_id")
    private long dmStaffId;

    @Column(name = "dm_department_old_id")
    private long dmDepartmentOldId;

    @Column(name = "dm_department_new_id")
    private long dmDepartmentNewId;
}
