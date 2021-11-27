package com.hl.analyze.entity.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 轻空载配变
 *
 * 2021-11-25 轻空载更名为轻载，LightNoLoad -> LightLoad
 * 同时修改所有相关与表名
 *
 */
@Data
public class LightLoad {
    // 增加字段记得去DAO的SQL里增加对应字段

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer id;

    /**
     * 变压器ID
     */
    private String transformerId;

    /**
     * 变压器名称
     */
    private String transformerName;

    /**
     * 最大负载率
     */
    private BigDecimal maxLoadRate;

    /**
     * 平均负载率
     */
    private BigDecimal avgLoadRate;

    /**
     * 供电所名称
     */
    private String company;

    /**
     * 供电所code
     */
    private String companyCode;

    /**
     * 额定容量
     */
    private BigDecimal ratedCapacity;

    /**
     * 设备状态。1：在运
     */
    private Byte deviceStatus;

    public String deviceStatusToString() {
        if (deviceStatus == 1) {
            return "在运";
        }
        return "未知";
    }

    /**
     * 是否农网。1：农网，2：城网
     */
    private Byte networkType;

    public String networkTypeToString() {
        switch (networkType) {
            case 1:
                return "农网";
            case 2:
                return "城网";
            default:
                return "未知";
        }
    }

    /**
     * 投运日期
     */
    private Date inUseDate;

    /**
     * 期别
     */
    private String year;

    /**
     * 县公司名称
     */
    private String countyCompany;

    /**
     * 最大电流。
     * =F2*1.44*C2/100
     * =最大负载率*1.44*额定容量/100
     */
    private BigDecimal maxCurrent;

    /**
     * 匹配最小容量
     * =L2/0.8/1.44
     * =最大电流/0.8/1.44
     */
    private BigDecimal matchMinCapacity;


    /**
     * 匹配最合适容量
     * 2021/11/24 增加
     * <tt>=L115/0.6/1.44</tt>
     * <tt>={@link #maxCurrent 最大电流}/0.6/1.44</tt>
     */
    private BigDecimal matchingMostSuitableCapacity;


    /**
     * 可接入容量
     * 2021/1/24 增加
     *
     * <tt>=F104-N104</tt>
     * <tt>=额定容量-{@link #matchingMostSuitableCapacity 匹配最合适容量}</tt>
     *
     */
    private BigDecimal accessibleCapacity;


    /**
     * 计算 {@link #matchMinCapacity} 并赋值。
     * 如果 {@link #maxCurrent} 未计算，则先计算。
     *
     * @throws NullPointerException 如果所需属性为null。
     */
    public void calculateMatchMinCapacity() {
        // 未来如果用得到就写，没用就删了就行
    }

    /**
     * 计算 {@link #maxCurrent} 并赋值。
     *
     * @throws NullPointerException 如果所需属性为null。
     */
    public void calculateMaxCurrent() {
        // todo if need, delete if not needed
    }
}