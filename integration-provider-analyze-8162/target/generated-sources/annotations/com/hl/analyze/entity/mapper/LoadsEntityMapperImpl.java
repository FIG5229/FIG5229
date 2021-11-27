package com.hl.analyze.entity.mapper;

import com.hl.analyze.entity.po.HeavyLoad;
import com.hl.analyze.entity.po.LightLoad;
import com.hl.analyze.entity.po.Loads;
import com.hl.analyze.entity.po.NoLoad;
import com.hl.analyze.entity.vo.HeavyLoadCard;
import com.hl.analyze.entity.vo.HeavyLoadVO;
import com.hl.analyze.entity.vo.LightLoadVO;
import com.hl.analyze.entity.vo.LightLoadsCard;
import com.hl.analyze.entity.vo.LoadsVO;
import com.hl.analyze.entity.vo.NoLoadCard;
import com.hl.analyze.entity.vo.NoLoadVO;
import com.hl.analyze.utils.DateUtils;
import java.math.BigDecimal;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-27T16:50:32+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
public class LoadsEntityMapperImpl implements LoadsEntityMapper {

    @Override
    public LoadsVO toVo(Loads loads) {
        if ( loads == null ) {
            return null;
        }

        LoadsVO loadsVO = new LoadsVO();

        loadsVO.setId( loads.getId() );
        loadsVO.setTransformerId( loads.getTransformerId() );
        loadsVO.setTransformerName( loads.getTransformerName() );
        loadsVO.setMaxLoadRate( loads.getMaxLoadRate() );
        loadsVO.setAvgLoadRate( loads.getAvgLoadRate() );
        loadsVO.setCompany( loads.getCompany() );
        loadsVO.setCompanyCode( loads.getCompanyCode() );
        loadsVO.setRatedCapacity( loads.getRatedCapacity() );
        loadsVO.setYear( loads.getYear() );
        loadsVO.setCityCompany( loads.getCityCompany() );
        loadsVO.setCountyCompany( loads.getCountyCompany() );
        loadsVO.setMaxCurrent( loads.getMaxCurrent() );
        loadsVO.setMatchMinCapacity( loads.getMatchMinCapacity() );
        loadsVO.setMatchingMostSuitableCapacity( loads.getMatchingMostSuitableCapacity() );
        loadsVO.setLoadType( loads.getLoadType() );

        loadsVO.setDeviceStatus( loads.deviceStatusToString() );
        loadsVO.setNetworkType( loads.networkTypeToString() );
        loadsVO.setInUseDate( DateUtils.parseDate(loads.getInUseDate()) );

        return loadsVO;
    }

    @Override
    public NoLoadVO toVo(NoLoad noLoad) {
        if ( noLoad == null ) {
            return null;
        }

        NoLoadVO noLoadVO = new NoLoadVO();

        noLoadVO.setId( noLoad.getId() );
        noLoadVO.setCompanyName( noLoad.getCompanyName() );
        noLoadVO.setCompanyCode( noLoad.getCompanyCode() );
        noLoadVO.setReqNumber( noLoad.getReqNumber() );
        noLoadVO.setUsername( noLoad.getUsername() );
        noLoadVO.setAddress( noLoad.getAddress() );
        noLoadVO.setVoltage( noLoad.getVoltage() );
        noLoadVO.setType( noLoad.getType() );
        noLoadVO.setReqCapacity( noLoad.getReqCapacity() );

        noLoadVO.setReqTime( DateUtils.parseDate(noLoad.getReqTime()) );

        return noLoadVO;
    }

