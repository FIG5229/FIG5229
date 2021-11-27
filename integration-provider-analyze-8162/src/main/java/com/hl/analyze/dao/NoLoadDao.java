package com.hl.analyze.dao;

import com.hl.analyze.entity.po.NoLoad;
import com.hl.analyze.query.NoLoadListQuery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoLoadDao {

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
    int insert(NoLoad record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(NoLoad record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    NoLoad selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(NoLoad record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(NoLoad record);
    /**
     * 根据查询条件查询数据列表
     * @param query 查询条件
     * @return list
     */
    List<NoLoad> selectPage(NoLoadListQuery query);
}