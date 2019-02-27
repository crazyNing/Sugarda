package com.staff.staffManager.dao.entity.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Setter
@Getter
public class StaffVo {
    private long id;
    private String staffName;
    private int isTrial;
    private long staffDepartmentId;
    private int isDismiss;
    @Temporal(TemporalType.DATE)
    private Date staffHireDate;
    private long staffPositionId;
}
