package com.hl.analyze.entity.po;

import java.util.Date;
import lombok.Data;

/**
 * 重载/轻载/空载配变统一表
 */
@Data
public class Loads {
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
    private String maxLoadRate;

    /**
     * 平均负载率
     */
    private String avgLoadRate;

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
    private String ratedCapacity;

    /**
     * 设备状态。1：在运
     */
    private Byte deviceStatus;

    /**
     * 是否农网。1：农网，2：城网
     */
    private Byte networkType;

    /**
     * 投运日期
     */
    private Date inUseDate;

    /**
     * 期别
     */
    private String year;

    /**
     * 所属地市名称
     */
    private String cityCompany;

    /**
     * 县公司名称
     */
    private String countyCompany;

    /**
     * 最大电流。
     * =F2*1.44*C2/100
     * =最大负载率*1.44*额定容量/100
     */
    private String maxCurrent;

    /**
     * 匹配最小容量
     * =M2/0.8/1.44
     * =最大电流/0.8/1.44
     */
    private String matchMinCapacity;

    /**
     * 匹配最合适容量
     */
    private String matchingMostSuitableCapacity;

    /**
     * 0: 空载 1: 轻载 2: 重载
     */
    private Short loadType;



    public String deviceStatusToString() {
        if (deviceStatus == 1) {
            return "在运";
        }
        return "未知";
    }

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

    public Type type() {
        // 调用者确保 loadType 不能为null。
        return Type.byCode(loadType);
    }

    public enum Type {
        NO(0),
        LIGHT(1),
        HEAVY(2);

        public final short code;
        Type(int typeCode) {
            code = (short) typeCode;
        }

        // NotNull
        public static Type byCode(int code) {
            switch (code) {
                case 0: return NO;
                case 1: return LIGHT;
                case 2: return HEAVY;
                default: throw new IllegalArgumentException("Unknown type code " + code);
            }
        }
    }
}