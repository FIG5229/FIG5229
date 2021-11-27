package com.hl.analyze.service.impl;
import com.alibaba.druid.sql.PagerUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;

import com.hl.analyze.dao.ReturnOnlnvestmentDao;
import com.hl.analyze.dto.ReturnOnlnvestmentDTO;
import com.hl.analyze.entity.PageResult;
import com.hl.analyze.entity.po.EsWellMonthDataPO;
import com.hl.analyze.query.JkdlQuery;
import com.hl.analyze.service.ReturnOnInvestmentService;
import com.hl.analyze.utils.ResultUtil;
import com.integration.utils.MyPagUtile;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: 
 * @author: wull
 * @date: 2021/11/19 15:15
 */
@Service
public class ReturnOnInvestmentServiceImpl implements ReturnOnInvestmentService {

    @Autowired
    private ReturnOnlnvestmentDao returnOnlnvestmentDao;

    @Override
    public List<Map<String,Object>> getGcxmtxhb() {
        return returnOnlnvestmentDao.getGcxmtxhb();
    }

    @Override
    public PageInfo<?> getGcxmtzpmList(ReturnOnlnvestmentDTO returnOnlnvestmentDTO) {
        MyPagUtile.startPage();
        List<Map<String, Object>> gcxmtzpmList = returnOnlnvestmentDao.getGcxmtzpmList(returnOnlnvestmentDTO);
        PageInfo pageInfo = new PageInfo(gcxmtzpmList);
        return pageInfo;
    }

    @Override
    public List<List<Double>> getQuadrant() {
        List<Map<String, Object>> quadrant = returnOnlnvestmentDao.getQuadrant();
        List<List<Double>> lists = new ArrayList<>();
        for (Map<String,Object> map:quadrant){
            List<Double> list = new ArrayList<>();
            double electricQuantity = Double.parseDouble(map.get("electricQuantity").toString());
            double fund = Double.parseDouble(map.get("fund").toString());
            list.add(fund);
            list.add(electricQuantity);
            lists.add(list);
        }
        return lists;
    }

}
