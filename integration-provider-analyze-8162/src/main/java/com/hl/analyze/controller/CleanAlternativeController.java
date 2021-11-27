package com.hl.analyze.controller;

import com.hl.analyze.entity.PageResult;
import com.hl.analyze.entity.po.*;
import com.hl.analyze.service.CleanAlternativeService;
import com.hl.analyze.utils.ResultUtil;
import com.integration.utils.MyPagUtile;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * description:清洁替代
 * create by: hwx
 * create time: 2021/11/8 17:23
 */
@RestController
public class CleanAlternativeController {
    @Resource
    private CleanAlternativeService cleanAlternativeService;

    /**
     * description: 清洁替代顶部弹窗（光伏电站/风电场）
     * create by: hwx
     * create time: 2021/11/8 17:32
     */
    @RequestMapping("/getTopGfGd")
    public PageResult getTopGfGd(String type) {

        Page<PowerStation> pages = cleanAlternativeService.getTopGfGd(type);
        return ResultUtil.success(pages);

    }

    /**
     * description: 获取分布式光伏
     * create by: hwx
     * create time: 2021-11-9 10:21:07
     */
    @RequestMapping("/getTopFbsgf")
    public PageResult<Map<String, Object>> getDistributedPhotovoltaic(String cityCode, String countyCode) {
        PageInfo<Map<String, Object>> pages = cleanAlternativeService.getDistributedPhotovoltaic(cityCode, countyCode);

        return ResultUtil.success(pages);
    }

    /**
     * description: 光伏补贴异常明细
     * create by: hwx
     * create time: 2021-11-9 10:21:07
     */
    @RequestMapping("/getFdycyhDetail")
    public PageResult<Map<String, Object>> getPhotovoltaicSubsidies(String cityCode, String countyCode, String gds, String time) {
        PageInfo<Map<String, Object>> pages = cleanAlternativeService.getPhotovoltaicSubsidies(cityCode, countyCode, gds, time);
        return ResultUtil.success(pages);
    }