    @Override
    public HeavyLoadVO toVo(HeavyLoad heavyLoad) {
        if ( heavyLoad == null ) {
            return null;
        }

        HeavyLoadVO heavyLoadVO = new HeavyLoadVO();

        heavyLoadVO.setId( heavyLoad.getId() );
        heavyLoadVO.setTransformerId( heavyLoad.getTransformerId() );
        heavyLoadVO.setTransformerName( heavyLoad.getTransformerName() );
        heavyLoadVO.setMaxLoadRate( heavyLoad.getMaxLoadRate() );
        heavyLoadVO.setAvgLoadRate( heavyLoad.getAvgLoadRate() );
        heavyLoadVO.setCompany( heavyLoad.getCompany() );
        heavyLoadVO.setCompanyCode( heavyLoad.getCompanyCode() );
        heavyLoadVO.setRatedCapacity( heavyLoad.getRatedCapacity() );
        heavyLoadVO.setYear( heavyLoad.getYear() );
        heavyLoadVO.setCityCompany( heavyLoad.getCityCompany() );
        heavyLoadVO.setCountyCompany( heavyLoad.getCountyCompany() );
        heavyLoadVO.setMaxCurrent( heavyLoad.getMaxCurrent() );
        heavyLoadVO.setMatchMinCapacity( heavyLoad.getMatchMinCapacity() );
        heavyLoadVO.setMatchingMostSuitableCapacity( heavyLoad.getMatchingMostSuitableCapacity() );

        heavyLoadVO.setInUseDate( DateUtils.parseDate(heavyLoad.getInUseDate()) );
        heavyLoadVO.setNetworkType( heavyLoad.networkTypeToString() );
        heavyLoadVO.setDeviceStatus( heavyLoad.deviceStatusToString() );

        return heavyLoadVO;
    }

    @Override
    public LightLoadVO toVo(LightLoad lightLoad) {
        if ( lightLoad == null ) {
            return null;
        }

        LightLoadVO lightLoadVO = new LightLoadVO();

        lightLoadVO.setId( lightLoad.getId() );
        lightLoadVO.setTransformerId( lightLoad.getTransformerId() );
        lightLoadVO.setTransformerName( lightLoad.getTransformerName() );
        lightLoadVO.setMaxLoadRate( lightLoad.getMaxLoadRate() );
        lightLoadVO.setAvgLoadRate( lightLoad.getAvgLoadRate() );
        lightLoadVO.setCompany( lightLoad.getCompany() );
        lightLoadVO.setCompanyCode( lightLoad.getCompanyCode() );
        lightLoadVO.setRatedCapacity( lightLoad.getRatedCapacity() );
        lightLoadVO.setYear( lightLoad.getYear() );
        lightLoadVO.setCountyCompany( lightLoad.getCountyCompany() );
        lightLoadVO.setMaxCurrent( lightLoad.getMaxCurrent() );
        lightLoadVO.setMatchMinCapacity( lightLoad.getMatchMinCapacity() );
        lightLoadVO.setMatchingMostSuitableCapacity( lightLoad.getMatchingMostSuitableCapacity() );
        lightLoadVO.setAccessibleCapacity( lightLoad.getAccessibleCapacity() );

        lightLoadVO.setInUseDate( DateUtils.parseDate(lightLoad.getInUseDate()) );
        lightLoadVO.setNetworkType( lightLoad.networkTypeToString() );
        lightLoadVO.setDeviceStatus( lightLoad.deviceStatusToString() );

        return lightLoadVO;
    }

    @Override
    public HeavyLoadCard toHeavyCard(Loads loads) {
        if ( loads == null ) {
            return null;
        }

        HeavyLoadCard heavyLoadCard = new HeavyLoadCard();

        if ( loads.getId() != null ) {
            heavyLoadCard.setId( loads.getId().longValue() );
        }
        heavyLoadCard.setTransformerName( loads.getTransformerName() );
        heavyLoadCard.setCompany( loads.getCompany() );
        heavyLoadCard.setCompanyCode( loads.getCompanyCode() );
        heavyLoadCard.setTransformerId( loads.getTransformerId() );
        if ( loads.getMaxCurrent() != null ) {
            heavyLoadCard.setMaxCurrent( new BigDecimal( loads.getMaxCurrent() ) );
        }
        if ( loads.getMatchMinCapacity() != null ) {
            heavyLoadCard.setMatchMinCapacity( new BigDecimal( loads.getMatchMinCapacity() ) );
        }

        heavyLoadCard.setType( 0 );

        return heavyLoadCard;
    }

