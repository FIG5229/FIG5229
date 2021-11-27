package com.hl.analyze.entity.mapper;

import com.hl.analyze.entity.po.Loads;
import com.hl.analyze.entity.po.NoLoad;
import com.hl.analyze.entity.po.HeavyLoad;
import com.hl.analyze.entity.po.LightLoad;
import com.hl.analyze.entity.vo.*;
import com.hl.analyze.utils.DateUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

/**
 *
 * 用户需求、重过载、轻空载相关实体转化。
 *
 * @author ForteScarlet
 */
@Mapper(
        imports = DateUtils.class
)
public interface LoadsEntityMapper {
    LoadsEntityMapper MAPPER = Mappers.getMapper(LoadsEntityMapper.class);

    @Mapping(target = "deviceStatus", expression = "java(loads.deviceStatusToString())")
    @Mapping(target = "networkType", expression = "java(loads.networkTypeToString())")
    @Mapping(target = "inUseDate", expression = "java(DateUtils.parseDate(loads.getInUseDate()))")
    LoadsVO toVo(Loads loads);




    @Mapping(target = "reqTime", expression = "java(DateUtils.parseDate(noLoad.getReqTime()))")
    NoLoadVO toVo(NoLoad noLoad);

    @Mapping(target = "inUseDate", expression = "java(DateUtils.parseDate(heavyLoad.getInUseDate()))")
    @Mapping(target = "networkType", expression = "java(heavyLoad.networkTypeToString())")
    @Mapping(target = "deviceStatus", expression = "java(heavyLoad.deviceStatusToString())")
    HeavyLoadVO toVo(HeavyLoad heavyLoad);

    @Mapping(target = "inUseDate", expression = "java(DateUtils.parseDate(lightLoad.getInUseDate()))")
    @Mapping(target = "networkType", expression = "java(lightLoad.networkTypeToString())")
    @Mapping(target = "deviceStatus", expression = "java(lightLoad.deviceStatusToString())")
    LightLoadVO toVo(LightLoad lightLoad);


    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(0)")
    HeavyLoadCard toHeavyCard(Loads loads);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(1)")
    HeavyLoadCard toLightCard(Loads loads);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(0)")
    HeavyLoadCard toHeavyCard(LoadsVO loads);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(1)")
    HeavyLoadCard toLightCard(LoadsVO loads);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(0)")
    HeavyLoadCard toCard(HeavyLoad overload);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(0)")
    HeavyLoadCard toCard(HeavyLoadVO overload);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(1)")
    LightLoadsCard toCard(LightLoad lightLoad);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(1)")
    LightLoadsCard toCard(LightLoadVO lightNoLoad);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(0)")
    NoLoadCard toCard(NoLoad needs);

    @Mapping(target = "coordinate", ignore = true)
    @Mapping(target = "type", expression = "java(0)")
    NoLoadCard toCard(NoLoadVO needs);


}
