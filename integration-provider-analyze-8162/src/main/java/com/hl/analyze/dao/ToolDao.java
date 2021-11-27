package com.hl.analyze.dao;

import com.hl.analyze.entity.po.DistributedPhotovoltaic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author jason
 * @date 2021/11/11
 */

public interface ToolDao {

    List<DistributedPhotovoltaic> getAllPhotoAxis(@Param("start") Integer start, @Param("end") Integer end);

    List<Integer> getDelId();

    void insertDelId(@Param("id") Integer id, @Param("type") String type);

    List<Integer> getMaxId();

    void insertExistId(Integer id);

}
