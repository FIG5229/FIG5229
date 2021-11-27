package com.hl.analyze.service;

import com.github.pagehelper.PageInfo;
import com.hl.analyze.dto.ReturnOnlnvestmentDTO;
import com.hl.analyze.entity.PageResult;
import com.hl.analyze.entity.po.EsWellMonthDataPO;
import com.hl.analyze.query.JkdlQuery;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * 投资回报service
 *
 * @author ForteScarlet
 */
public interface ReturnOnInvestmentService {


    /**
     * 获取所有的工程项目投资回报排名列表信息
     * @return
     */
    List<Map<String,Object>> getGcxmtxhb();

    /**
     *工程项目投资回报排名列表信息二级列表
     * @return
     */
    PageInfo<?> getGcxmtzpmList(ReturnOnlnvestmentDTO returnOnlnvestmentDTO);

    /**
     * 散点图象限分析接口
     * @return
     */
    List<List<Double>> getQuadrant();
}
