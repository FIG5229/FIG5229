package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description: 发电异常用户
 * create by: hwx
 * create time: 2021/11/8 17:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotovoltaicSubsidies implements Serializable {
    private static final long serialVersionUID = -4562822362152244491L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private Integer id;
    /**
     * description: 单位名称
     * create by: hwx
     * create time: 2021/11/8 16:44
     */
    private String companyName;
    /**
     * description: 户号
     * create by: hwx
     * create time: 2021/11/8 16:44
     */
    private String doorNo;

    /**
     * description: 发电量
     * create by: hwx
     * create time: 2021/11/8 16:44
     */
    private String generatingCapacity;
    /**
     * description: 发行日期
     * create by: hwx
     * create time: 2021/11/8 16:44
     */
    private String releaseDate;
    /**
     * description: 累计发电量
     * create by: hwx
     * create time: 2021/11/8 16:44
     */
    private String accumulatedGeneratingCapacity;
    /**
     * description: 地市
     * create by: hwx
     * create time: 2021/11/8 16:44
     */
    private String city;
    /**
     * description: 分中心
     * create by: hwx
     * create time: 2021/11/8 16:44
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
     * description: 管理单位名称
     * create by: hwx
     * create time: 2021/11/8 16:44
     */
    private String managementUnitName;
    /**
     * description: 合同容量
     * create by: hwx
     * create time: 2021/11/8 16:44
     */
    private String contractCapacity;

}
