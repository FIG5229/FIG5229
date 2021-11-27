package com.hl.analyze.entity.bo;

import lombok.Data;

/**
 * @author xupengan
 * @date 2021/2/8
 */

@Data
public class BaiDuMapEntityBO {

    private String city;

    private String direction;

    private String distance;

    private String district;

    private String province;

    private String street;

    private String street_number;

    /**
     * 镇
     */
    private String town;

}
