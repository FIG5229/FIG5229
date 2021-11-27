package com.hl.analyze.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.hl.analyze.dao.ElectricitySubstitutionDao;
import com.hl.analyze.dto.CustomerDemandDTO;
import com.hl.analyze.dto.IrrigationPowerDTO;
import com.hl.analyze.dto.JkjcListDTO;
import com.hl.analyze.dto.ZeroElectricityDTO;
import com.hl.analyze.entity.podo.LabelValueDO;
import com.hl.analyze.query.CommonQuery;
import com.hl.analyze.query.JkdlQuery;
import com.hl.analyze.service.ElectricitySubstitutionService;
import com.integration.utils.MyPagUtile;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jason
 * @date 2021/10/21
 */

@Service
public class ElectricitySubstitutionServiceImpl implements ElectricitySubstitutionService {

    @Resource
    private ElectricitySubstitutionDao electricitySubstitutionDao;

    @Value("${hlkj.irrigation-power-base-data}")
    private String irrigationPowerBaseData;


    @Override
    public List<Map<String, Object>> getOverviewMachine(CommonQuery commonQuery) {
        List<Map<String, Object>> resultList = Lists.newArrayList();

        List<Map<String, Object>> overviewMachineList = electricitySubstitutionDao.getOverviewMachine("jjt");
        Map<String, Map<String, Object>> overviewMachineMap = overviewMachineList.stream()
                .collect(Collectors.toMap(item -> item.get("label").toString(), item -> item));

        resultList.addAll(overviewMachineList);

        int size = overviewMachineList.size();
        // 如果没有项目用电量模拟数据，则查询数据库真实数据
        /*if (!overviewMachineMap.containsKey("项目用电量")) {
            String projectElectricity = electricitySubstitutionDao.getProjectElectricityConsumption();
            Map<String, Object> projectElectricityMap = new HashMap<>(16);
            projectElectricityMap.put("label", "项目用电量");
            projectElectricityMap.put("value", projectElectricity);
            projectElectricityMap.put("unit", "亿千瓦时");
            projectElectricityMap.put("sort", ++size);
            resultList.add(projectElectricityMap);
        }*/

        // 如果没有工程总投资模拟数据，则查询数据库真实数据
        if (!overviewMachineMap.containsKey("工程总投资")) {
            String actualCost = electricitySubstitutionDao.getActualCost();
            Map<String, Object> actualCostMap = new HashMap<>(16);
            actualCostMap.put("label", "工程总投资");
            actualCostMap.put("value", actualCost);
            actualCostMap.put("sort", ++size);
            actualCostMap.put("unit", "亿元");
            resultList.add(actualCostMap);
        }

        return resultList;
    }

    @Override
    public Map<String, Object> getInvestmentMachine(CommonQuery commonQuery) {
        List<Map<String, Object>> investmentMachineList = electricitySubstitutionDao.getInvestmentMachine();

        List<String> xAxisDataList = Lists.newArrayList();
        List<String> barDataList = Lists.newArrayList();

        investmentMachineList.forEach(item -> {
            xAxisDataList.add(item.get("projectYear").toString());
            barDataList.add(item.get("actualCost").toString());
        });

        return new HashMap<String, Object>(16) {
            private static final long serialVersionUID = -5529727369092971399L;

            {
                put("xAxisData", xAxisDataList);
                // 柱图与折线图用同一条数据
                put("barData", barDataList);
                put("lineData", barDataList);
            }
        };
    }

    @Override
    public List<Map<String, Object>> getMachineBenefitAnalysis() {
        List<Map<String, Object>> machineBenefitAnalysis = electricitySubstitutionDao.getMachineBenefitAnalysis();
        return machineBenefitAnalysis;
    }

