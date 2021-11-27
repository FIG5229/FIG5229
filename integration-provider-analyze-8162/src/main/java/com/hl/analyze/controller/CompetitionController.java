package com.hl.analyze.controller;

import com.github.pagehelper.PageInfo;
import com.hl.analyze.dto.JkjcListDTO;
import com.hl.analyze.dto.ReturnOnlnvestmentDTO;
import com.hl.analyze.entity.PageResult;
import com.hl.analyze.entity.po.EsWellMonthDataPO;
import com.hl.analyze.entity.po.Loads;
import com.hl.analyze.entity.vo.LoadsVO;
import com.hl.analyze.entity.vo.NoLoadVO;
import com.hl.analyze.entity.vo.HeavyLoadVO;
import com.hl.analyze.entity.vo.LightLoadVO;
import com.hl.analyze.query.*;
import com.hl.analyze.service.*;
import com.hl.analyze.utils.ExcelUtils;
import com.hl.analyze.utils.ResultUtil;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 竞赛控制器
 *
 * @author ForteScarlet
 */
@RestController
@RequestMapping("/electricitySubstitution")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CompetitionController {
    /**
     * 投资回报service 投资回报 Return on investment
     */
    private final ReturnOnInvestmentService returnOnInvestmentService;

    /**
     * 客户需求service
     */
    private final NoLoadService noLoadService;

    /**
     * 重过载service
     */
    private final HeavyLoadService heavyLoadService;

    /**
     * 轻空载service
     */
    private final LightLoadService lightLoadService;

    /**
     * 负载service
     */
    private final LoadsService loadsService;


    private final ResourcePoolService resourcePoolService;

    /**
     * 新增配变service
     */
    private final DistributionTransformShowService distributionTransformShowService;

    /**
     * 机井通电
     */
    private final ElectricitySubstitutionService electricitySubstitutionService;



    /**
     * 查询loads分页列表
     * @param query query
     * @return result
     */
    private PageResult<?> loadsList(LoadsQuery query) {
        final List<LoadsVO> list = loadsService.getList(query);
        return ResultUtil.successPage(list);
    }
    /**
     * id查询loads
     * @param vo 取id
     * @return result
     */
    @GetMapping("/getLoadById")
    public PageResult<?> loadsById(LoadsVO vo) {
        final Integer id = vo.getId();
        if (id == null) {
            return ResultUtil.error("id不可为空");
        }

        final LoadsVO result = loadsService.getById(id);
        return ResultUtil.success(result);
    }

    /**
     * <s>获取用户需求列表，分页查询 </s>
     *
     * 获取空载列表，分页查询
     *
     */
    @GetMapping({"/getYhxqList", "/getNoLoadList"})
    public PageResult<?> customerNeedsList(LoadsQuery query) {
        query.setLoadType(Loads.Type.NO.code);
        return loadsList(query);
    }



    //region 重过载/轻空载相关接口

    /**
     * 获取重过载数据列表
     * @param query 查询条件
     * @return list
     */
    @GetMapping({"/getZgzList", "getHeavyLoadList"})
    public PageResult<?> heavyOverloadList(LoadsQuery query) {
        query.setLoadType(Loads.Type.HEAVY.code);
        return loadsList(query);
    }

    /**
     * 获取轻空载数据列表
     * @param query 查询条件
     * @return list
     */
    @GetMapping({"/getQkzList", "/getLightLoadList"})
    public PageResult<?> lightOnLoadList(LoadsQuery query) {
        query.setLoadType(Loads.Type.LIGHT.code);
        return loadsList(query);
    }

    /**
     * 获取重过载卡片信息。
     * @return result
     */
    @GetMapping("/getHeavyOverloadEarlyWarning")
    public PageResult<?> getHeavyOverloadEarlyWarning() {
        return ResultUtil.success(resourcePoolService.getHeavyOverloadCard());
    }

    /**
     * 获取用户需求卡片信息。
     * @return result
     */
    @GetMapping("/getUserDemandEarlyWarning")
    public PageResult<?> getCustomerNeedsEarlyWarning() {
        return ResultUtil.success(resourcePoolService.getCustomerNeedCard());
    }


    //
    //
    // /**
    //  * 通过ID获取用户需求
    //  *
    //  */
    // @GetMapping({"/getYhxqById", "/getNoLoadById"})
    // public PageResult<?> getCustomerNeedsById(NoLoadVO vo) {
    //     NoLoadVO result = noLoadService.getById(vo.getId());
    //     return ResultUtil.success(result);
    // }


    //
    //  /**
    //   * id查询重过载数据
    //   * @param vo vo
    //   * @return result
    //   */
    // @GetMapping("/getZgzById")
    //  public PageResult<?> getHeavyOverloadById(HeavyLoadVO vo) {
    //      HeavyLoadVO result = heavyLoadService.getById(vo.getId());

    //      return ResultUtil.success(result);

   //  }
    //
    //  /**
    //   * 获取轻空载数据
    //   * @param vo 查询条件
    //   * @return result
    //   */
    // @GetMapping("/getQkzById")
    //  public PageResult<?> getLightOnLoadById(LightLoadVO vo) {
    //      LightLoadVO result = lightLoadService.getById(vo.getId());
    //      return ResultUtil.success(result);
    //  }

   //


    //endregion


    /**
     * 工程项目投资回报排名列表接口
     * @param
     * @return list
     */
    @GetMapping("/getGcxmtxhb")
    public PageResult<?> getGcxmtxhb(){
        return ResultUtil.success(returnOnInvestmentService.getGcxmtxhb());
    }

    /**
     * 工程项目投资回报排名二级弹窗列表接口
     * @param
     * @return list
     */
    @GetMapping("/getGcxmtzpmList")
    public PageResult<?> getGcxmtzpmList(ReturnOnlnvestmentDTO returnOnlnvestmentDTO){
        return ResultUtil.success(returnOnInvestmentService.getGcxmtzpmList(returnOnlnvestmentDTO));
    }

    /**
     * 散点图象限分析接口
     * @param
     * @return list
     */
    @GetMapping("/getQuadrant")
    public PageResult<?> getQuadrant(){
        return ResultUtil.success(returnOnInvestmentService.getQuadrant());

    }

    /**
     * 新增配变二级菜单
     * @param
     * @return list
     */
    @GetMapping("/getDistributionTransformShowList")
    public PageResult<?> getDistributionTransformShowList(String unit){
        return ResultUtil.success(distributionTransformShowService.getDistributionTransformShowList(unit));
    }

    /**
     * 获取井口电量列表-竞赛用
     *
     * @param query 参数实体
     * @return 井口电量列表
     */
    @RequestMapping("/getNewJkdlList")
    public PageResult<JkjcListDTO> getNewJkdlList(JkdlQuery query) {
        List<JkjcListDTO> jkjcList = electricitySubstitutionService.getNewJkdlList(query, false);
        return ResultUtil.successPage(jkjcList);
    }


    @PostMapping("/export-data")
    @SneakyThrows
    public void exportData(@RequestBody JkdlQuery jkdlQuery, HttpServletResponse response){
        List<JkjcListDTO> newJkdlList = electricitySubstitutionService.getNewJkdlList(jkdlQuery, true);
        ExcelUtils.exportExcel(newJkdlList, "井口监测明细", response);
    }

}
