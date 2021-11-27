package com.hl.analyze.entity.po;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author jason
 * @date 2021/10/21
 */

@Getter
@Setter
public class EsWellMonthDataPO {

    /**
     * 序号
     */
    @Excel(name = "序号")
    private Integer id;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String company;

    /**
     * 供电所
     */
    @Excel(name = "供电所")
    private String powerStation;

    /**
     * 户号
     */
    @Excel(name = "户号")
    private String customerNumber;

    /**
     * 户名
     */
    @Excel(name = "户名")
    private String customerName;

    /**
     * 地址
     */
    @Excel(name = "地址")
    private String address;

    /**
     * 一月
     */
    @Excel(name = "一月")
    private BigDecimal january;

    /**
     * 二月
     */
    @Excel(name = "二月")
    private BigDecimal february;

    /**
     * 三月
     */
    @Excel(name = "三月")
    private BigDecimal march;

    /**
     * 四月
     */
    @Excel(name = "四月")
    private BigDecimal april;

    /**
     * 五月
     */
    @Excel(name = "五月")
    private BigDecimal may;

    /**
     * 六月
     */
    @Excel(name = "六月")
    private BigDecimal jun;

    /**
     * 七月
     */
    @Excel(name = "七月")
    private BigDecimal jul;

    /**
     * 类型
     */
    @Excel(name = "类型")
    private String type;


}
