package com.staff.staffManager.dao.entity.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;


/**
 * 通用返回JSON格式
 *
 * @Author 汪宁
 */
@Setter
@Getter
public class ResponseDto {
    private String code;
    private String message;
    private Object data;
}
