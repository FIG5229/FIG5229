package com.hl.analyze.entity.vo;

import com.hl.analyze.entity.po.HeavyLoad;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * 重过载点位数据。
 * 其中一个中心点，周围4个轻空载点。
 *
 * @see HeavyLoad
 *
 * @author ForteScarlet
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HeavyLoadCard extends LightLoadsCard {


}
