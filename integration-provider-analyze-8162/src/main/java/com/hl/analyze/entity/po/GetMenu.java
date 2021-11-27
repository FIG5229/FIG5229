package com.hl.analyze.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hwx
 * @date 2021/11/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMenu {
    /**
     * description: id
     * create by: hwx
     * create time: 2021/11/10 11:31
     */
    private Integer id;
    /**
     * description: 地市或者区县名
     * create by: hwx
     * create time: 2021/11/10 11:31
     */
    private String menuName;
    /**
     * description: 地市或者区县编码
     * create by: hwx
     * create time: 2021/11/10 11:31
     */
    private String code;
}
