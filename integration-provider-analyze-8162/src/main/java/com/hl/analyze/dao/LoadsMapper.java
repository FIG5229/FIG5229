package com.hl.analyze.dao;

import com.hl.analyze.entity.po.Loads;
import com.hl.analyze.query.LoadsQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LoadsMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Loads record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Loads record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Loads selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Loads record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Loads record);

    /**
     * 根据条件查询Loads列表
     * @param query query
     * @return list
     */
    List<Loads> selectLoads(LoadsQuery query);
}