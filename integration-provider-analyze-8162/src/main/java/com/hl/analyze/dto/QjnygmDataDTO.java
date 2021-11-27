package com.hl.analyze.dto;

import com.hl.analyze.entity.podo.LabelUnitDO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 清洁能源规模
 *
 * @author jason
 * @date 2021/10/25
 */

@Data
@Builder
public class QjnygmDataDTO implements Serializable {

    private static final long serialVersionUID = -5808942653583187861L;

    /**
     * 装机容量
     */
    private LabelUnitDO zjrl;

    /**
     * 绿电覆盖率
     */
    private LabelUnitDO ldfgl;

    /**
     * 分布式光伏户数
     */
    private LabelUnitDO fbsgfHs;

    /**
     * 分布式光伏装机容量
     */
    private LabelUnitDO fbsgfZjrl;

    /**
     * 集中式光伏户数
     */
    private LabelUnitDO jzsgfHs;

    /**
     * 集中式光伏装机容量
     */
    private LabelUnitDO jzsgfZjrl;

    /**
     * 风电户数
     */
    private LabelUnitDO fdHs;

    /**
     * 风电装机容量
     */
    private LabelUnitDO fdZjrl;

}
