package com.hl.analyze.query;

import com.hl.analyze.entity.po.Loads;
import com.hl.analyze.entity.po.NoLoad;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

/**
 * 负载 列表查询条件。
 *
 * @see com.hl.analyze.entity.po.Loads
 *
 * @author ForteScarlet
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LoadsQuery extends Loads {

    private List<Integer> idList;
    private List<String> transformerIdList;

}
