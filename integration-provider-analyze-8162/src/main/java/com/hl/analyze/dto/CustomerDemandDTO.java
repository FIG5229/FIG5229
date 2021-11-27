package com.hl.analyze.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jason
 * @date 2021/11/9
 */

@Data
public class CustomerDemandDTO implements Serializable {
    private static final long serialVersionUID = -4550495815199277148L;

    private Integer id;

    private String customerName;

    private String address;

    private String companyName;

    private String appliedCapacity;

}
