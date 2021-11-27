package com.hl.analyze.query;

import com.hl.analyze.entity.po.NoLoad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 空载列表查询条件。
 *
 * @see NoLoad
 *
 * @author ForteScarlet
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NoLoadListQuery extends CommonQuery {

    // 备用

    /**
     * ID
     */
    private Integer id;

    /**
     * 供电所名称
     */
    private String companyName;

    /**
     * 申请编号
     */
    private String reqNumber;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用电地址
     */
    private String address;

    /**
     * 用电电压（比如 "交流380V" ）
     */
    private String voltage;

    /**
     * 用电类型。例如( "一般工商业" )
     */
    private String type;

    /**
     * 申请容量
     */
    private Integer reqCapacity;

    /**
     * 申请日期
     */
    private Date reqTime;

}
