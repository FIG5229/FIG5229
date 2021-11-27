package com.hl.analyze.entity.po;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 客户需求
 * <p>
 * 2021-11-25 客户需求更名为空载，CustomerNeeds -> NoLoad
 * 同时更名所有相关以及表名。表数据也有所变动
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NoLoad extends Loads {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 供电所名称
     */
    private String companyName;

    /**
     * 供电所code
     */
    private String companyCode;

    /**
     * 申请编号
     */
    private String reqNumber;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用电地址
     */
    private String address;

    /**
     * 用电电压（比如 "交流380V" ）
     */
    private String voltage;

    /**
     * 用电类型。例如( "一般工商业" )
     */
    private String type;

    /**
     * 申请容量
     */
    private Integer reqCapacity;

    /**
     * 申请日期
     */
    private Date reqTime;
}