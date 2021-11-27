package com.hl.analyze.dto;

import com.hl.analyze.entity.podo.LabelUnitDO;
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
public class QjnyfdlDataDTO implements Serializable {
    private static final long serialVersionUID = 7070299619646962676L;

    private List<LabelUnitDO> list;

}
