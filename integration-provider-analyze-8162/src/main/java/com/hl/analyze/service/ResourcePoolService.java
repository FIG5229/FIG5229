package com.hl.analyze.service;

import com.hl.analyze.entity.vo.NoLoadCard;
import com.hl.analyze.entity.vo.HeavyLoadCard;
import com.hl.analyze.entity.vo.LightLoadsCard;
import com.hl.analyze.entity.vo.ResourcePoolCard;

import java.util.List;

/**
 * 资源池相关服务接口
 *
 * @author ForteScarlet
 */
public interface ResourcePoolService {

    /**
     * 得到重过载卡片坐标数据
     * 列表中，type = 0 的是 {@link HeavyLoadCard},
     * 剩下的 type = 1 的是 {@link LightLoadsCard}
     * @return card
     */
    List<? extends ResourcePoolCard> getHeavyOverloadCard();

    /**
     * 得到轻空载卡片坐标数据.
     * 列表中，type = 0 的是 {@link NoLoadCard},
     * 剩下的 type = 1 的是 {@link LightLoadsCard}
     *
     * @return card
     */
    List<? extends ResourcePoolCard> getCustomerNeedCard();

}