    /**
     * description: 光伏违约明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @RequestMapping("/getGfwgDetail")
    public PageResult<Map<String, Object>> getPhotovoltaicDefault(String cityCode, String countyCode, String gds, String time) {
        PageInfo<Map<String, Object>> pages = cleanAlternativeService.getPhotovoltaicDefault(cityCode, countyCode, gds, time);
        return ResultUtil.success(pages);
    }

    /**
     * description: 光伏超容明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @RequestMapping("/getGfcrDetail")
    public PageResult<Map<String, Object>> getPhotovoltaicOverCapacity(String cityCode, String countyCode, String gds, String time) {
        PageInfo<Map<String, Object>> pages = cleanAlternativeService.getPhotovoltaicOverCapacity(cityCode, countyCode, gds, time);
        return ResultUtil.success(pages);
    }

    /**
     * description: 新能源容量明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @RequestMapping("/getQjtdXnyrlDetail")
    public PageResult<Map<String, Object>> getInstalledCapacity(String cityCode, String countyCode, String time) {
        PageInfo<Map<String, Object>> pages = cleanAlternativeService.getInstalledCapacity(cityCode, countyCode, time);
        return ResultUtil.success(pages);
    }


    /**
     * description: 获取区县详细信息(悬浮窗)
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @RequestMapping("/getQjtdCardDetailData")
    public PageResult getCountyDetailedInformation(String countyCode) {
        List<Map<String, Object>> list = cleanAlternativeService.getCountyDetailedInformation(countyCode);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取区县详细信息(悬浮窗)
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @RequestMapping("/getOverview")
    public PageResult getOverview(String cityCode, String countyCode, String selectMonth) {
        List<Map<String, Object>> list = cleanAlternativeService.getOverview(cityCode, countyCode, selectMonth);
        return ResultUtil.success(list);
    }

    /**
     * description: 装机容量占比
     * create by: hwx
     * create time: 2021-11-11 22:21:55
     */
    @RequestMapping("/getCapacity")
    public PageResult getCapacity(String cityCode, String countyCode, String selectMonth) {
        List<Map<String, Object>> list = cleanAlternativeService.getCapacity(cityCode, countyCode, selectMonth);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取地市下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    @RequestMapping("/getCityMenu")
    public PageResult getCityMenu() {
        List<Map<String, Object>> list = cleanAlternativeService.getCityMenu();
        return ResultUtil.success(list);
    }

    /**
     * description: 获取区县下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    @RequestMapping("/getCountyMenu")
    public PageResult getCountyMenu(String cityCode) {
        List<Map<String, Object>> list = cleanAlternativeService.getCountyMenu(cityCode);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取乡镇下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    @RequestMapping("/getVillagesMenu")
    public PageResult getVillagesMenu(String countyCode) {
        List<Map<String, Object>> list = cleanAlternativeService.getVillagesMenu(countyCode);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取线路下拉菜单
     * create by: hwx
     * create time:2021-11-10 15:32:33
     */
    @RequestMapping("/getCircuitMenu")
    public PageResult getCircuitMenu(String villagesCode) {
        List<Map<String, Object>> list = cleanAlternativeService.getCircuitMenu(villagesCode);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取供电所下拉菜单
     * create by: hwx
     * create time:2021-11-10 16:40:05
     */
    @RequestMapping("/getPowerSubstationMenu")
    public PageResult getPowerSubstationMenu(String countyCode) {
        List<Map<String, Object>> list = cleanAlternativeService.getPowerSubstationMenu(countyCode);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取承载力评估二级台区台账
     * create by: hwx
     * create time: 2021-11-10 15:32:29
     *
     * @return
     */
    @RequestMapping("/qjtdCzlpgTqtzDetail")
    public PageResult<Map<String, Object>> qjtdCzlpgTqtzDetail(String countyCode, String villagesCode, String circuitCode, String time) {
        PageInfo<Map<String, Object>> list = cleanAlternativeService.qjtdCzlpgTqtzDetail(countyCode, villagesCode, circuitCode, time);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取承载力评估二级用户明细
     * create by: hwx
     * create time: 2021-11-10 15:32:33
     */
    @RequestMapping("/qjtdCzlpgYhDetail")
    public PageResult<Map<String, Object>> qjtdCzlpgYhDetail(String courtsName) {
        PageInfo<Map<String, Object>> list = cleanAlternativeService.qjtdCzlpgYhDetail(courtsName);
        return ResultUtil.success(list);
    }


    /**
     * description: 获取清洁替代光伏电站打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    @RequestMapping("/getGfdzPointData")
    public PageResult<Map<String, Object>> getGfdzPointData(String cityCode, String countyCode) {
        List<Map<String, Object>> list = cleanAlternativeService.getGfdzPointData(cityCode, countyCode);
        return ResultUtil.success(list);
    }


    /**
     * description: 获取清洁替代风电场打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    @RequestMapping("/getFdcPointData")
    public PageResult<Map<String, Object>> getFdcPointData(String cityCode, String countyCode) {
        List<Map<String, Object>> list = cleanAlternativeService.getFdcPointData(cityCode, countyCode);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取清洁替代分布式光伏用户打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    @RequestMapping("/getFbsgfyhPointData")
    public PageResult<Map<String, Object>> getFbsgfyhPointData(String cityCode, String countyCode) {
        List<Map<String, Object>> list = cleanAlternativeService.getFbsgfyhPointData(cityCode, countyCode);
        return ResultUtil.success(list);
    }

    /**
     * description: 获取清洁替代装机容量热力数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    @RequestMapping("/getZjrlGeoHeatmapData")
    public PageResult<Map<String, Object>> getZjrlGeoHeatmapData(String cityCode, String countyCode) {
        Map<String, Object> map = cleanAlternativeService.getZjrlGeoHeatmapData(cityCode, countyCode);
        return ResultUtil.success(map);
    }

    /**
     * description: 光伏超容 一级页面
     * create by: hwx
     * create time: 2021-11-11 11:58:11
     */
    @RequestMapping("/getGfcrData")
    public PageResult<Map<String, Object>> getGfcrData(String cityCode, String countyCode, String selectDate) {
        List<Map<String, Object>> list = cleanAlternativeService.getGfcrData(cityCode, countyCode, selectDate);
        return ResultUtil.success(list);
    }

    /**
     * description: 发电异常用户 一级页面
     * create by: hwx
     * create time: 2021-11-11 15:08:47
     */
    @RequestMapping("/getFdycyhTableData")
    public PageResult<Map<String, Object>> getFdycyhTableData(String cityCode, String countyCode, String selectMonth) {
        PageInfo<Map<String, Object>> list = cleanAlternativeService.getFdycyhTableData(cityCode, countyCode, selectMonth);
        return ResultUtil.success(list);
    }

    /**
     * description: 新能量容量详情-月度趋势二级弹窗
     * create by: hwx
     * create time: 2021-11-11 15:08:44
     */
    @RequestMapping("/getYdqsDetail")
    public PageResult<Map<String, Object>> getYdqsDetail(String type, String startTime, String endTime) {
        Map<String, Object> map = cleanAlternativeService.getYdqsDetail(type, startTime, endTime);
        return ResultUtil.success(map);
    }

}
