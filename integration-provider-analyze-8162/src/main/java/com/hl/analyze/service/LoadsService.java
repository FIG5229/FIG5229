package com.hl.analyze.service;

import com.hl.analyze.entity.po.Loads;
import com.hl.analyze.entity.vo.LoadsVO;
import com.hl.analyze.entity.vo.NoLoadVO;
import com.hl.analyze.query.LoadsQuery;
import com.hl.analyze.query.NoLoadListQuery;

import java.util.List;

/**
 * 生成代码
 */
public interface LoadsService{
    int deleteByPrimaryKey(Integer id);

    int insert(Loads record);

    int insertSelective(Loads record);

    Loads selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Loads record);

    int updateByPrimaryKey(Loads record);



    /**
     * 根据条件分页查询数据
     *
     * @param query 查询条件
     * @return 分页数据
     */
    List<LoadsVO> getList(LoadsQuery query);

    /**
     * 根据ID查询对应数据
     *
     * @param id id
     * @return vo
     */
    LoadsVO getById(Integer id);
}
