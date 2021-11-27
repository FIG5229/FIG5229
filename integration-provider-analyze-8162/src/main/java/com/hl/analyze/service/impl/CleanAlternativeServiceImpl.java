package com.hl.analyze.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hl.analyze.config.FieldConversion;
import com.hl.analyze.dao.CleanAlternativeDao;
import com.hl.analyze.entity.po.*;
import com.hl.analyze.service.CleanAlternativeService;
import com.integration.entity.PageResult;
import com.integration.utils.DataConversionUtils;
import com.integration.utils.MyPagUtile;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hwx
 * @date 2021/11/8
 */
@Service
public class CleanAlternativeServiceImpl implements CleanAlternativeService {

    @Resource
    private CleanAlternativeDao cleanAlternativeDao;

    @Override
    public Page<PowerStation> getTopGfGd(String type) {
        MyPagUtile.startPage();
        if ("gfdz".equals(type)) {
            return cleanAlternativeDao.getPhotovoltaicPowerStation();
        }
        if ("fdc".equals(type)) {
            return cleanAlternativeDao.getWindPowerPlant();
        }
        return null;
    }


    /**
     * description: 获取分布式光伏
     * create by: hwx
     * create time: 2021-11-9 10:21:07
     */
    @Override
    public PageInfo<Map<String, Object>> getDistributedPhotovoltaic(String cityCode, String countyCode) {
        MyPagUtile.startPage();
        List<DistributedPhotovoltaic> list = cleanAlternativeDao.getDistributedPhotovoltaic(cityCode, countyCode);
        PageInfo pageInfo = new PageInfo<>(list);
        List<Map<String, Object>> maps = DataConversionUtils.detailsConversion(list, FieldConversion.DISTRIBUTEDPHOTOVOLTAIC);
        pageInfo.setList(maps);
        return pageInfo;
    }

    /**
     * description: 光伏补贴异常明细
     * create by: hwx
     * create time: 2021-11-9 10:21:07
     */
    @Override
    public PageInfo<Map<String, Object>> getPhotovoltaicSubsidies(String cityCode, String countyCode, String managementUnitName, String releaseDate) {
        MyPagUtile.startPage();
        List<PhotovoltaicSubsidies> list = cleanAlternativeDao.getPhotovoltaicSubsidies(cityCode, countyCode, managementUnitName, releaseDate);
        for (PhotovoltaicSubsidies photovoltaicSubsidies : list) {
            String releaseDate1 = photovoltaicSubsidies.getReleaseDate();
            photovoltaicSubsidies.setReleaseDate(releaseDate1.substring(0, 7));

        }
        PageInfo pageInfo = new PageInfo<>(list);
        List<Map<String, Object>> maps = DataConversionUtils.detailsConversion(list, FieldConversion.SUBSIDIES);
        pageInfo.setList(maps);
        return pageInfo;
    }

