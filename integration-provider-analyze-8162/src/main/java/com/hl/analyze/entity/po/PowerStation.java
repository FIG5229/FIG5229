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
public class PowerStation implements Serializable {

    private static final long serialVersionUID = -1275746686821535794L;
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
    private String powerStationName;
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
     * description: 电压等级
     * create by: hwx
     * create time: 2021/11/8 16:28
     */
    private String voltageClasses;


}
