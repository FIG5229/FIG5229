package com.hl.analyze.dao;

import com.hl.analyze.entity.po.LightLoad;
import com.hl.analyze.query.LightLoadListQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LightLoadDao {

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
    int insert(LightLoad record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(LightLoad record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    LightLoad selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(LightLoad record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(LightLoad record);

    /**
     * 条件查询数据列表
     *
     * @param query 参数
     * @return list
     */
    List<LightLoad> selectList(LightLoadListQuery query);
}