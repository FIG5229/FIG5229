package com.hl.analyze.service;

import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * 配变展示service
 *
 * @author ForteScarlet
 */
public interface DistributionTransformShowService {


    /**
     * 新增配变二级列表
     * @param unit
     * @return
     */
    PageInfo<?> getDistributionTransformShowList(String unit);


}
