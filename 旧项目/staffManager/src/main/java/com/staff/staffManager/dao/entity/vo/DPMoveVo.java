package com.staff.staffManager.dao.entity.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class DPMoveVo {
    private Date startTime;
    private Date endTime;
    private long staffId;
    private String staffName;
    private String moveType;
}
