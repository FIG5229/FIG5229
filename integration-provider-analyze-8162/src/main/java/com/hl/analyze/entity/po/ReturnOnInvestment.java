package com.hl.analyze.entity.po;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * description: 工程投资回报排名
 * create by: wll
 * create time: 2021/11/19 14:45
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnOnInvestment implements Serializable {


    /**
     * description: id
     * create by: wll
     * create time: 2021/11/19 14:46
     */
    private Integer id;

    /**
     * description: unit
     * create by: wll
     * create time: 2021/11/19 14:46
     */
    private String unit;

    /**
     * description: projectName
     * create by: wll
     * create time: 2021/11/19 14:46
     */
    private String projectName;

    /**
     * description: fund
     * create by: wll
     * create time: 2021/11/19 14:46
     */
    private BigDecimal fund;

    /**
     * description: electricQuantity
     * create by: wll
     * create time: 2021/11/19 14:46
     */
    private BigDecimal electricQuantity;

    /**
     * description: returns
     * create by: wll
     * create time: 2021/11/19 14:46
     */
    private BigDecimal returns;

    /**
     * description: projectCode
     * create by: wll
     * create time: 2021/11/19 14:46
     */
    private String projectCode;

    /**
     * description: year
     * create by: wll
     * create time: 2021/11/19 14:46
     */
    private String year;
}
