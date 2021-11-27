package com.hl.analyze.dto;

import com.hl.analyze.entity.podo.LabelValueDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author jason
 * @date 2021/11/9
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IrrigationPowerDTO implements Serializable {
    private static final long serialVersionUID = 7835985403942333101L;

    private Boolean smooth;

    private String type;

    private List<LabelValueDO> data;

}
