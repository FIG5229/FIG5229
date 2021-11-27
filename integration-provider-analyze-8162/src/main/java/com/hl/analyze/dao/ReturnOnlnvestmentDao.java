package com.hl.analyze.dao;

import com.hl.analyze.dto.ReturnOnlnvestmentDTO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wll
 * @date 2021/11/19
 */
public interface ReturnOnlnvestmentDao {


    List<Map<String, Object>> getGcxmtxhb();

    List<Map<String, Object>> getGcxmtzpmList(ReturnOnlnvestmentDTO returnOnlnvestmentDTO);

    List<Map<String, Object>> getQuadrant();
}
