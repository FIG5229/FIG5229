package com.hl.analyze.service;

import com.hl.analyze.entity.po.NoLoad;
import com.hl.analyze.entity.vo.NoLoadVO;
import com.hl.analyze.query.NoLoadListQuery;

import java.util.List;

/**
 * 空载服务接口。
 *
 * @author ForteScarlet
 */
public interface NoLoadService {
    int deleteByPrimaryKey(Integer id);

    int insert(NoLoad record);

    int insertSelective(NoLoad record);

    NoLoad selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NoLoad record);

    int updateByPrimaryKey(NoLoad record);

    /**
     * 根据条件分页查询数据
     *
     * @param query 查询条件
     * @return 分页数据
     */
    List<NoLoadVO> getList(NoLoadListQuery query);

    /**
     * 根据ID查询对应数据
     *
     * @param id id
     * @return vo
     */
    NoLoadVO getById(Integer id);
}


