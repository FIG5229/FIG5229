package com.hl.analyze.entity.bo;

import com.hl.analyze.entity.podo.LabelUnitDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * @author jason
 * @date 2021/11/11
 */

@Getter
@Setter
@ToString
public class LabelTypeBO extends LabelUnitDO {
    private static final long serialVersionUID = -6285323827940436125L;

    private String type;

    public LabelTypeBO(String label, BigDecimal value, String unit, String type) {
        super(label, value, unit);
        this.type = type;
    }
}
