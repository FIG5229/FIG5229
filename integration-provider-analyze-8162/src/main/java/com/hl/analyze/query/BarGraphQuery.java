package com.hl.analyze.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author jason
 * @date 2021/11/11
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class BarGraphQuery extends CommonQuery{
    private static final long serialVersionUID = -7351036226157372864L;

    private String type;

    private String time;

}
