package com.hl.analyze.service.impl;

import com.hl.analyze.entity.mapper.LoadsEntityMapper;
import com.hl.analyze.entity.po.LightLoad;
import com.hl.analyze.entity.vo.LightLoadVO;
import com.hl.analyze.query.LightLoadListQuery;
import com.hl.analyze.utils.ListMappingUtil;
import com.integration.utils.MyPagUtile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hl.analyze.dao.LightLoadDao;
import com.hl.analyze.service.LightLoadService;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LightLoadServiceImpl implements LightLoadService {
    private final LightLoadDao lightLoadDao;
    private static final LoadsEntityMapper MAPPER = LoadsEntityMapper.MAPPER;

    @Override
    public List<LightLoadVO> getList(LightLoadListQuery query) {
        MyPagUtile.startPage();
        List<LightLoad> pagedList = lightLoadDao.selectList(query);
        return ListMappingUtil.copyList(pagedList, MAPPER::toVo);
    }

    @Override
    public LightLoadVO getById(Integer id) {
        final LightLoad result = lightLoadDao.selectByPrimaryKey(id);
        return MAPPER.toVo(result);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return lightLoadDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LightLoad record) {
        return lightLoadDao.insert(record);
    }

    @Override
    public int insertSelective(LightLoad record) {
        return lightLoadDao.insertSelective(record);
    }

    @Override
    public LightLoad selectByPrimaryKey(Integer id) {
        return lightLoadDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LightLoad record) {
        return lightLoadDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LightLoad record) {
        return lightLoadDao.updateByPrimaryKey(record);
    }

}


