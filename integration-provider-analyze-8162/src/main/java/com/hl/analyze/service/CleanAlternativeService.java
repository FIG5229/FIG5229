package com.hl.analyze.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hl.analyze.entity.po.*;
import com.hl.analyze.entity.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @author hwx
 * @date 2021/11/8
 */
public interface CleanAlternativeService {


    /**
     * description: 获取分布式光伏
     * create by: hwx
     * create time: 2021-11-9 10:21:07
     */
    PageInfo<Map<String, Object>> getDistributedPhotovoltaic(String cityCode, String countyCode);

    /**
     * description: 光伏补贴异常明细
     * create by: hwx
     * create time: 2021-11-9 10:21:07
     */
    PageInfo<Map<String, Object>> getPhotovoltaicSubsidies(String cityCode, String countyCode, String managementUnitName, String releaseDate);

    /**
     * description: 光伏违约明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    PageInfo<Map<String, Object>> getPhotovoltaicDefault(String cityCode, String countyCode, String managementUnitName, String date);

    /**
     * description: 光伏超容明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    PageInfo<Map<String, Object>> getPhotovoltaicOverCapacity(String cityCode, String countyCode, String managementUnitName, String date);

    /**
     * description: 新能源容量明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    PageInfo<Map<String, Object>> getInstalledCapacity(String cityCode, String countyCode, String date);

    /**
     * description: 获取区县详细信息(悬浮窗)
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    List<Map<String, Object>> getCountyDetailedInformation(String countyCode);

    /**
     * description: 获取地市下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<Map<String, Object>> getCityMenu();

    /**
     * description: 获取区县下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<Map<String, Object>> getCountyMenu(String cityCode);

    /**
     * description: 获取承载力评估二级用户明细
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    PageInfo<Map<String, Object>> qjtdCzlpgYhDetail(String courtsName);

    /**
     * description: 获取乡镇下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<Map<String, Object>> getVillagesMenu(String countyCode);

    /**
     * description: 获取线路下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<Map<String, Object>> getCircuitMenu(String villagesCode);

    /**
     * description: 获取承载力评估二级台区台账
     * create by: hwx
     * create time: 2021-11-10 15:32:29
     */
    PageInfo<Map<String, Object>> qjtdCzlpgTqtzDetail(String countyCode, String villagesCode, String circuitCode, String time);

    /**
     * description: 获取供电所下拉菜单
     * create by: hwx
     * create time:2021-11-10 16:40:05
     */
    List<Map<String, Object>> getPowerSubstationMenu(String countyCode);

    /**
     * description: 清洁替代顶部弹窗（光伏电站/风电场）
     * create by: hwx
     * create time: 2021/11/8 17:32
     */
    Page<PowerStation> getTopGfGd(String type);

    /**
     * description: 获取清洁替代光伏电站打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    List<Map<String, Object>> getGfdzPointData(String cityCode, String countyCode);

    /**
     * description: 获取清洁替代分布式光伏用户打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    List<Map<String, Object>> getFbsgfyhPointData(String cityCode, String countyCode);

    /**
     * description: 获取清洁替代风电场打点数据
     * create by: hwx
     * create time: 2021/11/11 11:42
     */
    List<Map<String, Object>> getFdcPointData(String cityCode, String countyCode);

    /**
     * description: 获取清洁替代装机容量热力数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    Map<String, Object> getZjrlGeoHeatmapData(String cityCode, String countyCode);

    /**
     * description: 光伏超容 一级页面
     * create by: hwx
     * create time: 2021-11-11 11:58:11
     */
    List<Map<String, Object>> getGfcrData(String cityCode, String countyCode, String selectDate);

    /**
     * description: 发电异常用户 一级页面
     * create by: hwx
     * create time: 2021-11-11 11:58:11
     */
    PageInfo<Map<String, Object>> getFdycyhTableData(String cityCode, String countyCode, String selectMonth);

    /**
     * description: 新能量容量详情-月度趋势二级弹窗
     * create by: hwx
     * create time: 2021-11-11 15:08:44
     */
    Map<String, Object> getYdqsDetail(String type, String startTime, String endTime);

    /**
     * description: 获取区县详细信息(悬浮窗)
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    List<Map<String, Object>> getOverview(String cityCode, String countyCode, String selectMonth);

    /**
     * description: 装机容量占比
     * create by: hwx
     * create time: 2021-11-11 22:21:55
     */
    List<Map<String, Object>> getCapacity(String cityCode, String countyCode, String selectMonth);
}
