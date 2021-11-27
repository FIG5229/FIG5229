package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description: 光伏超容
 * create by: hwx
 * create time: 2021/11/8 17:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotovoltaicOverCapacity implements Serializable {
    private static final long serialVersionUID = -2691161555598596900L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private Integer id;

    /**
     * description: 容载比
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private String capacityLoadRatio;

    /**
     * description: 地市
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private String city;
    /**
     * description: 合同容量
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private String contractCapacity;
    /**
     * description: 球半径
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private String size;
    /**
     * description: 区县
     * create by: hwx
     * create time: 2021/11/8 16:21
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
     * description: 日期
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private String date;
    /**
     * description: 供电所
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private String managementUnitName;
    /**
     * description: 户号
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private String doorNo;
}
