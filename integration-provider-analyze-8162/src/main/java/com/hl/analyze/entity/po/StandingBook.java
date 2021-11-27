package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hwx
 * @date 2021/11/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StandingBook implements Serializable {
    private static final long serialVersionUID = -5565112401077147125L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private Integer id;
    /**
     * description: 地市
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String city;
    /**
     * description: 地市编码
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String cityCode;
    /**
     * description: 区县
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String county;
    /**
     * description: 区县编码
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String countyCode;
    /**
     * description: 乡镇
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String villages;
    /**
     * description: 乡镇编码
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String villagesCode;
    /**
     * description: 台区名称
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String courtsName;
    /**
     * description: 线路
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String circuit;
    /**
     * description: 线路编码
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String circuitCode;
    /**
     * description: 容量
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String capacity;    /**
     * description: 发电量
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String generatingCapacity;    /**
     * description: 日期
     * create by: hwx
     * create time: 2021/11/10 15:44
     */
    private String date;



}
