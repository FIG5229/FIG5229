package com.hl.analyze.dto;

import com.hl.analyze.entity.podo.LabelValueDO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jason
 * @date 2021/11/10
 */

@Data
@Builder
public class BarGraphDTO implements Serializable {

    private static final long serialVersionUID = 7368445026201451733L;

    /**
     * 名称
     */
    private String name;

    /**
     * 名称
     */
    private String unit;

    private List<LabelValueDO> data;

}
