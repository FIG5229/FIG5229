package com.hl.analyze.dao;

import com.hl.analyze.entity.bo.HeatMapBO;
import com.hl.analyze.entity.po.GvCleanEnergyPO;
import com.hl.analyze.entity.po.GvRenewableEnergyPO;
import com.hl.analyze.query.BarGraphQuery;
import com.hl.analyze.query.CommonQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jason
 * @date 2021/11/10
 */
public interface GeneralViewDao {

    GvRenewableEnergyPO getQjnygmData(@Param("commonQuery") CommonQuery commonQuery);

    List<GvRenewableEnergyPO> getQjnygmDetail(@Param("barGraphQuery") BarGraphQuery barGraphQuery);

    /**
     *
     * @param commonQuery
     * @param type
     * @return
     */
    List<GvCleanEnergyPO> getQjnyfaqsByAreaCode(CommonQuery commonQuery, Integer type);

    List<HeatMapBO> getGeoHeatmapData(CommonQuery commonQuery);
}
