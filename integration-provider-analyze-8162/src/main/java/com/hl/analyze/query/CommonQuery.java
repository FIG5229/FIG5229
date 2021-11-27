package com.hl.analyze.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 公共查询条件实体
 *
 * @author hupg
 * @date 2021/9/26 18:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonQuery implements Serializable {
    private static final long serialVersionUID = -7763802085696542245L;

    /**
     * 省级编码
     */
    private String provinceCode;

    /**
     * 地市编码
     */
    private String cityCode;

    /**
     * 区县编码
     */
    private String countyCode;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

}
