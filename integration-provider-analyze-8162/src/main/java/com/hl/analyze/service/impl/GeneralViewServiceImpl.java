package com.hl.analyze.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hl.analyze.dao.GeneralViewDao;
import com.hl.analyze.dto.BarGraphDTO;
import com.hl.analyze.dto.LineChartDTO;
import com.hl.analyze.dto.QjnyfdlDataDTO;
import com.hl.analyze.dto.QjnygmDataDTO;
import com.hl.analyze.entity.bo.ChartDataBO;
import com.hl.analyze.entity.bo.HeatMapBO;
import com.hl.analyze.entity.bo.LabelTypeBO;
import com.hl.analyze.entity.bo.NameBO;
import com.hl.analyze.entity.po.GvCleanEnergyPO;
import com.hl.analyze.entity.po.GvRenewableEnergyPO;
import com.hl.analyze.entity.podo.LabelUnitDO;
import com.hl.analyze.entity.podo.LabelValueDO;
import com.hl.analyze.query.BarGraphQuery;
import com.hl.analyze.query.CommonQuery;
import com.hl.analyze.service.GeneralViewService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jason
 * @date 2021/11/10
 */

@Service
public class GeneralViewServiceImpl implements GeneralViewService {

    @Resource
    private GeneralViewDao generalViewDao;

    @Override
    public Map<String, Object> getGeoHeatmapData(CommonQuery commonQuery) {

        List<HeatMapBO> heatmapData = generalViewDao.getGeoHeatmapData(commonQuery);

        Map<String, Object> map = Maps.newHashMap();
        heatmapData.forEach(item -> {
            Map<String, Object> codeValueMap = Maps.newHashMap();
            map.put(item.getOrgName(), codeValueMap);
            codeValueMap.put("code", item.getOrgNo());
            codeValueMap.put("value", item.getValue());
        });

        return map;
    }

    @Override
    public QjnygmDataDTO getQjnygmDataByAreaCode(CommonQuery commonQuery) {
        GvRenewableEnergyPO scaleData = generalViewDao.getQjnygmData(commonQuery);
        return QjnygmDataDTO.builder()
                // 装机容量
                .zjrl(new LabelUnitDO(scaleData.getNewEnergyCapacity(), "万千瓦"))
                // 绿电覆盖率
                .ldfgl(new LabelUnitDO(scaleData.getProportion(), "%"))
                // 分布式光伏户数
                .fbsgfHs(new LabelUnitDO(BigDecimal.valueOf(52251), ""))
                // 分布式光伏装机容量
                .fbsgfZjrl(new LabelUnitDO(scaleData.getDistributedCapacity(), "万千瓦"))
                // 集中式光伏户数
                .jzsgfHs(new LabelUnitDO(BigDecimal.valueOf(18), ""))
                // 集中式光伏装机容量
                .jzsgfZjrl(new LabelUnitDO(scaleData.getCentralCapacity(), "万千瓦"))
                // 风电户数
                .fdHs(new LabelUnitDO(BigDecimal.valueOf(29), ""))
                // 风电装机容量
                .fdZjrl(new LabelUnitDO(scaleData.getWindPowerCapacity(), "万千瓦"))
                .build();
    }

    @Override
    public QjnyfdlDataDTO getQjnyfdlDataByAreaCode(CommonQuery commonQuery) {
        GvRenewableEnergyPO gvRenewableEnergy = generalViewDao.getQjnygmData(commonQuery);
        return QjnyfdlDataDTO.builder()
                .list(new ArrayList<LabelUnitDO>() {
                    private static final long serialVersionUID = 77420537020920653L;

                    {
                        add(new LabelTypeBO("清洁能源发电量", gvRenewableEnergy.getNewEnergyGeneratingPower(), "亿千瓦时", "qjnyfdl"));
                        add(new LabelTypeBO("分布式光伏发电量", gvRenewableEnergy.getDistributedGeneratingPower(), "亿千瓦时", "fbsgffdl"));
                        add(new LabelTypeBO("清洁能源发电量占比", gvRenewableEnergy.getProportion(), "%", "qjnyfdlzb"));
                        add(new LabelTypeBO("分布式光伏发电量占比", gvRenewableEnergy.getDistributedGeneratingPower()
                                .divide(gvRenewableEnergy.getNewEnergyGeneratingPower(), 3, RoundingMode.HALF_UP)
                                .multiply(BigDecimal.valueOf(100)), "%", "fbsgffdlzb"));
                        add(new LabelTypeBO("社会用电量", gvRenewableEnergy.getSocialElectricityConsumption(), "亿千瓦时", "shydl"));
                    }
                })
                .build();
    }

    @Override
    public BarGraphDTO getQjnygmDetail(BarGraphQuery barGraphQuery) {
        return getBar(barGraphQuery);
    }

    @Override
    public BarGraphDTO getQjnyfdlDetail(BarGraphQuery barGraphQuery) {
        return getBar(barGraphQuery);
    }