    @Override
    public List<Map<String, Object>> getEarlyWarnMachine(CommonQuery commonQuery) {
        List<Map<String, Object>> resultList = Lists.newArrayList();

        List<Map<String, String>> customerMonthData = electricitySubstitutionDao.getCustomerMonthData();

        // 获取零电量个数
        long zeroElectricitySize = customerMonthData.stream()
                .filter(item -> 0 == Integer.parseInt(item.get("3month")) + Integer.parseInt(item.get("4month")) + Integer.parseInt(item.get("5month")))
                .count();

        // 不规律电量个数
        long irregularElectricitySize = customerMonthData.stream()
                .filter(item -> Integer.parseInt(item.get("1month")) + Integer.parseInt(item.get("2month")) + Integer.parseInt(item.get("6month")) >
                        Integer.parseInt(item.get("3month")) + Integer.parseInt(item.get("4month")) + Integer.parseInt(item.get("5month")))
                .count();

        Map<String, Object> zeroElectricityMap = new HashMap<>(16);
        zeroElectricityMap.put("label", "零电量个数");
        zeroElectricityMap.put("value", zeroElectricitySize);

        Map<String, Object> irregularElectricityMap = new HashMap<>(16);
        irregularElectricityMap.put("label", "不规律电量个数");
        irregularElectricityMap.put("value", irregularElectricitySize);

        resultList.add(zeroElectricityMap);
        resultList.add(irregularElectricityMap);

        return resultList;
    }

    @Override
    public PageInfo getEarlyWarnMachineList(Integer type) {
        List<Map<String, String>> selectList = Lists.newArrayList();
        MyPagUtile.startPage();
        if (type.equals(0)) {
            // 零电量
            selectList = electricitySubstitutionDao.getZeroElectricity();
        } else if (type.equals(1)) {
            // 不规律电量
            selectList = electricitySubstitutionDao.getIrregularElectricity();
        }
        if (CollectionUtils.isEmpty(selectList)) {
            return new PageInfo<>();
        }
        ArrayList<String> customerNumbers = Lists.newArrayList();
        selectList.forEach(map -> {
            customerNumbers.add(map.get("customerNumber"));
        });
        PageInfo pageInfo = new PageInfo<>(selectList);
        // 根据客户编号获取客户信息
        List<ZeroElectricityDTO> custInfo = electricitySubstitutionDao.getCustInfoOfZeroElectricity(customerNumbers);
        custInfo.forEach(item -> {
            item.setCoordinate(JSONObject.parseArray(Optional.ofNullable(item.getAxis()).orElse("[]"), BigDecimal.class));
        });
        pageInfo.setList(custInfo);
        return pageInfo;
    }

    @Override
    public List<JkjcListDTO> getJkdlList(JkdlQuery query) {
        MyPagUtile.startPage();

        // 获取用户信息
        List<JkjcListDTO> list = electricitySubstitutionDao.getJkdlList(query);

        if (CollectionUtils.isEmpty(list)) {
            return Lists.newArrayList();
        }

        // 获取用户电量信息
        List<String> customerNumberList = list.stream()
                .map(JkjcListDTO::getHh)
                .collect(Collectors.toList());
        Map<String, JkjcListDTO> collect = electricitySubstitutionDao.getJkdlByCustomerNumberList(customerNumberList).stream()
                .collect(Collectors.toMap(JkjcListDTO::getHh, value -> value));

        // 组合用户与电量信息
        list.forEach(item -> {
            JkjcListDTO customerData = collect.get(item.getHh());
            item.setType(customerData.getType());
            item.setMonth1(customerData.getMonth1());
            item.setMonth2(customerData.getMonth2());
            item.setMonth3(customerData.getMonth3());
            item.setMonth4(customerData.getMonth4());
            item.setMonth5(customerData.getMonth5());
            item.setMonth6(customerData.getMonth6());
            item.setMonth7(customerData.getMonth7());
        });
        return list;
    }

