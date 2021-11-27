package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 光伏电站
 * @author hwx
 * @date 2021/11/8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotovoltaicPowerStation implements Serializable {

    private static final long serialVersionUID = 4946939636504514173L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private Integer id;
    /**
     * description: 电站名称
     * create by: hwx
     * create time: 2021/11/8 16:22
     */
    private String powerStationName;
    /**
     * description: 地市
     * create by: hwx
     * create time: 2021/11/8 16:22
     */
    private String city;

    /**
     * description: 区县
     * create by: hwx
     * create time: 2021/11/8 16:22
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
     * description: 电压等级
     * create by: hwx
     * create time: 2021/11/8 16:22
     */
    private String voltageClasses;

    /**
     * description: 并网线
     * create by: hwx
     * create time: 2021/11/8 16:23
     */
    private String multipleCircuit;
    

    /**
     * description: 并网点
     * create by: hwx
     * create time: 2021/11/8 16:23
     */
    private String pointOfInterconnection;

    /**
     * description: 实际容量
     * create by: hwx
     * create time: 2021/11/8 16:23
     */
    private String actualCapacity;

}
