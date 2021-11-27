package com.hl.analyze.entity.po;

import lombok.Getter;
import lombok.Setter;

/**
 * @author jason
 * @date 2021/10/21
 */

@Getter
@Setter
public class EsDataOverviewPO {

    private Integer id;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 展示标签
     */
    private String label;

    /**
     * 值
     */
    private String value;

    /**
     * 单位
     */
    private String unit;

    /**
     * 类型：jjt-机井通，mgd-煤改电
     */
    private String type;

}
