package com.hl.analyze.dao;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wll
 * @date 2021/11/19
 */
public interface DistributionTransformShowDao {

    List<Map<String, Object>> getDistributionTransformShowList(@Param("unit") String unit);
}