    @Override
    public HeavyLoadCard toLightCard(Loads loads) {
        if ( loads == null ) {
            return null;
        }

        HeavyLoadCard heavyLoadCard = new HeavyLoadCard();

        if ( loads.getId() != null ) {
            heavyLoadCard.setId( loads.getId().longValue() );
        }
        heavyLoadCard.setTransformerName( loads.getTransformerName() );
        heavyLoadCard.setCompany( loads.getCompany() );
        heavyLoadCard.setCompanyCode( loads.getCompanyCode() );
        heavyLoadCard.setTransformerId( loads.getTransformerId() );
        if ( loads.getMaxCurrent() != null ) {
            heavyLoadCard.setMaxCurrent( new BigDecimal( loads.getMaxCurrent() ) );
        }
        if ( loads.getMatchMinCapacity() != null ) {
            heavyLoadCard.setMatchMinCapacity( new BigDecimal( loads.getMatchMinCapacity() ) );
        }

        heavyLoadCard.setType( 1 );

        return heavyLoadCard;
    }

    @Override
    public HeavyLoadCard toHeavyCard(LoadsVO loads) {
        if ( loads == null ) {
            return null;
        }

        HeavyLoadCard heavyLoadCard = new HeavyLoadCard();

        if ( loads.getId() != null ) {
            heavyLoadCard.setId( loads.getId().longValue() );
        }
        heavyLoadCard.setTransformerName( loads.getTransformerName() );
        heavyLoadCard.setCompany( loads.getCompany() );
        heavyLoadCard.setCompanyCode( loads.getCompanyCode() );
        heavyLoadCard.setTransformerId( loads.getTransformerId() );
        if ( loads.getMaxCurrent() != null ) {
            heavyLoadCard.setMaxCurrent( new BigDecimal( loads.getMaxCurrent() ) );
        }
        if ( loads.getMatchMinCapacity() != null ) {
            heavyLoadCard.setMatchMinCapacity( new BigDecimal( loads.getMatchMinCapacity() ) );
        }

        heavyLoadCard.setType( 0 );

        return heavyLoadCard;
    }

    @Override
    public HeavyLoadCard toLightCard(LoadsVO loads) {
        if ( loads == null ) {
            return null;
        }

        HeavyLoadCard heavyLoadCard = new HeavyLoadCard();

        if ( loads.getId() != null ) {
            heavyLoadCard.setId( loads.getId().longValue() );
        }
        heavyLoadCard.setTransformerName( loads.getTransformerName() );
        heavyLoadCard.setCompany( loads.getCompany() );
        heavyLoadCard.setCompanyCode( loads.getCompanyCode() );
        heavyLoadCard.setTransformerId( loads.getTransformerId() );
        if ( loads.getMaxCurrent() != null ) {
            heavyLoadCard.setMaxCurrent( new BigDecimal( loads.getMaxCurrent() ) );
        }
        if ( loads.getMatchMinCapacity() != null ) {
            heavyLoadCard.setMatchMinCapacity( new BigDecimal( loads.getMatchMinCapacity() ) );
        }

        heavyLoadCard.setType( 1 );

        return heavyLoadCard;
    }

    @Override
    public HeavyLoadCard toCard(HeavyLoad overload) {
        if ( overload == null ) {
            return null;
        }

        HeavyLoadCard heavyLoadCard = new HeavyLoadCard();

        if ( overload.getId() != null ) {
            heavyLoadCard.setId( overload.getId().longValue() );
        }
        heavyLoadCard.setTransformerName( overload.getTransformerName() );
        heavyLoadCard.setCompany( overload.getCompany() );
        heavyLoadCard.setCompanyCode( overload.getCompanyCode() );
        heavyLoadCard.setTransformerId( overload.getTransformerId() );
        heavyLoadCard.setMaxCurrent( overload.getMaxCurrent() );
        heavyLoadCard.setMatchMinCapacity( overload.getMatchMinCapacity() );

        heavyLoadCard.setType( 0 );

        return heavyLoadCard;
    }

