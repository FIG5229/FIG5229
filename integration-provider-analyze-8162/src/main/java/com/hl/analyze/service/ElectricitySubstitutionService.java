package com.hl.analyze.service;

import com.github.pagehelper.PageInfo;
import com.hl.analyze.dto.CustomerDemandDTO;
import com.hl.analyze.dto.IrrigationPowerDTO;
import com.hl.analyze.dto.JkjcListDTO;
import com.hl.analyze.query.CommonQuery;
import com.hl.analyze.query.JkdlQuery;

import java.util.List;
import java.util.Map;

/**
 * @author jason
 * @date 2021/10/21
 */
public interface ElectricitySubstitutionService {

    /**
     * 机井通数据概况
     *
     * @param commonQuery 通用查询参数
     * @return
     */
    List<Map<String, Object>> getOverviewMachine(CommonQuery commonQuery);

    /**
     * 机井通投资概况
     *
     * @param commonQuery 通用查询参数
     * @return
     */
    Map<String, Object> getInvestmentMachine(CommonQuery commonQuery);

    /**
     * 机井通效益分析明细
     *
     * @return
     */
    List<Map<String, Object>> getMachineBenefitAnalysis();

    /**
     * 获取机井通预警数据
     *
     * @param commonQuery 通用查询参数
     * @return
     */
    List<Map<String, Object>> getEarlyWarnMachine(CommonQuery commonQuery);

    /**
     * 获取零点亮列表
     *
     * @return
     */
    PageInfo getEarlyWarnMachineList(Integer type);

    /**
     * 获取井口电量列表
     *
     * @param query 实体参数
     * @return 井口电量列表
     */
    List<JkjcListDTO> getJkdlList(JkdlQuery query);

    /**
     * 获取井口电量列表-竞赛用
     *
     * @param query 实体参数
     * @return 井口电量列表
     */
    List<JkjcListDTO> getNewJkdlList(JkdlQuery query, boolean exportFlag);

    List<Map<String, Object>> getIrregularChargeData();

    /**
     * 获取客户需求/零电量打点
     *
     * @param type 0 : 零电量 1：用户需求
     * @return
     */
    List<Map<String, Object>> getZeroChargeData(Integer type);

    /**
     * 获取用户需求列表
     *
     * @param companyCode 供电所编码
     * @return 客户需求列表数据
     */
    List<CustomerDemandDTO> getYhxqList(String companyCode);

    /**
     * 导出井口监测明细
     *
     * @return
     */
    List<Map<String, Object>> exportJkjcExcel();

    /**
     * 获取灌溉用电图
     *
     * @return
     */
    List<IrrigationPowerDTO> getIrrigationPower(CommonQuery commonQuery, String customerNumber, String type);
}
