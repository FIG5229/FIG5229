package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * description: 光伏违约
 * create by: hwx
 * create time: 2021/11/8 17:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotovoltaicDefault implements Serializable {

    private static final long serialVersionUID = -7768895445308493884L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private Integer id;

    /**
     * description: 供电所
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private String managementUnitName;

    /**
     * description:户号
     * create by: hwx
     * create time: 2021/11/8 17:13
     */
    private String doorNo;    /**
     * description:地市
     * create by: hwx
     * create time: 2021/11/8 17:13
     */
    private String city;
    /**
     * description:区县
     * create by: hwx
     * create time: 2021/11/8 17:13
     */
    private String county;
    /**
     * description: 地市编码
     * create by: hwx
     * create time: 2021/11/8 16:22
     */
    private String cityCode;

    /**
     * description: 区县
     * create by: hwx
     * create time: 2021/11/8 16:22
     */
    private String countyCode;
    /**
     * description:日期
     * create by: hwx
     * create time: 2021/11/8 17:13
     */
    private String date;
    /**
     * description:状态
     * create by: hwx
     * create time: 2021/11/8 17:13
     */
    private String status;
}
