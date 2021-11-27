package com.hl.analyze.entity.vo;

import com.hl.analyze.entity.po.NoLoad;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 空载卡片数据
 *
 * @see NoLoad
 * @author ForteScarlet
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class NoLoadCard extends ResourcePoolCard {


    /**
     * 供电所名称
     */
    private String companyName;

    /**
     * 供电所Code
     */
    private String companyCode;

    /**
     * 申请编号
     */
    private String reqNumber;

    /**
     * 用户名
     */
    private String username;


    /**
     * 申请容量
     */
    private Integer reqCapacity;



}
