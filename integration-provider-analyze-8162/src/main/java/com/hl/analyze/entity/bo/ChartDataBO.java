package com.hl.analyze.entity.bo;

import com.hl.analyze.entity.podo.LabelValueDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author jason
 * @date 2021/11/11
 */

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChartDataBO extends NameBO implements Serializable {
    private static final long serialVersionUID = 9157390331070548028L;

    private Boolean smooth;

    private List<LabelValueDO> data;

    public ChartDataBO(String name, Boolean smooth) {
        super(name);
        this.smooth = smooth;
    }

    public ChartDataBO(String name, Boolean smooth, List<LabelValueDO> data) {
        super(name);
        this.smooth = smooth;
        this.data = data;
    }
}
