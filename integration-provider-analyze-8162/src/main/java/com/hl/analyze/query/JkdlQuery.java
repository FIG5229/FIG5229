package com.hl.analyze.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author jason
 * @date 2021/11/9
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class JkdlQuery extends CommonQuery implements Serializable {
    private static final long serialVersionUID = -6756200457245879730L;

    /**
     * 单位
     */
    private String company;

    /**
     * 供电所名称
     */
    private String powerStation;

    /**
     * 户号
     */
    private String accountNo;

    /**
     * 户名
     */
    private String accountName;

    /**
     * 地址
     */
    private String address;

    /**
     * ldl -> 零电量
     * bgl -> 不规律电量
     * normal -> 正常
     */
    private String type;



}
