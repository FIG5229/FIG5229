package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description: 分布式光伏
 * create by: hwx
 * create time: 2021/11/8 17:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DistributedPhotovoltaic implements Serializable {
    private static final long serialVersionUID = 1858590024328611318L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private Integer id;
    /**
     * description: 户号
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String doorNo;

    /**
     * description: 所属网省
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String province;

    /**
     * description: 所属地市
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String city;

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
     * description: 用户名称
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String username;

    /**
     * description: 发电容量（千瓦）
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String generatingCapacity;

    /**
     * description: 并网点电压等级
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String voltageClasses;

    /**
     * description: 所属区县
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String county;

    /**
     * description: 地理位置
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String geographicPosition;

    /**
     * description: 台区名称
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String courtsName;

    /**
     * description: 台区编码
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String courtsNumber;

    /**
     * description: 经度
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String longitude;

    /**
     * description: 纬度
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String latitude;

    /**
     * description: 所属乡镇
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String village;

    /**
     * description: 所属10kV线路
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String circuit;

    /**
     * description: 母线名称
     * create by: hwx
     * create time: 2021-11-8 17:15:53
     */
    private String generatrix;

}