    @Override
    public HeavyLoadCard toCard(HeavyLoadVO overload) {
        if ( overload == null ) {
            return null;
        }

        HeavyLoadCard heavyLoadCard = new HeavyLoadCard();

        if ( overload.getId() != null ) {
            heavyLoadCard.setId( overload.getId().longValue() );
        }
        heavyLoadCard.setTransformerName( overload.getTransformerName() );
        heavyLoadCard.setCompany( overload.getCompany() );
        heavyLoadCard.setCompanyCode( overload.getCompanyCode() );
        heavyLoadCard.setTransformerId( overload.getTransformerId() );
        heavyLoadCard.setMaxCurrent( overload.getMaxCurrent() );
        heavyLoadCard.setMatchMinCapacity( overload.getMatchMinCapacity() );

        heavyLoadCard.setType( 0 );

        return heavyLoadCard;
    }

    @Override
    public LightLoadsCard toCard(LightLoad lightLoad) {
        if ( lightLoad == null ) {
            return null;
        }

        LightLoadsCard lightLoadsCard = new LightLoadsCard();

        if ( lightLoad.getId() != null ) {
            lightLoadsCard.setId( lightLoad.getId().longValue() );
        }
        lightLoadsCard.setTransformerName( lightLoad.getTransformerName() );
        lightLoadsCard.setCompany( lightLoad.getCompany() );
        lightLoadsCard.setCompanyCode( lightLoad.getCompanyCode() );
        lightLoadsCard.setTransformerId( lightLoad.getTransformerId() );
        lightLoadsCard.setMaxCurrent( lightLoad.getMaxCurrent() );
        lightLoadsCard.setMatchMinCapacity( lightLoad.getMatchMinCapacity() );

        lightLoadsCard.setType( 1 );

        return lightLoadsCard;
    }

    @Override
    public LightLoadsCard toCard(LightLoadVO lightNoLoad) {
        if ( lightNoLoad == null ) {
            return null;
        }

        LightLoadsCard lightLoadsCard = new LightLoadsCard();

        if ( lightNoLoad.getId() != null ) {
            lightLoadsCard.setId( lightNoLoad.getId().longValue() );
        }
        lightLoadsCard.setTransformerName( lightNoLoad.getTransformerName() );
        lightLoadsCard.setCompany( lightNoLoad.getCompany() );
        lightLoadsCard.setCompanyCode( lightNoLoad.getCompanyCode() );
        lightLoadsCard.setTransformerId( lightNoLoad.getTransformerId() );
        lightLoadsCard.setMaxCurrent( lightNoLoad.getMaxCurrent() );
        lightLoadsCard.setMatchMinCapacity( lightNoLoad.getMatchMinCapacity() );

        lightLoadsCard.setType( 1 );

        return lightLoadsCard;
    }

    @Override
    public NoLoadCard toCard(NoLoad needs) {
        if ( needs == null ) {
            return null;
        }

        NoLoadCard noLoadCard = new NoLoadCard();

        if ( needs.getId() != null ) {
            noLoadCard.setId( needs.getId().longValue() );
        }
        noLoadCard.setCompanyName( needs.getCompanyName() );
        noLoadCard.setCompanyCode( needs.getCompanyCode() );
        noLoadCard.setReqNumber( needs.getReqNumber() );
        noLoadCard.setUsername( needs.getUsername() );
        noLoadCard.setReqCapacity( needs.getReqCapacity() );

        noLoadCard.setType( 0 );

        return noLoadCard;
    }

    @Override
    public NoLoadCard toCard(NoLoadVO needs) {
        if ( needs == null ) {
            return null;
        }

        NoLoadCard noLoadCard = new NoLoadCard();

        if ( needs.getId() != null ) {
            noLoadCard.setId( needs.getId().longValue() );
        }
        noLoadCard.setCompanyName( needs.getCompanyName() );
        noLoadCard.setCompanyCode( needs.getCompanyCode() );
        noLoadCard.setReqNumber( needs.getReqNumber() );
        noLoadCard.setUsername( needs.getUsername() );
        noLoadCard.setReqCapacity( needs.getReqCapacity() );

        noLoadCard.setType( 0 );

        return noLoadCard;
    }
}
