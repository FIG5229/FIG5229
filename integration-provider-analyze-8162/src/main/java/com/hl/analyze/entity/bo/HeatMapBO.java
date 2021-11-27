package com.hl.analyze.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author jason
 * @date 2021/11/11
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeatMapBO {

    private String orgNo;

    private String orgName;

    private BigDecimal value;

}
