package com.hl.analyze.entity.podo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jason
 * @date 2021/10/25
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LabelValueDO implements Serializable {
    private static final long serialVersionUID = 4373132762402513237L;

    /**
     * 标签名
     */
    private String label;

    /**
     * 值
     */
    private BigDecimal value;

}
