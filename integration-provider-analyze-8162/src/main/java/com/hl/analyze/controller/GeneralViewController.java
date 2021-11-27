package com.hl.analyze.controller;

import com.hl.analyze.dto.BarGraphDTO;
import com.hl.analyze.dto.LineChartDTO;
import com.hl.analyze.dto.QjnyfdlDataDTO;
import com.hl.analyze.dto.QjnygmDataDTO;
import com.hl.analyze.entity.PageResult;
import com.hl.analyze.query.BarGraphQuery;
import com.hl.analyze.query.CommonQuery;
import com.hl.analyze.service.GeneralViewService;
import com.hl.analyze.utils.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/11/10
 */

@RestController
@RequestMapping("/generalView")
public class GeneralViewController {

    @Resource
    private GeneralViewService generalViewService;


    /**
     * 获取清洁能源规模
     *
     * @param commonQuery 通用查询参数
     * @return 清洁能源规模
     */
    @RequestMapping("/getGeoHeatmapData")
    public PageResult<Map<String, Object>> getGeoHeatmapData(CommonQuery commonQuery) {
        Map<String, Object> resultData = generalViewService.getGeoHeatmapData(commonQuery);
        return ResultUtil.success(resultData);
    }

    /**
     * 获取清洁能源规模
     *
     * @param commonQuery 通用查询参数
     * @return 清洁能源规模
     */
    @RequestMapping("/getQjnygmDataByAreaCode")
    public PageResult<QjnygmDataDTO> getQjnygmDataByAreaCode(CommonQuery commonQuery) {
        QjnygmDataDTO resultData = generalViewService.getQjnygmDataByAreaCode(commonQuery);
        return ResultUtil.success(resultData);
    }

    /**
     * 获取清洁能源发电量
     *
     * @param commonQuery 通用查询参数
     * @return 清洁能源规模
     */
    @RequestMapping("/getQjnyfdlDataByAreaCode")
    public PageResult<QjnyfdlDataDTO> getQjnyfdlDataByAreaCode(CommonQuery commonQuery) {
        QjnyfdlDataDTO qjnyfdlData = generalViewService.getQjnyfdlDataByAreaCode(commonQuery);
        return ResultUtil.success(qjnyfdlData);
    }

    /**
     * 清洁能源规模二级
     *
     * @param barGraphQuery 通用查询参数
     *                      time->年月
     *                      type->qjnygm：(清洁能源规模)装机容量，ldfgl：绿电覆盖率，fbsgf：分布式光伏，jzsgf：集中式光伏，fd：风电
     * @return 清洁能源规模
     */
    @RequestMapping("/getQjnygmDetail")
    public PageResult<BarGraphDTO> getQjnygmDetail(BarGraphQuery barGraphQuery) {
        BarGraphDTO qjnyfdlData = generalViewService.getQjnygmDetail(barGraphQuery);
        return ResultUtil.success(qjnyfdlData);
    }

    /**
     * 获取清洁能源发电量二级
     *
     * @param barGraphQuery 通用查询参数
     *                      time->年月
     *                      type->社会用电量：shydl、清洁能源发电量：qjnyfdl、清洁能源发电量占比：qjnyfdlzb、
     *                      分布式光伏发电量：fbsgffdl、分布式光伏发电量占比：fbsgffdlzb
     * @return 获取清洁能源发电量
     */
    @RequestMapping("/getQjnyfdlDetail")
    public PageResult<BarGraphDTO> getQjnyfdlDetail(BarGraphQuery barGraphQuery) {
        BarGraphDTO qjnyfdlData = generalViewService.getQjnyfdlDetail(barGraphQuery);
        return ResultUtil.success(qjnyfdlData);
    }

    /**
     * 清洁能源发展趋势
     *
     * @param commonQuery
     * @param type
     * @return
     */
    @RequestMapping("/getQjnyfaqsByAreaCode")
    public PageResult<LineChartDTO> getQjnyfaqsByAreaCode(CommonQuery commonQuery, Integer type) {
        LineChartDTO lineChart = generalViewService.getQjnyfaqsByAreaCode(commonQuery, type);
        return ResultUtil.success(lineChart);
    }

}
