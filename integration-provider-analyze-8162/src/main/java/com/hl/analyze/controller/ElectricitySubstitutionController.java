package com.hl.analyze.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.hl.analyze.dto.CustomerDemandDTO;
import com.hl.analyze.dto.IrrigationPowerDTO;
import com.hl.analyze.dto.JkjcListDTO;
import com.hl.analyze.query.CommonQuery;
import com.hl.analyze.entity.PageResult;
import com.hl.analyze.query.JkdlQuery;
import com.hl.analyze.service.ElectricitySubstitutionService;
import com.hl.analyze.utils.ExcelUtils;
import com.hl.analyze.utils.ResultUtil;
import com.integration.utils.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 电力替代
 *
 * @author jason
 * @date 2021/10/21
 */

@Slf4j
@RestController
@RequestMapping("/electricitySubstitution")
public class ElectricitySubstitutionController {

    @Resource
    private ElectricitySubstitutionService electricitySubstitutionService;

    /**
     * 机井通数据概况
     *
     * @param commonQuery 通用查询参数
     * @return
     */
    @RequestMapping("/getOverviewMachine")
    public PageResult getOverviewMachine(CommonQuery commonQuery) {
        List<Map<String, Object>> overviewMachine = electricitySubstitutionService.getOverviewMachine(commonQuery);
        return ResultUtil.success(overviewMachine);
    }

    /**
     * 机井通数据概况
     *
     * @param commonQuery 通用查询参数
     * @return
     */
    @RequestMapping("/getInvestmentMachine")
    public PageResult getInvestmentMachine(CommonQuery commonQuery) {
        Map<String, Object> overviewMachine = electricitySubstitutionService.getInvestmentMachine(commonQuery);
        return ResultUtil.success(overviewMachine);
    }

    /**
     * 下载机井通效益分析明细
     *
     * @param response
     * @return excel
     */
    @RequestMapping("/downloadMachineBenefitAnalysis")
    public PageResult downloadMachineBenefitAnalysis(HttpServletResponse response) throws IOException {
        // 文件名
        String fileName = DateUtils.getDate() + "机井通效益分析";
        String[] headers = {"项目定义", "项目定义描述", "利润中心描述", "资产编码", "设备编码", "配变编号", "台区编号", "台区名称", "台区管理单位", "投运日期", "终端编号",
                "终端名称", "终端地址码", "电能表资产编号", "表码记录时间", "正向有功总", "反向有功总", "综合倍率", "单位名称"};
        List<Map<String, Object>> resultList = electricitySubstitutionService.getMachineBenefitAnalysis();
        // 输出Excel文件
        OutputStream output = response.getOutputStream();
        response.reset();
        // 读取到workbook
        String sheetName = "机井通效益分析明细";
        HSSFWorkbook workbook = new HSSFWorkbook();
        ExcelUtils.write2Sheet(workbook, sheetName, headers, resultList, "yyyy-MM-dd");
        // 设置导出文件表头（即文件名）
        response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
        // 设置返回内容类型
        response.setContentType("application/msexcel");
        workbook.write(output);
        output.close();
        return ResultUtil.success("导出成功", null);
    }

    /**
     * 机井通预警数据
     *
     * @param commonQuery 通用查询参数
     * @return
     */
    @RequestMapping("/getEarlyWarnMachine")
    public PageResult getEarlyWarnMachine(CommonQuery commonQuery) {
        List<Map<String, Object>> earlyWarnMachineMap = electricitySubstitutionService.getEarlyWarnMachine(commonQuery);
        return ResultUtil.success(earlyWarnMachineMap);
    }

    /**
     * 机井通预警数据列表数据
     *
     * @param type 0:零电量 1:不规律电量
     * @return
     */
    @RequestMapping(value = "/getEarlyWarnMachineList")
    public PageResult getEarlyWarnMachineList(Integer type) {
        PageInfo pageInfo = electricitySubstitutionService.getEarlyWarnMachineList(type);
        return ResultUtil.success(pageInfo);
    }

