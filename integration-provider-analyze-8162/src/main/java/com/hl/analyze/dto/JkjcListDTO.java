package com.hl.analyze.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.hl.analyze.entity.podo.ExcelVerifyDO;
import lombok.Data;

/**
 * @author jason
 * @date 2021/11/9
 */

@Data
public class JkjcListDTO extends ExcelVerifyDO {

    /**
     * id
     */
    @Excel(name = "序号")
    private Integer id;

    /**
     * 单位
     */
    @Excel(name = "单位")
    private String dw;


    /**
     * 供电所
     */
    @Excel(name = "供电所")
    private String gds;

    /**
     * 户号
     */
    @Excel(name = "户号")
    private String hh;

    /**
     * 户名
     */
    @Excel(name = "户名")
    private String hm;

    /**
     * 地址
     */
    @Excel(name = "地址")
    private String dz;


    /**
     * 城市编码-未用到
     */
    private String cityCode;

    @Excel(name = "2021年1月")
    private Integer month1;

    @Excel(name = "2021年2月")
    private Integer month2;

    @Excel(name = "2021年3月")
    private Integer month3;

    @Excel(name = "2021年4月")
    private Integer month4;

    @Excel(name = "2021年5月")
    private Integer month5;

    @Excel(name = "2021年6月")
    private Integer month6;

    @Excel(name = "2021年7月")
    private Integer month7;

    /**
     * ldl-零电量
     * bgl-不规律用电量
     * normal-正常
     */
    @Excel(name = "类型")
    private String type;

}
