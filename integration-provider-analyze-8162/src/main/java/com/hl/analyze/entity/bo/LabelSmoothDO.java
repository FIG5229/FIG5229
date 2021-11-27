package com.hl.analyze.entity.bo;

import com.hl.analyze.entity.podo.LabelValueDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author jason
 * @date 2021/11/11
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class LabelSmoothDO extends LabelValueDO implements Serializable {
    private static final long serialVersionUID = -8307240562950415304L;

    private Boolean smooth;

}
