package com.hl.analyze.entity.vo;

import com.hl.analyze.entity.po.LightLoad;
import lombok.Data;

import java.math.BigDecimal;

/**
 *
 * 低空载卡片展示数据。
 *
 * @see LightLoad
 * @author ForteScarlet
 */
@Data
public class LightLoadVO {

    /**
     * 投运日期
     */
    private String inUseDate;

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
    private BigDecimal maxLoadRate;

    /**
     * 平均负载率
     */
    private BigDecimal avgLoadRate;

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
    private BigDecimal ratedCapacity;

    /**
     * 设备状态。1：在运
     */
    private String deviceStatus;

    /**
     * 是否农网。1: 农网，2: 城网
     */
    private String networkType;

    /**
     * 期别
     */
    private String year;

    /**
     * 县公司名称
     */
    private String countyCompany;

    /**
     * 最大电流。
     * =F2*1.44*C2/100
     * =最大负载率*1.44*额定容量/100
     */
    private BigDecimal maxCurrent;

    /**
     * 匹配最小容量
     * =L2/0.8/1.44
     * =最大电流/0.8/1.44
     */
    private BigDecimal matchMinCapacity;


    /**
     * 匹配最合适容量
     * 2021/11/24 增加
     * <tt>=L115/0.6/1.44</tt>
     * <tt>={@link #maxCurrent 最大电流}/0.6/1.44</tt>
     */
    private BigDecimal matchingMostSuitableCapacity;


    /**
     * 可接入容量
     * 2021/1/24 增加
     *
     * <tt>=F104-N104</tt>
     * <tt>=额定容量-{@link #matchingMostSuitableCapacity 匹配最合适容量}</tt>
     *
     */
    private BigDecimal accessibleCapacity;
}
