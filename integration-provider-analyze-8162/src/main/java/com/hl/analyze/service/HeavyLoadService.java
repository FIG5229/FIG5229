package com.hl.analyze.service;

import com.hl.analyze.entity.po.HeavyLoad;
import com.hl.analyze.entity.vo.HeavyLoadVO;
import com.hl.analyze.query.HeavyOverloadListQuery;

import java.util.List;

/**
 * @author ForteScarlet
 */
public interface HeavyLoadService {
    int deleteByPrimaryKey(Integer id);

    int insert(HeavyLoad record);

    int insertSelective(HeavyLoad record);

    HeavyLoad selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HeavyLoad record);

    int updateByPrimaryKey(HeavyLoad record);

    /**
     * 根据查询条件查询重过载数据列表
     *
     * @param query 条件
     * @return 分页列表
     */
    List<HeavyLoadVO> getList(HeavyOverloadListQuery query);

    /**
     * ID查询
     *
     * @param id id
     * @return result
     */
    HeavyLoadVO getById(Integer id);

}



