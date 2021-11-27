package com.hl.analyze.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jason
 * @date 2021/11/11
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NameBO implements Serializable {
    private static final long serialVersionUID = 8281478028926879717L;

    private String name;

}
