package com.hl.analyze.entity.po;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * gv_clean_energy 清洁能源发展趋势
 *
 * @author jason
 */
@Data
public class GvCleanEnergyPO implements Serializable {
    private Integer id;

    private String year;

    /**
     * 新能源装机容量(万千瓦）
     */
    private BigDecimal newEnergyCapacity;

    /**
     * 风电装机容量(万千瓦）
     */
    private BigDecimal windPowerCapacity;

    /**
     * 光伏总装机容量(万千瓦）
     */
    private BigDecimal photovoltaicCapacity;

    /**
     * 生物质装机容量(万千瓦）
     */
    private BigDecimal biomassCapacity;

    /**
     * 火电装机容量(万千瓦）
     */
    private BigDecimal thermalPowerCapacity;

    /**
     * 装机容量（千瓦时）
     */
    private BigDecimal capacity;

    /**
     * 新能源占比
     */
    private BigDecimal newEnergyCapacityRatio;

    /**
     * 风电占比
     */
    private BigDecimal windPowerCapacityRatio;

    /**
     * 光伏占比
     */
    private BigDecimal photovoltaicCapacityRatio;

    /**
     * 生物质占比
     */
    private BigDecimal biomassCapacityRatio;

    /**
     * 火电装机占比
     */
    private BigDecimal thermalPowerCapacityRatio;

    /**
     * 新能源发电量
     */
    private BigDecimal newEnergyGeneratingPower;

    /**
     * 风电发电量
     */
    private BigDecimal windGeneratingPower;

    /**
     * 光伏发电量
     */
    private BigDecimal photovoltaicGeneratingPower;

    /**
     * 生物质发电量
     */
    private BigDecimal biomassGeneratingPower;

    /**
     * 火电发电量
     */
    private BigDecimal thermalGeneratingPower;

    /**
     * 区外发电量
     */
    private BigDecimal outsideGeneratingPower;

    /**
     * 全社会发电量
     */
    private BigDecimal socialGeneratingPower;

    /**
     * 发电量占比
     */
    private BigDecimal powerRatio;

    /**
     * 风电占比
     */
    private BigDecimal windPowerRatio;

    /**
     * 光伏发电量占比
     */
    private BigDecimal photovoltaicRatio;

    /**
     * 生物质发电量占比
     */
    private BigDecimal biomassRadio;

    /**
     * 火电发电量占比
     */
    private BigDecimal thermalRadio;

    /**
     * 区外发电量占比
     */
    private BigDecimal outsideRadio;

    private static final long serialVersionUID = 1L;
}