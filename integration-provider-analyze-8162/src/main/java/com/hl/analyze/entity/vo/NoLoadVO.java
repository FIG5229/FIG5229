package com.hl.analyze.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hl.analyze.entity.po.NoLoad;
import lombok.Data;

/**
 *
 * 空载卡片展示数据。
 *
 * @see NoLoad
 * @author ForteScarlet
 */
@Data
public class NoLoadVO {

    /**
     * ID
     */
    private Integer id;

    /**
     * 供电所名称
     */
    @JsonProperty("powerSupply")
    private String companyName;


    /**
     * 供电所code
     */
    @JsonProperty("powerSupplyCode")
    private String companyCode;

    /**
     * 申请编号
     */
    @JsonProperty("appliedNum")
    private String reqNumber;

    /**
     * 用户名
     */
    @JsonProperty("customerName")
    private String username;

    /**
     * 用电地址
     */
    @JsonProperty("address")
    private String address;

    /**
     * 用电电压（比如 "交流380V" ）
     */
    @JsonProperty("supplyVoltage")
    private String voltage;

    /**
     * 用电类型。例如( "一般工商业" )
     */
    @JsonProperty("powerType")
    private String type;

    /**
     * 申请容量
     */
    @JsonProperty("appliedCapacity")
    private Integer reqCapacity;

    /**
     * 申请日期
     */
    // @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("appliedDate")
    private String reqTime;
}
