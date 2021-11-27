package com.hl.analyze.entity.podo;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author jason
 * @date 2021/10/25
 */

@Data
@ToString
@EqualsAndHashCode(callSuper = true)
public class LabelUnitDO extends LabelValueDO {
    private static final long serialVersionUID = -1766040586595983894L;

    /**
     * 计量单位
     */
    private String unit;


    public LabelUnitDO(String label, BigDecimal value) {
        super.setLabel(label);
        super.setValue(value);
    }

    public LabelUnitDO(BigDecimal value, String unit) {
        super.setValue(value);
        this.unit = unit;
    }
    public LabelUnitDO(String label, BigDecimal value, String unit) {
        super.setLabel(label);
        super.setValue(value);
        this.unit = unit;
    }
}
