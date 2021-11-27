package com.hl.analyze.dao;

import com.hl.analyze.dto.CustomerDemandDTO;
import com.hl.analyze.dto.JkjcListDTO;
import com.hl.analyze.dto.ZeroElectricityDTO;
import com.hl.analyze.entity.podo.LabelValueDO;
import com.hl.analyze.query.JkdlQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jason
 * @date 2021/10/21
 */

public interface ElectricitySubstitutionDao {

    /**
     * 根据类型获取数据概览
     *
     * @param type 类型
     * @return
     */
    List<Map<String, Object>> getOverviewMachine(@Param("type") String type);

    /**
     * 获取机井通项目用电量
     *
     * @return 项目用电量
     */
    String getProjectElectricityConsumption();

    /**
     * 获取机井通总实际成本
     *
     * @return 实际成本
     */
    String getActualCost();

    /**
     * 获取年度实际成本
     *
     * @return
     */
    List<Map<String, Object>> getInvestmentMachine();

    /**
     * 获取机井通效益分析明细
     *
     * @return
     */
    List<Map<String, Object>> getMachineBenefitAnalysis();

    /**
     * 获取客户用电数据
     *
     * @return
     */
    List<Map<String, String>> getCustomerMonthData();

    /**
     * 获取345零电量数据-分页
     *
     * @return
     */
    List<Map<String, String>> getZeroElectricity();

    /**
     * 获取不规律电量数据-分页
     *
     * @return
     */
    List<Map<String, String>> getIrregularElectricity();

    /**
     * 根据客户编号获取客户信息
     *
     * @param customerNumbers 客户编号列表
     * @return
     */
    List<ZeroElectricityDTO> getCustInfoOfZeroElectricity(@Param("customerNumbers") List<String> customerNumbers);

    /**
     * 获取井口监测列表
     *
     * @param query 实体参数
     * @return 井口监测列表
     */
    List<JkjcListDTO> getJkdlList(JkdlQuery query);


    List<JkjcListDTO> getJkdlByCustomerNumberList(List<String> customerNumberList);

    /**
     * 根据客户编码获取供电所坐标
     *
     * @param customerNumberSet customerNumberList
     * @return
     */
    List<Map<String, Object>> getCompanyAxisByCustomerNumberSet(@Param("customerNumberSet") Set<String> customerNumberSet);

    /**
     * 根据供电所编码获取客户需求列表
     *
     * @param companyCode 供电所编码
     * @return customerDemandList
     */
    List<CustomerDemandDTO> getYhxqList(@Param("companyCode") String companyCode);

    /**
     * 井口监测明细
     *
     * @return
     */
    List<Map<String, Object>> exportJkjcExcel();

    /**
     * 根据用户编码获取灌溉用电图
     *
     * @param customerNumber 客户编码
     * @return 月份, 用电量
     */
    List<LabelValueDO> getIrrigationPower(String customerNumber);

    List<String> getCustomerDemandByCompanyCodeSet(@Param("companyCodeSet") Set<String> companyCodeSet);
}