    /**
     * description: 光伏违约明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @Override
    public PageInfo<Map<String, Object>> getPhotovoltaicDefault(String cityCode, String countyCode, String managementUnitName, String date) {
        MyPagUtile.startPage();
        List<PhotovoltaicDefault> list = cleanAlternativeDao.getPhotovoltaicDefault(cityCode, countyCode, managementUnitName, date);
        PageInfo pageInfo = new PageInfo<>(list);
        List<Map<String, Object>> maps = DataConversionUtils.detailsConversion(list, FieldConversion.DEFULT);
        pageInfo.setList(maps);
        return pageInfo;
    }

    /**
     * description: 光伏超容明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @Override
    public PageInfo<Map<String, Object>> getPhotovoltaicOverCapacity(String cityCode, String countyCode, String managementUnitName, String date) {
        MyPagUtile.startPage();
        List<PhotovoltaicOverCapacity> list = cleanAlternativeDao.getPhotovoltaicOverCapacity(cityCode, countyCode, managementUnitName, date);
        PageInfo pageInfo = new PageInfo<>(list);
        List<Map<String, Object>> maps = DataConversionUtils.detailsConversion(list, FieldConversion.OVER_CAPACITY);
        pageInfo.setList(maps);
        return pageInfo;
    }

    /**
     * description: 新能源容量明细
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @Override
    public PageInfo<Map<String, Object>> getInstalledCapacity(String cityCode, String countyCode, String date) {
        String totalCapacity = cleanAlternativeDao.getTotalCapacity();
        MyPagUtile.startPage();
        List<InstalledCapacity> pages = cleanAlternativeDao.getInstalledCapacity(cityCode, countyCode, date);
//        Map<String, Object> map = new HashMap<>();
//        map.put("total", pages.getTotal());
//        map.put("totalCapacity", totalCapacity);
//        map.put("list", pages.getResult());
        PageInfo pageInfo = new PageInfo<>(pages);
        List<Map<String, Object>> maps = DataConversionUtils.detailsConversion(pages, FieldConversion.CAPACITY);
        pageInfo.setList(maps);
        return pageInfo;

    }

    /**
     * description: 获取区县详细信息(悬浮窗)
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @Override
    public List<Map<String, Object>> getCountyDetailedInformation(String countyCode) {
        //获取该区县名
//        String county = cleanAlternativeDao.getCounty(countyCode);
        //获取该区县装机容量
        String date = "2021-08";
        Double capacity = cleanAlternativeDao.getInstalledCapacityByCounty(countyCode, date);
        //统计该区县光伏电站的总数
        Integer photovoltaicPowerStationTotal = cleanAlternativeDao.getPhotovoltaicPowerStationByCounty(countyCode);
        //统计该区县风电场总数
        Integer windPowerPlantTotal = cleanAlternativeDao.getWindPowerPlantByCounty(countyCode);
        //统计该区县分布式用户总数
        Integer distributedPhotovoltaicTotal = cleanAlternativeDao.getDistributedPhotovoltaicByCounty(countyCode);
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> photovoltaicPowerStationTotalMap = new HashMap<>();
        photovoltaicPowerStationTotalMap.put("name", "光伏电站");
        photovoltaicPowerStationTotalMap.put("value", photovoltaicPowerStationTotal);
        photovoltaicPowerStationTotalMap.put("unit", "座");
        list.add(photovoltaicPowerStationTotalMap);

        Map<String, Object> capacityMap = new HashMap<>();
        capacityMap.put("name", "新能源总装机容量");
        capacityMap.put("value", capacity);
        capacityMap.put("unit", "万千瓦");
        list.add(capacityMap);

        Map<String, Object> windPowerPlantTotalMap = new HashMap<>();
        windPowerPlantTotalMap.put("name", "风电场");
        windPowerPlantTotalMap.put("value", windPowerPlantTotal);
        windPowerPlantTotalMap.put("unit", "座");
        list.add(windPowerPlantTotalMap);

        Map<String, Object> distributedPhotovoltaicTotalMap = new HashMap<>();
        distributedPhotovoltaicTotalMap.put("name", "分布式用户");
        distributedPhotovoltaicTotalMap.put("value", distributedPhotovoltaicTotal);
        distributedPhotovoltaicTotalMap.put("unit", "户");
        list.add(distributedPhotovoltaicTotalMap);
        return list;
    }

    /**
     * description: 获取地市下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    @Override
    public List<Map<String, Object>> getCityMenu() {
        List<GetMenu> menuList = cleanAlternativeDao.getCityMenu();

        List<Map<String, Object>> list = new ArrayList<>();
        for (GetMenu getMenu : menuList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", getMenu.getId());
            map.put("city", getMenu.getMenuName());
            map.put("cityCode", getMenu.getCode());
            list.add(map);
        }
        return list;
    }

    /**
     * description: 获取区县下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    @Override
    public List<Map<String, Object>> getCountyMenu(String cityCode) {
        List<GetMenu> menuList = cleanAlternativeDao.getCountyMenu(cityCode);
        List<Map<String, Object>> list = new ArrayList<>();
        for (GetMenu getMenu : menuList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", getMenu.getId());
            map.put("county", getMenu.getMenuName());
            map.put("countyCode", getMenu.getCode());
            list.add(map);
        }
        return list;
    }


    /**
     * description: 获取乡镇下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    @Override
    public List<Map<String, Object>> getVillagesMenu(String countyCode) {
        List<GetMenu> menuList = cleanAlternativeDao.getVillagesMenu(countyCode);
        List<Map<String, Object>> list = new ArrayList<>();
        for (GetMenu getMenu : menuList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", getMenu.getId());
            map.put("villages", getMenu.getMenuName());
            map.put("villagesCode", getMenu.getCode());
            list.add(map);
        }
        return list;
    }

    /**
     * description: 获取供电所下拉菜单
     * create by: hwx
     * create time:2021-11-10 16:40:05
     */
    @Override
    public List<Map<String, Object>> getPowerSubstationMenu(String countyCode) {

        List<GetMenu> menuList = cleanAlternativeDao.getPowerSubstationMenu(countyCode);
        List<Map<String, Object>> list = new ArrayList<>();
        for (GetMenu getMenu : menuList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", getMenu.getId());
            map.put("powerSubstation", getMenu.getMenuName());
            map.put("powerSubstationCode", getMenu.getCode());
            list.add(map);
        }
        return list;
    }

