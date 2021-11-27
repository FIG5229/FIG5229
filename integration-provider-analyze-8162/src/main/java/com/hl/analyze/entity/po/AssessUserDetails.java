package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author hwx
 * @date 2021/11/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssessUserDetails implements Serializable {

    private static final long serialVersionUID = 7372260181727779040L;
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/8 16:21
     */
    private Integer id;
    /**
     * description: 户号
     * create by: hwx
     * create time: 2021/11/10 14:11
     */
    private String doorNo;
    /**
     * description: 地理位置
     * create by: hwx
     * create time: 2021/11/10 14:11
     */
    private String geographicPosition;
    /**
     * description: 台区名称
     * create by: hwx
     * create time: 2021/11/10 14:11
     */
    private String courtsName;

    /**
     * description: 时间
     * create by: hwx
     * create time: 2021/11/10 14:11
     */
    private String date;
    /**
     * description: 容量
     * create by: hwx
     * create time: 2021/11/10 14:13
     */
    private String capacity;
    /**
     * description: 发电量
     * create by: hwx
     * create time: 2021/11/10 14:13
     */
    private String generatingCapacity;
}
