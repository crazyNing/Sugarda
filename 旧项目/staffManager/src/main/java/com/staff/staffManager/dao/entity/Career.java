package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 语言能力实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "career_info")
public class Career {

    @Id
    @Column(name = "ci_id")
    private long ciId;

    @Temporal(TemporalType.DATE)
    @Column(name = "ci_start_time")
    private Date ciStartTime;

    @Temporal(TemporalType.DATE)
    @Column(name = "ci_end_time")
    private Date ciEndTime;

    @Column(name = "ci_place_name")
    private String ciPlaceName;

    @Column(name = "ci_work_info")
    private String ciWorkInfo;

    @Column(name = "ci_position")
    private String ciPosition;

    @Column(name = "ci_year_sal")
    private String ciYearSal;

    @Column(name = "ci_month_sal")
    private String ciMonthSal;

    @Column(name = "ci_wit")
    private String ciWit;

    @Column(name = "ci_wit_position")
    private String ciWitPosition;

    @Column(name = "ci_wit_phone")
    private String ciWitPhone;

    @Column(name = "ci_remark")
    private long ciRemark;

}
