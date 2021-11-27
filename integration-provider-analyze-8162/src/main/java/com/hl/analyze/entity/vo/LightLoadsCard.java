package com.hl.analyze.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * @author ForteScarlet
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class LightLoadsCard extends ResourcePoolCard {

    @JsonProperty("transformer")
    private String transformerName;

    @JsonProperty("powerSupply")
    private String company;

    /**
     * 供电所code
     */
    private String companyCode;

    /**
     * 变压器code
     */
    private String transformerId;

    /**
     * 最大电流。
     */
    @JsonProperty("maxCurrent")
    private BigDecimal maxCurrent;


    @JsonProperty("minimum")
    private BigDecimal matchMinCapacity;
}
