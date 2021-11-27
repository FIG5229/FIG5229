package com.hl.analyze.dao;

import com.hl.analyze.entity.po.HeavyLoad;
import com.hl.analyze.query.HeavyOverloadListQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HeavyLoadDao {

    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(HeavyLoad record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(HeavyLoad record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    HeavyLoad selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(HeavyLoad record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(HeavyLoad record);

    /**
     * 根据条件查询分页数据。
     *
     * @param query 参数
     * @return list
     */
    List<HeavyLoad> selectList(HeavyOverloadListQuery query);
}