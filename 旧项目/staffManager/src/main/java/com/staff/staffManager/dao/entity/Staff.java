package com.staff.staffManager.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * 员工实体类
 *
 * @Author 汪宁
 */
@Setter
@Getter
@Entity
@Table(name = "staff_info")
public class Staff {

    @Id
    @Column(name = "staff_id")
    private long staffId;

    @Column(name = "staff_is_dismiss")
    private int staffIsDismiss;

    @Column(name = "staff_is_trial")
    private int staffIsTrial;

    @Column(name = "staff_name")
    private String staffName;

    @Column(name = "staff_sex")
    private String staffSex;

    @Column(name = "staff_phone")
    private String staffPhone;

    @Column(name = "staff_id_number")
    private String staffIdNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "staff_birthday")
    private Date staffBirthday;

    @Column(name = "staff_work_form")
    private String staffWorkForm;

    @Column(name = "staff_source")
    private String staffSource;

    @Column(name = "staff_political_outlook")
    private String staffPoliticalOutlook;

    @Column(name = "staff_nation")
    private String staffNation;

    @Column(name = "staff_mail")
    private String staffMail;

    @Column(name = "staff_height")
    private String staffHeight;

    @Column(name = "staff_blood_type")
    private String staffBloodType;

    @Column(name = "staff_marital_status")
    private String staffMaritalStatus;

    @Column(name = "staff_native_place")
    private String staffNativePlace;

    @Column(name = "staff_birth_place")
    private String staffBirthPlace;

    @Column(name = "staff_address_local")
    private String staffAddressLocal;

    @Column(name = "staff_graduate_school")
    private String staffGraduateSchool;

    @Column(name = "staff_specialty")
    private String staffSpecialty;

    @Temporal(TemporalType.DATE)
    @Column(name = "staff_graduate_date")
    private Date staffGraduateDate;

    @Column(name = "staff_last_education")
    private String staffLastEducation;

    @Column(name = "staff_last_degree")
    private String staffLastDegree;

    @Column(name = "staff_department_id")
    private long staffDepartmentId;

    @Column(name = "staff_position_id")
    private long staffPositionId;

    @Column(name = "staff_sal")
    private Double staffSal;

    @Column(name = "staff_other")
    private String staffOther;

    @Column(name = "staff_language_id")
    private long staffLanguageId;

    @Column(name = "staff_career_id")
    private long staffCareerId;

    @Temporal(TemporalType.DATE)
    @Column(name = "staff_hire_date")
    private Date staffHireDate;
}