    @Override
    public List<JkjcListDTO> getNewJkdlList(JkdlQuery query, boolean exportFlag) {
        if (!exportFlag) {
            MyPagUtile.startPage();
        }

        List<JkjcListDTO> list = electricitySubstitutionDao.getJkdlList(query);

        if (exportFlag) {
            for (int i = 0; i < list.size(); i++) {
                JkjcListDTO jkjc = list.get(i);
                jkjc.setId(i+1);
                switch (jkjc.getType()) {
                    case "ldl": {
                        jkjc.setType("零电量");
                        break;
                    }
                    case "bgl": {
                        jkjc.setType("不规律电量");
                        break;
                    }
                    default: {
                        jkjc.setType("正常");
                    }
                }
            }
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> getIrregularChargeData() {

        // 获取用电数据
        List<Map<String, String>> customerMonthData = electricitySubstitutionDao.getCustomerMonthData();
        // 不规律电量客户编号集合
        Set<String> customerNumberSet = customerMonthData.stream()
                .filter(item -> Integer.parseInt(item.get("1month")) + Integer.parseInt(item.get("2month")) + Integer.parseInt(item.get("6month")) >
                        Integer.parseInt(item.get("3month")) + Integer.parseInt(item.get("4month")) + Integer.parseInt(item.get("5month")))
                .map(item -> item.get("customerNumber"))
                .collect(Collectors.toSet());
        if (CollectionUtils.isEmpty(customerNumberSet)) {
            return Lists.newArrayList();
        }
        List<Map<String, Object>> irregularChargeData = electricitySubstitutionDao.getCompanyAxisByCustomerNumberSet(customerNumberSet);
        irregularChargeData.forEach(map -> {
            map.put("coordinate", JSONObject.parseArray(Optional.ofNullable(map.get("coordinate")).orElse("[]").toString()));
        });
        return irregularChargeData;
    }

    @Override
    public List<Map<String, Object>> getZeroChargeData(Integer type) {

        // 获取用电数据
        List<Map<String, String>> customerMonthData = electricitySubstitutionDao.getCustomerMonthData();
        // 零电量客户编号集合
        Set<String> customerNumberSet = customerMonthData.stream()
                .filter(item -> 0 == Integer.parseInt(item.get("3month")) + Integer.parseInt(item.get("4month")) + Integer.parseInt(item.get("5month")))
                .map(item -> item.get("customerNumber"))
                .collect(Collectors.toSet());

        if (CollectionUtils.isEmpty(customerNumberSet)) {
            return Lists.newArrayList();
        }

        List<Map<String, Object>> irregularChargeData = electricitySubstitutionDao.getCompanyAxisByCustomerNumberSet(customerNumberSet);
        irregularChargeData.forEach(map -> {
            map.put("type", 0);
            map.put("coordinate", JSONObject.parseArray(Optional.ofNullable(map.get("coordinate")).orElse("[]").toString()));
        });

        if (type == 1) {
            Set<String> companyCodeSet = irregularChargeData.stream()
                    .map(item -> Optional.ofNullable(item.get("companyCode")).orElse("").toString())
                    .collect(Collectors.toSet());
            List<String> customerDemandList = electricitySubstitutionDao.getCustomerDemandByCompanyCodeSet(companyCodeSet);
            irregularChargeData.forEach(item -> {
                if (customerDemandList.contains(item.get("companyCode").toString())) {
                    item.put("type", 1);
                }
            });
        }
        return irregularChargeData;

    }

    @Override
    public List<CustomerDemandDTO> getYhxqList(String companyCode) {
        List<CustomerDemandDTO> list = electricitySubstitutionDao.getYhxqList(companyCode);
        return list;
    }

    @Override
    public List<Map<String, Object>> exportJkjcExcel() {
        List<Map<String, Object>> maps = electricitySubstitutionDao.exportJkjcExcel();

        for (Map<String, Object> map : maps) {
            if (0 == ((BigDecimal) map.get("2021年1月")).intValue() + ((BigDecimal) map.get("2021年4月")).intValue() + ((BigDecimal) map.get("2021年5月")).intValue()) {
                map.put("类型", "不规律电量");
            } else if (((BigDecimal) map.get("2021年1月")).intValue() + ((BigDecimal) map.get("2021年2月")).intValue() + ((BigDecimal) map.get("2021年6月")).intValue() >
                    ((BigDecimal) map.get("2021年1月")).intValue() + ((BigDecimal) map.get("2021年4月")).intValue() + ((BigDecimal) map.get("2021年5月")).intValue()) {
                map.put("类型", "不规律电量");
            } else {
                map.put("类型", "正常");
            }

        }

        return maps;
    }

    @Override
    public List<IrrigationPowerDTO> getIrrigationPower(CommonQuery commonQuery, String customerNumber, String type) {
        // 查看基准数据则直接返回
        if (StringUtils.isBlank(customerNumber)) {
            return JSONObject.parseArray(irrigationPowerBaseData, IrrigationPowerDTO.class);
        }
        // 获取用户的电量数据
        List<LabelValueDO> labelValueList = electricitySubstitutionDao.getIrrigationPower(customerNumber);
        List<IrrigationPowerDTO> list = Lists.newArrayList();
        // 添加用户数据
        list.add(IrrigationPowerDTO.builder()
                .smooth(false)
                .data(labelValueList)
                .type(type)
                .build());

        // 不规律用户添加基准数据作为对比
        if (StringUtils.equals("bgl", type)) {
            list.addAll(JSONObject.parseArray(irrigationPowerBaseData, IrrigationPowerDTO.class));
        }
        return list;
    }
}
