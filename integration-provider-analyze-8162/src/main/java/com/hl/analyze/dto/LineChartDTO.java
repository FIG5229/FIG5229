package com.hl.analyze.dto;

import com.hl.analyze.entity.bo.ChartDataBO;
import com.hl.analyze.entity.bo.NameBO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author jason
 * @date 2021/11/11
 */

@Data
@Builder
public class LineChartDTO implements Serializable {
    private static final long serialVersionUID = 8714583028825122460L;

    private NameBO tabData;

    private List<ChartDataBO> chartData;


}