    /**
     * description: 获取线路下拉菜单
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    @Override
    public List<Map<String, Object>> getCircuitMenu(String villagesCode) {
        List<GetMenu> menuList = cleanAlternativeDao.getCircuitMenu(villagesCode);
        List<Map<String, Object>> list = new ArrayList<>();
        for (GetMenu getMenu : menuList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", getMenu.getId());
            map.put("circuit", getMenu.getMenuName());
            map.put("circuitCode", getMenu.getCode());
            list.add(map);
        }
        return list;
    }

    /**
     * description: 获取承载力评估二级台区台账
     * create by: hwx
     * create time: 2021-11-10 15:32:29
     */
    @Override
    public PageInfo<Map<String, Object>> qjtdCzlpgTqtzDetail(String countyCode, String villagesCode, String circuitCode, String time) {
        MyPagUtile.startPage();
        List<StandingBook> list = cleanAlternativeDao.qjtdCzlpgTqtzDetail(countyCode, villagesCode, circuitCode, time);
        PageInfo pageInfo = new PageInfo<>(list);
        List<Map<String, Object>> maps = DataConversionUtils.detailsConversion(list, FieldConversion.STANDING_BOOK);
        pageInfo.setList(maps);
        return pageInfo;
    }

    /**
     * description: 获取承载力评估二级用户明细
     * create by: hwx
     * create time: 2021/11/10 11:18
     */
    @Override
    public PageInfo<Map<String, Object>> qjtdCzlpgYhDetail(String courtsName) {
        MyPagUtile.startPage();
        List<AssessUserDetails> list = cleanAlternativeDao.qjtdCzlpgYhDetail(courtsName);
        PageInfo pageInfo = new PageInfo<>(list);
        List<Map<String, Object>> maps = DataConversionUtils.detailsConversion(list, FieldConversion.ASSESS_USER_DETAILS);
        pageInfo.setList(maps);
        return pageInfo;
    }

    /**
     * description: 获取清洁替代光伏电站打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    @Override
    public List<Map<String, Object>> getGfdzPointData(String cityCode, String countyCode) {
        List<DistributedPhotovoltaic> list = cleanAlternativeDao.getGfdzPointData(cityCode, countyCode);
        List<Map<String, Object>> listResult = new ArrayList<>();
        for (DistributedPhotovoltaic distributedPhotovoltaic : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("companyCode", distributedPhotovoltaic.getId());
            Double latitude = Double.parseDouble(distributedPhotovoltaic.getLatitude());//纬度
            Double longitude = Double.parseDouble(distributedPhotovoltaic.getLongitude());//经度
            Double[] dou = new Double[]{longitude, latitude};
            map.put("coordinate", dou);
            listResult.add(map);
        }
        return listResult;
    }

    /**
     * description: 获取清洁替代风电场打点数据
     * create by: hwx
     * create time: 2021/11/11 11:42
     */
    @Override
    public List<Map<String, Object>> getFdcPointData(String cityCode, String countyCode) {
        List<DistributedPhotovoltaic> list = cleanAlternativeDao.getFdcPointData(cityCode, countyCode);
        List<Map<String, Object>> listResult = new ArrayList<>();
        for (DistributedPhotovoltaic distributedPhotovoltaic : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("companyCode", distributedPhotovoltaic.getId());
            Double latitude = Double.parseDouble(distributedPhotovoltaic.getLatitude());//纬度
            Double longitude = Double.parseDouble(distributedPhotovoltaic.getLongitude());//经度
            Double[] dou = new Double[]{longitude, latitude};
            map.put("coordinate", dou);
            listResult.add(map);
        }
        return listResult;
    }

