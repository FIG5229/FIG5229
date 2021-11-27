package com.hl.analyze.service.impl;

import com.hl.analyze.config.ResourcePoolCardProperties;
import com.hl.analyze.entity.mapper.LoadsEntityMapper;
import com.hl.analyze.entity.po.Loads;
import com.hl.analyze.entity.vo.*;
import com.hl.analyze.query.LoadsQuery;
import com.hl.analyze.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ForteScarlet
 */
@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResourcePoolServiceImpl implements ResourcePoolService {

    private final ResourcePoolCardProperties properties;

    // private final HeavyLoadService heavyLoadService;
    // private final LightLoadService lightLoadService;
    // private final NoLoadService noLoadService;

    private final LoadsService loadsService;

    private static final LoadsEntityMapper MAPPER = LoadsEntityMapper.MAPPER;


    @Override
    public List<? extends ResourcePoolCard> getHeavyOverloadCard() {
        final ResourcePoolCardProperties.ResourcePoolCardProperty property = properties.getHeavyLoad();
        List<ResourcePoolCard> result = new ArrayList<>(property.getLightLoads().size() + 1);
        // 变压器ID
        final String center = property.getCenter();
        final Map<String, Double[]> coordinates = properties.getCoordinates();
        if (!StringUtils.isEmpty(center)) {
            // 查询过载数据
            final LoadsQuery loadsQuery = new LoadsQuery();
            loadsQuery.setLoadType(Loads.Type.HEAVY.code);
            loadsQuery.setTransformerId(center);

            // 理论上只可能是0-1条数据
            final List<LoadsVO> list = loadsService.getList(loadsQuery);

            if (!CollectionUtils.isEmpty(list)) {
                if (list.size() > 1) {
                    log.warn("查询数据多于1. transformerId: {}", center);
                }
                // 如果是空，即没查到，暂不做处理。
                // 此处，有数据就设置，没有暂时不管
                final HeavyLoadCard card = MAPPER.toHeavyCard(list.get(0));
                final Double[] coordinate = coordinates.get(center);
                if (coordinate != null && coordinate.length >= 2) {
                    card.setCoordinate(new double[]{coordinate[0], coordinate[1]});
                }
                result.add(card);
            }
        }


        // 查询低空载
//        final List<LightLoadsCard> lightLoadsCards = lightLoadToCardList(property.getLightLoads(), coordinates);

        // 根据配置排序
        final Map<String, LightLoadsCard> lightLoadsCards = lightLoadToCardList(property.getLightLoads(), coordinates).stream()
                .collect(Collectors.toMap(LightLoadsCard::getTransformerId, value -> value));
        List<LightLoadsCard> sortList = new ArrayList<>();
        property.getLightLoads().forEach(item -> sortList.add(lightLoadsCards.get(item)));

        result.addAll(sortList);
        return result;
    }

    /**
     * 已无效接口
     *
     * @return card list
     */
    @Deprecated
    @Override
    public List<? extends ResourcePoolCard> getCustomerNeedCard() {
        return getHeavyOverloadCard();
    }

    // @Override
    // public List<? extends ResourcePoolCard> getCustomerNeedCard() {
    //     final ResourcePoolCardProperties.ResourcePoolCardProperty property = properties.getCustomerNeeds();
    //     final List<ResourcePoolCard> result = new ArrayList<>(property.getNoLoads().size() + 1);
    //     // 申请ID
    //     final String center = property.getCenter();
    //     final Map<String, Double[]> coordinates = properties.getCoordinates();
    //     if (!StringUtils.isEmpty(center)) {
    //         final NoLoadListQuery query = new NoLoadListQuery();
    //         query.setReqNumber(center);
    //         // 理论上只会有0-1条数据。
    //         final List<NoLoadVO> list = noLoadService.getList(query);
    //
    //         if (!CollectionUtils.isEmpty(list)) {
    //             if (list.size() > 1) {
    //                 log.warn("查询数据多于1. reqNumber: {}", center);
    //             }
    //             // 如果是空，即没查到，暂不做处理。
    //             // 此处，有数据就设置，没有暂时不管
    //             final NoLoadCard card = MAPPER.toCard(list.get(0));
    //             final Double[] coordinate = coordinates.get(center);
    //             if (coordinate != null && coordinate.length >= 2) {
    //                 card.setCoordinate(new double[]{coordinate[0], coordinate[1]});
    //             }
    //             result.add(card);
    //         }
    //     }
    //
    //
    //     // 查询低空载
    //     final List<LightLoadsCard> lightLoadsCards = lightLoadToCardList(property, coordinates);
    //     result.addAll(lightLoadsCards);
    //     return result;
    // }


    private List<LightLoadsCard> lightLoadToCardList(List<String> noLoads, Map<String, Double[]> coordinates) {
        //final List<String> noLoads = property.getNoLoads();
        if (!CollectionUtils.isEmpty(noLoads)) {
            final LoadsQuery query = new LoadsQuery();
            query.setLoadType(Loads.Type.LIGHT.code);
            query.setTransformerIdList(noLoads);
            return loadsService.getList(query).stream().map(c -> {
                final String transformerId = c.getTransformerId();
                final Double[] coordinate = coordinates.get(transformerId);
                final LightLoadsCard card = MAPPER.toLightCard(c);
                if (coordinate != null && coordinate.length >= 2) {
                    card.setCoordinate(new double[]{coordinate[0], coordinate[1]});
                }
                return card;
            }).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
}
