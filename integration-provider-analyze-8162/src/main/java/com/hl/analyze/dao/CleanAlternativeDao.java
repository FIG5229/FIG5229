package com.hl.analyze.dao;

import com.github.pagehelper.Page;
import com.hl.analyze.entity.po.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hwx
 * @date 2021/11/8
 */
public interface CleanAlternativeDao {
    /**
     * description: 获取全部光伏电站
     * create by: hwx
     * create time: 2021/11/8 17:32
     */
    Page<PowerStation> getPhotovoltaicPowerStation();

    /**
     * description: 获取全部风电站
     * create by: hwx
     * create time: 2021/11/8 17:32
     */
    Page<PowerStation> getWindPowerPlant();

    /**
     * description: 获取分布式光伏
     * create by: hwx
     * create time: 2021-11-9 10:21:07
     */
    Page<DistributedPhotovoltaic> getDistributedPhotovoltaic(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode);

    /**
     * description: 光伏补贴异常明细
     * create by: hwx
     * create time: 2021-11-9 10:21:07
     */
    Page<PhotovoltaicSubsidies> getPhotovoltaicSubsidies(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("managementUnitName") String managementUnitName, @Param("releaseDate") String releaseDate);

    /**
     * description: 光伏违约明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    Page<PhotovoltaicDefault> getPhotovoltaicDefault(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("managementUnitName") String managementUnitName, @Param("date") String date);

    /**
     * description: 光伏超容明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    Page<PhotovoltaicOverCapacity> getPhotovoltaicOverCapacity(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("managementUnitName") String managementUnitName, @Param("date") String date);

    /**
     * description: 新能源容量明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    Page<InstalledCapacity> getInstalledCapacity(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("date") String date);

    /**
     * description: 获取总容量
     * create by: hwx
     * create time: 2021/11/9 15:58
     */
    String getTotalCapacity();

    /**
     * description: 获取该区县装机容量
     * create by: hwx
     * create time: 2021/11/9 16:25
     */
    Double getInstalledCapacityByCounty(@Param("countyCode") String countyCode, @Param("date") String date);

    /**
     * description: 统计该区县光伏电站的总数
     * create by: hwx
     * create time: 2021/11/9 16:27
     */
    Integer getPhotovoltaicPowerStationByCounty(String countyCode);

    /**
     * description: 统计该区县风电场总数
     * create by: hwx
     * create time: 2021/11/9 16:28
     */
    Integer getWindPowerPlantByCounty(String countyCode);

    /**
     * description: 统计该区县分布式用户总数
     * create by: hwx
     * create time: 2021/11/9 16:29
     */
    Integer getDistributedPhotovoltaicByCounty(String countyCode);

    /**
     * description: 获取地市下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<GetMenu> getCityMenu();

    /**
     * description: 获取区县下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<GetMenu> getCountyMenu(String cityCode);

    /**
     * description: 获取承载力评估二级用户明细
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<AssessUserDetails> qjtdCzlpgYhDetail(String courtsName);

    /**
     * description: 获取乡镇下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<GetMenu> getVillagesMenu(String countyCode);

    /**
     * description: 获取线路下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    List<GetMenu> getCircuitMenu(String villagesCode);

    /**
     * description: 获取承载力评估二级台区台账
     * create by: hwx
     * create time: 2021-11-10 15:32:29
     */
    Page<StandingBook> qjtdCzlpgTqtzDetail(@Param("countyCode") String countyCode, @Param("villagesCode") String villagesCode, @Param("circuitCode") String circuitCode, @Param("time") String time);

    /**
     * description: 获取供电所下拉菜单
     * create by: hwx
     * create time:2021-11-10 16:40:05
     */
    List<GetMenu> getPowerSubstationMenu(String countyCode);

    /**
     * description: 获取清洁替代分布式光伏用户打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    List<DistributedPhotovoltaic> getFbsgfyhPointData(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode);

    /**
     * description: 获取清洁替代光伏电站打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    List<DistributedPhotovoltaic> getGfdzPointData(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode);

    /**
     * description: 获取清洁替代风电场打点数据
     * create by: hwx
     * create time: 2021/11/11 11:42
     */
    List<DistributedPhotovoltaic> getFdcPointData(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode);

    /**
     * description: 获取清洁替代装机容量热力数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    List<InstalledCapacity> getZjrlGeoHeatmapData(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("date") String date);

    /**
     * description: 光伏超容 一级页面
     * create by: hwx
     * create time: 2021-11-11 11:58:11
     */
    List<PhotovoltaicOverCapacity> getGfcrData(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("selectDate") String selectDate);

    /**
     * description: 新能量容量详情-月度趋势二级弹窗
     * create by: hwx
     * create time: 2021-11-11 15:08:44
     */
    List<InstalledCapacity> getYdqsDetail(@Param("startTime") String startTime, @Param("endTime") String endTime);

    /**
     * description: 发电异常用户 一级页面
     * create by: hwx
     * create time: 2021-11-11 11:58:11
     */
    List<PhotovoltaicSubsidies> getFdycyhTableData(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("selectMonth") String selectMonth);

    /**
     * description: 获取该区县名
     * create by: hwx
     * create time: 2021/11/11 17:54
     */
    String getCounty(String countyCode);

    /**
     * description: 获取装机容量
     * create by: hwx
     * create time: 2021/11/11 21:32
     */
    InstalledCapacity getPhotovoltaic(String selectMonth);

    /**
     * description: 获取光伏电站总数
     * create by: hwx
     * create time: 2021/11/11 22:11
     */
    Integer getPhotovoltaicPowerStationTotal(String countyCode);

    /**
     * description: 获取风电站总数
     * create by: hwx
     * create time: 2021/11/11 22:11
     */
    Integer getWindPowerPlantTotal(String countyCode);

    /**
     * description: 获取分布式光伏总数
     * create by: hwx
     * create time: 2021/11/11 22:11
     */
    Integer getFbsgfyhPointDataTotal(String countyCode);

    /**
     * description: 装机容量占比
     * create by: hwx
     * create time: 2021-11-11 22:21:55
     */
    InstalledCapacity getCapacity(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("selectMonth") String selectMonth);

    /**
     * description: 装机容量占比
     * create by: hwx
     * create time: 2021-11-11 22:21:55
     */
    InstalledCapacity getCapacityCountyCode(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("selectMonth") String selectMonth);

    /**
     * description: 获取装机容量
     * create by: hwx
     * create time: 2021-11-11 22:21:55
     */
    InstalledCapacity getPhotovoltaicCountyCode(@Param("cityCode") String cityCode, @Param("countyCode") String countyCode, @Param("selectMonth") String selectMonth);
}
