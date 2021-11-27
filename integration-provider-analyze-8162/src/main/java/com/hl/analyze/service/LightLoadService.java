package com.hl.analyze.service;

import com.hl.analyze.entity.po.LightLoad;
import com.hl.analyze.entity.vo.LightLoadVO;
import com.hl.analyze.query.LightLoadListQuery;

import java.util.List;

public interface LightLoadService {


    int deleteByPrimaryKey(Integer id);

    int insert(LightLoad record);

    int insertSelective(LightLoad record);

    LightLoad selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LightLoad record);

    int updateByPrimaryKey(LightLoad record);

    /**
     * 根据条件查询轻空载数据列表
     *
     * @param query 条件
     * @return list
     */
    List<LightLoadVO> getList(LightLoadListQuery query);


    /**
     * ID查询
     *
     * @param id id
     * @return result
     */
    LightLoadVO getById(Integer id);

}


