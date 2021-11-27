package com.hl.analyze.dto;

import com.hl.analyze.entity.podo.LabelValueDO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wull
 * @date 2021/11/25
 */

@Data
public class ReturnOnlnvestmentDTO implements Serializable {

    private static final long serialVersionUID = -8947705988390232553L;

    /**
     * 象限
     */
    private String quadrant;

    /**
     * 项目定义
     */
    private String projectCode;


    /**
     * 供电公司
      */
    private String unit;

    /**
     * 投资金额区间开始值
     */
    private String beginFund;

    /**
     * 投资金额区间结束值
     */
    private String endFund;


}
