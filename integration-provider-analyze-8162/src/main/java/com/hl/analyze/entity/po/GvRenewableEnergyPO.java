package com.hl.analyze.entity.po;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * gv_renewable_energy 综合概览/可再生能源消纳表
 *
 * @author jason
 */
@Getter
@Setter
public class GvRenewableEnergyPO implements Serializable {

    private static final long serialVersionUID = -2930366895115938755L;

    /**
     * Id
     */
    private Integer id;

    /**
     * 数据时间
     */
    private String date;

    /**
     * 数据年份
     */
    private Object year;

    /**
     * 数据月份
     */
    private String month;

    /**
     * 区县名称
     */
    private String districtName;

    /**
     * 风电装机容量(万千瓦）
     */
    private BigDecimal windPowerCapacity;

    /**
     * 集中式光伏装机容量(万千瓦）
     */
    private BigDecimal centralCapacity;

    /**
     * 分布式光伏装机容量(万千瓦）
     */
    private BigDecimal distributedCapacity;

    /**
     * 光伏总装机容量(万千瓦）
     */
    private BigDecimal photovoltaicCapacity;

    /**
     * 生物质装机容量(万千瓦）
     */
    private BigDecimal biomassCapacity;

    /**
     * 新能源装机容量(万千瓦）
     */
    private BigDecimal newEnergyCapacity;

    /**
     * 风电发电量(亿千瓦时）
     * 风电发电量(亿千瓦时）
     */
    private BigDecimal windGeneratingPower;

    /**
     * 集中式光伏发电量(亿千瓦时）
     */
    private BigDecimal centralGeneratingPower;

    /**
     * 分布式光伏发电量(亿千瓦时）
     */
    private BigDecimal distributedGeneratingPower;

    /**
     * 光伏总发电量(亿千瓦时）
     */
    private BigDecimal photovoltaicGeneratingPower;

    /**
     * 生物质发电量(亿千瓦时）
     */
    private BigDecimal biomassGeneratingPower;

    /**
     * 发电量合计(亿千瓦时）
     */
    private BigDecimal newEnergyGeneratingPower;

    /**
     * 全社会用电量/实际电量(亿千瓦时）
     */
    private BigDecimal socialElectricityConsumption;

    /**
     * 外电电量/非水(亿千瓦时）
     */
    private BigDecimal nonWater;

    /**
     * 非水最低权重（%）
     */
    private BigDecimal nonWaterMinimumWeight;

    /**
     * 非水激励权重（%）
     */
    private BigDecimal nonWaterIncentiveWeight;

    /**
     * 非水权重
     */
    private BigDecimal nonWaterWeight;

    /**
     * 占比（%）
     */
    private BigDecimal proportion;

    /**
     * 地市编码
     */
    private String cityCode;

    /**
     * 地市名称
     */
    private String cityName;

    /**
     * 区县编码
     */
    private String districtCode;

}