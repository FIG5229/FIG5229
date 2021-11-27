package com.hl.analyze.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: zhouy
 * @DateL 2021/10/26 11:46
 * @ClassName: ZeroElectricityDTO
 **/
@Data
public class ZeroElectricityDTO implements Serializable {
    private static final long serialVersionUID = -3109994307355629972L;

    private Integer id;

    /**
     * 单位编码
     */
    private String companyCode;

    /**
     * 客户编号
     */
    private String customerNumber;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 客户地址
     */
    private String address;
    /**
     * 所属区县
     */
    private String countyName;
    /**
     * 所属供电所
     */
    private String company;
    /**
     * 坐标
     */
    private String axis;
    /**
     * 坐标集合
     */
    private List<BigDecimal> coordinate;

}
