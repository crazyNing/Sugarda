package com.staff.staffManager.dao.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DPMoveIn {
    private long oldDepartment;
    private long staffId;
    private long afterDepartment;
    private String afterPosition;
    private String moveReason;
    private String notice;
    private Date moveTime;
    private String moveType;
}