    /**
     * 获取井口电量列表
     *
     * @param query 参数实体
     * @return 井口电量列表
     */
    @RequestMapping("/getJkdlList")
    public PageResult<JkjcListDTO> getJkdlList(JkdlQuery query) {
        List<JkjcListDTO> jkjcList = electricitySubstitutionService.getJkdlList(query);
        return ResultUtil.successPage(jkjcList);
    }

    /**
     * 获取不规律电量打点数据
     *
     * @param commonQuery 通用查询参数
     * @return 不规律电量供电所坐标
     */
    @RequestMapping("/getIrregularChargeData")
    public PageResult<Map<String, Object>> getIrregularChargeData(CommonQuery commonQuery) {
        List<Map<String, Object>> irregularChargeList = electricitySubstitutionService.getIrregularChargeData();
        return ResultUtil.success(irregularChargeList);
    }

    /**
     * 获取零电量打点数据
     *
     * @param commonQuery 通用查询参数
     * @return 零电量供电所坐标
     */
    @RequestMapping("/getZeroChargeData")
    public PageResult<Map<String, Object>> getZeroChargeData(CommonQuery commonQuery, Integer type) {
        List<Map<String, Object>> zeroChargeList = electricitySubstitutionService.getZeroChargeData(type);
        return ResultUtil.success(zeroChargeList);
    }

    /**
     * 获取零电量打点数据
     *
     * @param commonQuery 通用查询参数
     * @return 零电量供电所坐标
     */
    @RequestMapping("/getYhxqList")
    public PageResult<CustomerDemandDTO> getYhxqList(CommonQuery commonQuery, String companyCode) {
        if (StringUtils.isBlank(companyCode)) {
            return ResultUtil.error("客户编码不能为空！");
        }
        List<CustomerDemandDTO> zeroChargeList = electricitySubstitutionService.getYhxqList(companyCode);
        return ResultUtil.successPage(zeroChargeList);
    }


    /**
     * 下载井口监测信息
     *
     * @param response
     * @return excel
     */
    @RequestMapping("/exportJkjcExcel")
    public PageResult exportJkjcExcel(HttpServletResponse response) {
        // 文件名
        String[] headers = {"序号", "单位", "供电所", "户号", "户名", "地址", "2021年1月", "2021年1月", "2021年1月",
                "2021年1月", "2021年1月", "2021年1月", "2021年1月", "类型"};
        List<Map<String, Object>> resultList = electricitySubstitutionService.exportJkjcExcel();
        // 输出Excel文件
        String fileName = DateUtils.getDate() + "井口监测明细";
        OutputStream output = null;
        try {
            output = response.getOutputStream();
            response.reset();
            // 读取到workbook
            String sheetName = "Sheet1";
            HSSFWorkbook workbook = new HSSFWorkbook();
            ExcelUtils.write2Sheet(workbook, sheetName, headers, resultList, "yyyy-MM-dd");
            // 设置导出文件表头（即文件名）
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
            // 设置返回内容类型
            response.setContentType("application/msexcel");
            workbook.write(output);

        } catch (IOException e) {
            log.error("导出井口监测列表发生错误，错误信息：{}", e.getMessage(), e);
            return ResultUtil.error(e.getMessage());
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ResultUtil.success("导出成功", null);
    }

    /**
     * 灌溉用电图
     *
     * @param commonQuery 通用查询参数
     * @return 零电量供电所坐标
     */
    @RequestMapping("/getIrrigationPower")
    public PageResult<IrrigationPowerDTO> getIrrigationPower(CommonQuery commonQuery, String customerNumber, String type) {
        List<IrrigationPowerDTO> irrigationPowerList = electricitySubstitutionService.getIrrigationPower(commonQuery, customerNumber, type);
        return ResultUtil.success(irrigationPowerList);
    }

}
