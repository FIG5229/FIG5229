package com.hl.analyze.service;

import com.hl.analyze.dto.BarGraphDTO;
import com.hl.analyze.dto.LineChartDTO;
import com.hl.analyze.dto.QjnyfdlDataDTO;
import com.hl.analyze.dto.QjnygmDataDTO;
import com.hl.analyze.query.BarGraphQuery;
import com.hl.analyze.query.CommonQuery;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/11/10
 */
public interface GeneralViewService {

    /**
     *
     * @param commonQuery
     * @return
     */
    Map<String, Object> getGeoHeatmapData(CommonQuery commonQuery);

    /**
     * 获取清洁能源规模
     *
     * @param commonQuery 通用查询参数
     * @return
     */
    QjnygmDataDTO getQjnygmDataByAreaCode(CommonQuery commonQuery);

    /**
     * 获取清洁能源规模
     *
     * @param commonQuery 通用查询参数
     * @return
     */
    QjnyfdlDataDTO getQjnyfdlDataByAreaCode(CommonQuery commonQuery);

    /**
     * 创建
     *
     * @param barGraphQuery 通用查询参数
     *                      time->年月
     *                      type->qjnygm：(清洁能源规模)装机容量，ldfgl：绿电覆盖率，fbsgf：分布式光伏，jzsgf：集中式光伏，fd：风电
     * @return BarGraphDTO.class
     */
    BarGraphDTO getQjnygmDetail(BarGraphQuery barGraphQuery);

    /**
     * 创建
     *
     * @param barGraphQuery 通用查询参数
     *                      time->年月
     *                      type->社会用电量：shydl、清洁能源发电量：qjnyfdl、清洁能源发电量占比：qjnyfdlzb、
     *                      分布式光伏发电量：fbsgffdl、分布式光伏发电量占比：fbsgffdlzb
     * @return BarGraphDTO.class
     */
    BarGraphDTO getQjnyfdlDetail(BarGraphQuery barGraphQuery);

    /**
     *
     * @param commonQuery
     * @param type
     * @return
     */
    LineChartDTO getQjnyfaqsByAreaCode(CommonQuery commonQuery, Integer type);
}
