package com.hl.analyze.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author ForteScarlet
 * @see com.hl.analyze.entity.po.Loads
 */
@Data
public class LoadsVO {

    /**
     * ID
     */
    private Integer id;

    /**
     * 变压器ID
     */
    private String transformerId;

    /**
     * 变压器名称
     */
    private String transformerName;

    /**
     * 最大负载率
     */
    private String maxLoadRate;

    /**
     * 平均负载率
     */
    private String avgLoadRate;

    /**
     * 供电所名称
     */
    private String company;

    /**
     * 供电所code
     */
    private String companyCode;

    /**
     * 额定容量
     */
    private String ratedCapacity;

    /**
     * 设备状态。1：在运
     */
    private String deviceStatus;

    /**
     * 是否农网。1：农网，2：城网
     */
    private String networkType;

    /**
     * 投运日期
     */
    private String inUseDate;

    /**
     * 期别
     */
    private String year;

    /**
     * 所属地市名称
     */
    private String cityCompany;

    /**
     * 县公司名称
     */
    private String countyCompany;

    /**
     * 最大电流。
     * =F2*1.44*C2/100
     * =最大负载率*1.44*额定容量/100
     */
    private String maxCurrent;

    /**
     * 匹配最小容量
     * =M2/0.8/1.44
     * =最大电流/0.8/1.44
     */
    private String matchMinCapacity;

    /**
     * 匹配最合适容量
     */
    private String matchingMostSuitableCapacity;

    /**
     * 0: 空载 1: 轻载 2: 重载
     */
    private Short loadType;

}