    @Override
    public LineChartDTO getQjnyfaqsByAreaCode(CommonQuery commonQuery, Integer type) {

        List<GvCleanEnergyPO> gvCleanEnergyList = generalViewDao.getQjnyfaqsByAreaCode(commonQuery, type);

        LineChartDTO.LineChartDTOBuilder builder = LineChartDTO.builder()
                .tabData(new NameBO(type == 1 ? "装机容量" : "发电量"));

        List<LabelValueDO> thermalChartDataList = Lists.newArrayList();
        List<LabelValueDO> biomassChartDataList = Lists.newArrayList();
        List<LabelValueDO> photovoltaicChartDataList = Lists.newArrayList();
        List<LabelValueDO> windChartDataList = Lists.newArrayList();

        // 构建折线图
        LinkedList<ChartDataBO> chartDataList = new LinkedList<>();

        if (type == 1) {
            gvCleanEnergyList.forEach(gvCleanEnergy -> {
                String year = gvCleanEnergy.getYear();
                thermalChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getThermalPowerCapacityRatio()));
                biomassChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getBiomassCapacityRatio()));
                photovoltaicChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getPhotovoltaicCapacityRatio()));
                windChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getWindPowerCapacityRatio()));
            });
        } else {
            List<LabelValueDO> outsideChartDataList = Lists.newArrayList();
            gvCleanEnergyList.forEach(gvCleanEnergy -> {
                String year = gvCleanEnergy.getYear();
                thermalChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getThermalRadio()));
                biomassChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getBiomassRadio()));
                outsideChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getOutsideRadio()));
                photovoltaicChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getPhotovoltaicRatio()));
                windChartDataList.add(new LabelValueDO(year, gvCleanEnergy.getWindPowerRatio()));
            });
            chartDataList.add(new ChartDataBO("区外供电", true, outsideChartDataList));
        }

        // 将区外发电放在第2位
        chartDataList.addFirst(new ChartDataBO("火电", true, thermalChartDataList));
        chartDataList.addLast(new ChartDataBO("生物质", true, biomassChartDataList));
        chartDataList.addLast(new ChartDataBO("光伏", true, photovoltaicChartDataList));
        chartDataList.addLast(new ChartDataBO("风电", true, windChartDataList));

        return builder
                .chartData(chartDataList)
                .build();
    }

    /**
     * 获取清洁能源规模/发电量数据库数据
     *
     * @param barGraphQuery 查询条件
     * @return BarGraphDTO.class
     */
    private BarGraphDTO getBar(BarGraphQuery barGraphQuery) {
        if (StringUtils.isBlank(barGraphQuery.getType())) {
            return BarGraphDTO.builder().data(Lists.newArrayList()).build();
        }
        Stream<GvRenewableEnergyPO> qjnygmDetailStream = generalViewDao.getQjnygmDetail(barGraphQuery).stream();
        return buildBarGraph(barGraphQuery.getType(), qjnygmDetailStream);
    }

    /**
     * 获取
     *
     * @param type               类型
     * @param qjnygmDetailStream 数据库数据流
     * @return BarGraphDTO.class
     */
    private BarGraphDTO buildBarGraph(String type, Stream<GvRenewableEnergyPO> qjnygmDetailStream) {

        Stream<LabelValueDO> labelValueStream;

        BarGraphDTO.BarGraphDTOBuilder builder = BarGraphDTO.builder()
                .name("")
                .unit("");

        switch (type) {
            // 清洁能源规模-装机容量
            case "qjnygm": {
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(), item.getNewEnergyCapacity()));
                break;
            }
            // 清洁能源规模-分散式光伏
            case "fbsgf": {
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(), item.getDistributedCapacity()));
                break;
            }
            // 清洁能源规模-集中式光伏
            case "jzsgf": {
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(), item.getCentralCapacity()));
                break;
            }
            // 清洁能源规模-集中式光伏
            case "fd": {
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(), item.getWindPowerCapacity()));
                break;
            }
            // 清洁能源规模-绿电覆盖率
            case "ldfgl":
                // 清洁能源发电量-清洁能源发电量占比
            case "qjnyfdlzb": {
                // 两个使用同一条柱图
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(), item.getProportion()));
                break;
            }
            // 清洁能源发电量-清洁能源发电量
            case "qjnyfdl": {
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(), item.getNewEnergyGeneratingPower()));
                break;
            }
            // 清洁能源发电量-分布式光伏发电量
            case "fbsgffdl": {
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(), item.getDistributedGeneratingPower()));
                break;
            }
            // 清洁能源发电量-分布式光伏发电量占比
            case "fbsgffdlzb": {
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(),
                                item.getDistributedGeneratingPower()
                                        .divide(item.getNewEnergyGeneratingPower(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100))));
                break;
            }
            // 清洁能源发电量-社会用电量
            case "shydl": {
                labelValueStream = qjnygmDetailStream
                        .map(item -> new LabelValueDO(item.getDistrictName(), item.getSocialElectricityConsumption()));
                break;
            }
            default:
                return builder.data(Lists.newArrayList()).build();

        }

        builder.data(labelValueStream.sorted(Comparator.comparing(LabelValueDO::getValue).reversed())
                .collect(Collectors.toList()));

        return builder.build();
    }

}