    /**
     * description: 获取清洁替代分布式光伏用户打点数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    @Override
    public List<Map<String, Object>> getFbsgfyhPointData(String cityCode, String countyCode) {
        List<DistributedPhotovoltaic> list = cleanAlternativeDao.getFbsgfyhPointData(cityCode, countyCode);
        List<Map<String, Object>> listResult = new ArrayList<>();
        for (DistributedPhotovoltaic distributedPhotovoltaic : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("companyCode", distributedPhotovoltaic.getDoorNo());
            try {
                Double latitude = Double.parseDouble(distributedPhotovoltaic.getLatitude());//纬度
                Double longitude = Double.parseDouble(distributedPhotovoltaic.getLongitude());//经度
                Double[] dou = new Double[]{longitude, latitude};
                map.put("coordinate", dou);
                listResult.add(map);
            } catch (Exception e) {

            }

        }
        return listResult;
    }

    /**
     * description: 获取清洁替代装机容量热力数据
     * create by: hwx
     * create time: 2021/11/11 10:27
     */
    @Override
    public Map<String, Object> getZjrlGeoHeatmapData(String cityCode, String countyCode) {
        String date = "2021-08";
        List<InstalledCapacity> list = cleanAlternativeDao.getZjrlGeoHeatmapData(cityCode, countyCode, date);
        Map<String, Object> map = new HashMap<>();
        for (InstalledCapacity installedCapacity : list) {
            Map<String, Object> mapDb = new HashMap<>();
            mapDb.put("code", installedCapacity.getCountyCode());
            double subtotal = Double.parseDouble(installedCapacity.getSubtotal());
            double windPower = Double.parseDouble(installedCapacity.getWindPower());
            mapDb.put("value", subtotal + windPower);
            map.put(installedCapacity.getCounty(), mapDb);
        }
        return map;
    }

    /**
     * description: 光伏超容 一级页面
     * create by: hwx
     * create time: 2021-11-11 11:58:11
     */
    @Override
    public List<Map<String, Object>> getGfcrData(String cityCode, String countyCode, String selectDate) {
        if ("".equals(selectDate) || selectDate == null) {
            selectDate = "2021-10";
        }
        List<PhotovoltaicOverCapacity> list = cleanAlternativeDao.getGfcrData(cityCode, countyCode, selectDate);
        List<Map<String, Object>> listResult = new ArrayList<>();
        for (PhotovoltaicOverCapacity photovoltaicOverCapacity : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("label", photovoltaicOverCapacity.getContractCapacity());
            map.put("value", photovoltaicOverCapacity.getCapacityLoadRatio());
            map.put("size", photovoltaicOverCapacity.getSize());
            listResult.add(map);
        }
        return listResult;
    }

    /**
     * description: 发电异常用户 一级页面
     * create by: hwx
     * create time: 2021-11-11 11:58:11
     */
    @Override
    public PageInfo<Map<String, Object>> getFdycyhTableData(String cityCode, String countyCode, String selectMonth) {

        if ("".equals(selectMonth) || selectMonth == null) {
            selectMonth = "2021-10";
        }
        MyPagUtile.startPage();
        List<PhotovoltaicSubsidies> list = cleanAlternativeDao.getFdycyhTableData(cityCode, countyCode, selectMonth);
        List<Map<String, Object>> listResult = new ArrayList<>();
        for (PhotovoltaicSubsidies photovoltaicSubsidies : list) {
            Map<String, Object> map = new HashMap<>();
            map.put("yhbh", photovoltaicSubsidies.getDoorNo());
            map.put("zdfdl", photovoltaicSubsidies.getAccumulatedGeneratingCapacity());
            map.put("sjfdl", photovoltaicSubsidies.getGeneratingCapacity());
            map.put("ssqx", photovoltaicSubsidies.getCounty());
            listResult.add(map);
        }
        PageInfo pageInfo = new PageInfo<>(list);
        pageInfo.setList(listResult);
        return pageInfo;
    }

