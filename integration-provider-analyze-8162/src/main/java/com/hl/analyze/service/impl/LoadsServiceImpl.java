package com.hl.analyze.service.impl;

import com.hl.analyze.entity.mapper.LoadsEntityMapper;
import com.hl.analyze.entity.po.NoLoad;
import com.hl.analyze.entity.vo.LoadsVO;
import com.hl.analyze.query.LoadsQuery;
import com.hl.analyze.utils.ListMappingUtil;
import com.integration.utils.MyPagUtile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hl.analyze.entity.po.Loads;
import com.hl.analyze.dao.LoadsMapper;
import com.hl.analyze.service.LoadsService;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LoadsServiceImpl implements LoadsService {

    private final LoadsMapper loadsMapper;
    private static final LoadsEntityMapper MAPPER = LoadsEntityMapper.MAPPER;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return loadsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Loads record) {
        return loadsMapper.insert(record);
    }

    @Override
    public int insertSelective(Loads record) {
        return loadsMapper.insertSelective(record);
    }

    @Override
    public Loads selectByPrimaryKey(Integer id) {
        return loadsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Loads record) {
        return loadsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Loads record) {
        return loadsMapper.updateByPrimaryKey(record);
    }


    @Override
    public List<LoadsVO> getList(LoadsQuery query) {
        MyPagUtile.startPage();
        final List<Loads> pagedList = loadsMapper.selectLoads(query);
        return ListMappingUtil.copyList(pagedList, MAPPER::toVo);
    }

    @Override
    public LoadsVO getById(Integer id) {
        final Loads loads = loadsMapper.selectByPrimaryKey(id);
        return MAPPER.toVo(loads);
    }
}
