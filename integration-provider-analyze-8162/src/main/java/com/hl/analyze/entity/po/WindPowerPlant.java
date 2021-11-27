package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description: 风电站
 * create by: hwx
 * create time: 2021/11/8 17:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WindPowerPlant implements Serializable {
    private static final long serialVersionUID = -1971548008604493262L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private Integer id;
    
    /**
     * description: 风电场名称
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String windPowerPlantName;
    /**
     * description: 所在地市
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String city;
    /**
     * description: 所在区
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String county;

    /**
     * description: 地市编码
     * create by: hwx
     * create time: 2021/11/8 16:22
     */
    private String cityCode;

    /**
     * description: 区县
     * create by: hwx
     * create time: 2021/11/8 16:22
     */
    private String countyCode;
    /**
     * description: 实际并网容量
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String protocolCapacity;

    /**
     * description: 现数据库容量
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String databaseCapacity;

    /**
     * description: 机组台数
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String unitNumber;

    /**
     * description: 电压等级
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String voltageClasses;

    /**
     * description: 并网线
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String multipleCircuit;

    /**
     * description: 并网点
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String pointOfInterconnection;


}
