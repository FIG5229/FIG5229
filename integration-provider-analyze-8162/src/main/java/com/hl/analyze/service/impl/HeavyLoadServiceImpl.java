package com.hl.analyze.service.impl;

import com.hl.analyze.entity.mapper.LoadsEntityMapper;
import com.hl.analyze.entity.po.HeavyLoad;
import com.hl.analyze.entity.vo.HeavyLoadVO;
import com.hl.analyze.query.HeavyOverloadListQuery;
import com.hl.analyze.utils.ListMappingUtil;
import com.integration.utils.MyPagUtile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl.analyze.dao.HeavyLoadDao;
import com.hl.analyze.service.HeavyLoadService;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HeavyLoadServiceImpl implements HeavyLoadService {
    private final HeavyLoadDao heavyLoadDao;
    private static final LoadsEntityMapper MAPPER = LoadsEntityMapper.MAPPER;

    @Override
    public List<HeavyLoadVO> getList(HeavyOverloadListQuery query) {
        MyPagUtile.startPage();
        List<HeavyLoad> pagedList = heavyLoadDao.selectList(query);
        return ListMappingUtil.copyList(pagedList, MAPPER::toVo);
    }

    @Override
    public HeavyLoadVO getById(Integer id) {
        final HeavyLoad heavyLoad = heavyLoadDao.selectByPrimaryKey(id);
        return MAPPER.toVo(heavyLoad);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return heavyLoadDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HeavyLoad record) {
        return heavyLoadDao.insert(record);
    }

    @Override
    public int insertSelective(HeavyLoad record) {
        return heavyLoadDao.insertSelective(record);
    }

    @Override
    public HeavyLoad selectByPrimaryKey(Integer id) {
        return heavyLoadDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HeavyLoad record) {
        return heavyLoadDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HeavyLoad record) {
        return heavyLoadDao.updateByPrimaryKey(record);
    }

}