    /**
     * description: 新能量容量详情-月度趋势二级弹窗
     * create by: hwx
     * create time: 2021-11-11 15:08:44
     */
    @Override
    public Map<String, Object> getYdqsDetail(String type, String startTime, String endTime) {
        if ("".equals(startTime) || startTime == null) {
            startTime = "2021-01-01";
        }
        if ("".equals(endTime) || endTime == null) {
            endTime = "2021-12-31";
        }
        List<InstalledCapacity> list = cleanAlternativeDao.getYdqsDetail(startTime, endTime);
        Map<String, Object> map = new HashMap<>();
        if ("qjnygm".equals(type)) {
            String[] s = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                s[i] = list.get(i).getNewEnergy();
            }
            map.put("chartdata", new String[]{"4月", "5月", "6月", "7月", "8月" });
            map.put("seriesdata", s);
            return map;
        }
        if ("ldfgl".equals(type)) {
            String[] s = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                s[i] = list.get(i).getBiomassMachine();
            }
            map.put("chartdata", new String[]{"4月", "5月", "6月", "7月", "8月" });
            map.put("seriesdata", s);
            return map;
        }
        if ("fbsgf".equals(type)) {
            String[] s = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                s[i] = list.get(i).getPhotovoltaicPowerDistributed();
            }
            map.put("chartdata", new String[]{"4月", "5月", "6月", "7月", "8月" });
            map.put("seriesdata", s);
            return map;
        }
        if ("jzsgf".equals(type)) {
            String[] s = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                s[i] = list.get(i).getPhotovoltaicPowerCentralization();
            }
            map.put("chartdata", new String[]{"4月", "5月", "6月", "7月", "8月" });
            map.put("seriesdata", s);
            return map;
        }
        if ("fd".equals(type)) {
            String[] s = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                s[i] = list.get(i).getWindPower();
            }
            map.put("chartdata", new String[]{"4月", "5月", "6月", "7月", "8月" });
            map.put("seriesdata", s);
            return map;
        }

        return null;
    }

    /**
     * description: 获取区县详细信息(悬浮窗)
     * create by: hwx
     * create time: 2021-11-9 11:45:49
     */
    @Override
    public List<Map<String, Object>> getOverview(String cityCode, String countyCode, String selectMonth) {
        List<Map<String, Object>> list = new ArrayList<>();
        if (selectMonth == null || "".equals(selectMonth)) {
            selectMonth = "2021-08";
        }
        InstalledCapacity installedCapacity = new InstalledCapacity();
        if (countyCode != null && !"".equals(countyCode)) {
            installedCapacity = cleanAlternativeDao.getPhotovoltaicCountyCode(cityCode, countyCode, selectMonth);
        } else {
            //获取装机容量
            installedCapacity = cleanAlternativeDao.getPhotovoltaic(selectMonth);
        }


        Double capacity = Double.parseDouble(installedCapacity.getWindPower()) + Double.parseDouble(installedCapacity.getSubtotal());
        BigDecimal round = BigDecimal.valueOf(capacity).setScale(1, RoundingMode.HALF_UP);

        Map<String, Object> capacityMap = new HashMap<>();
        capacityMap.put("name", "装机容量");
        capacityMap.put("value", round);
        capacityMap.put("unit", "（万千瓦）");
        list.add(capacityMap);

        //获取光伏电站总数
        Integer gf = cleanAlternativeDao.getPhotovoltaicPowerStationTotal(countyCode);


        Map<String, Object> gf2Map = new HashMap<>();
        gf2Map.put("name", "光伏电站");
        gf2Map.put("value", gf);
        gf2Map.put("unit", "(座)");
        list.add(gf2Map);

        //获取光伏电站总数
        Integer fd = cleanAlternativeDao.getWindPowerPlantTotal(countyCode);


        Map<String, Object> fd2Map = new HashMap<>();
        fd2Map.put("name", "风电场");
        fd2Map.put("value", fd);
        fd2Map.put("unit", "(座)");
        list.add(fd2Map);


        //获取光伏电站总数
        Integer fbsgf = cleanAlternativeDao.getFbsgfyhPointDataTotal(countyCode);


        Map<String, Object> fbsgf2Map = new HashMap<>();
        fbsgf2Map.put("name", "分布式光伏");
        fbsgf2Map.put("value", fbsgf);
        fbsgf2Map.put("unit", "(户)");
        list.add(fbsgf2Map);

        return list;
    }

    /**
     * description: 装机容量占比
     * create by: hwx
     * create time: 2021-11-11 22:21:55
     */
    @Override
    public List<Map<String, Object>> getCapacity(String cityCode, String countyCode, String selectMonth) {
        if(selectMonth == null || "".equals(selectMonth)){
            selectMonth = "2021-08";
        }
        if ("2021-01".equals(selectMonth) || "2021-02".equals(selectMonth) ||"2021-03".equals(selectMonth) ||"2021-04".equals(selectMonth) ||"2021-09".equals(selectMonth)||
                "2021-10".equals(selectMonth) || "2021-11".equals(selectMonth) ||"2021-12".equals(selectMonth)){
            selectMonth = "2021-08";
        }
        InstalledCapacity installedCapacity = new InstalledCapacity();
        if (countyCode != null && !"".equals(countyCode)) {
            installedCapacity = cleanAlternativeDao.getCapacityCountyCode(cityCode, countyCode, selectMonth);
        } else {
            installedCapacity = cleanAlternativeDao.getCapacity(cityCode, countyCode, selectMonth);
        }

        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> jzMap = new HashMap<>();
        jzMap.put("name", "集中式光伏");
        jzMap.put("value", installedCapacity.getPhotovoltaicPowerCentralization());
        list.add(jzMap);
        Map<String, Object> fbMap = new HashMap<>();
        fbMap.put("name", "分布式光伏");
        fbMap.put("value", installedCapacity.getPhotovoltaicPowerDistributed());
        list.add(fbMap);
        Map<String, Object> fdMap = new HashMap<>();
        fdMap.put("name", "风电");
        fdMap.put("value", installedCapacity.getWindPower());
        list.add(fdMap);

        return list;
    }
}
