package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description: 装机容量
 * create by: hwx
 * create time: 2021/11/8 17:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstalledCapacity implements Serializable {
    private static final long serialVersionUID = 625276160229175695L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private Integer id;
    
    /**
     * description: 行政区域
     * create by: hwx
     * create time: 2021/11/8 17:03
     */
    private String city;
    /**
     * description: 区县
     * create by: hwx
     * create time: 2021/11/8 17:03
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
     * description: 风电装机(万千瓦)
     * create by: hwx
     * create time: 2021/11/8 17:03
     */
    private String windPower;

    /**
     * description: 光伏装机(万千瓦)集中式
     * create by: hwx
     * create time: 2021/11/8 17:03
     */
    private String photovoltaicPowerCentralization;

    /**
     * description: 光伏装机(万千瓦)分布式
     * create by: hwx
     * create time: 2021/11/8 17:03
     */
    private String photovoltaicPowerDistributed;
    /**
     * description: 小计
     * create by: hwx
     * create time: 2021/11/8 17:03
     */
    private String subtotal;
    /**
     * description: 生物质装机(万千瓦)
     * create by: hwx
     * create time: 2021/11/8 17:03
     */
    private String biomassMachine;

    /**
     * description: 新能源装机(万千瓦)
     * create by: hwx
     * create time: 2021/11/8 17:03
     */
    private String newEnergy;

    /**
     * description: 月份
     * create by: hwx
     * create time: 2021/11/8 17:03
     */
    private String date;

}
