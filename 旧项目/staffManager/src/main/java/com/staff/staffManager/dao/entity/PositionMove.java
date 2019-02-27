package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 岗位调动实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "position_move_info")
public class PositionMove {

    @Id
    @Column(name = "pm_id")
    private long pmId;

    @Column(name = "pm_type")
    private String pmType;

    @Column(name = "pm_reason")
    private String pmReason;

    @Column(name = "pm_remark")
    private String pmRemark;

    @Temporal(TemporalType.DATE)
    @Column(name = "pm_start_time")
    private Date pmStartTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "pm_date")
    private Date pmDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "pm_end_time")
    private Date pmEndTime;

    @Column(name = "pm_staff_id")
    private long pmStaffId;

    @Column(name = "pm_position_old_id")
    private long pmPositionOldId;

    @Column(name = "pm_position_new_id")
    private long pmPositionNewId;
}
