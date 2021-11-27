package com.hl.analyze.service.impl;

import com.hl.analyze.dao.NoLoadDao;
import com.hl.analyze.entity.mapper.LoadsEntityMapper;
import com.hl.analyze.entity.po.NoLoad;
import com.hl.analyze.entity.vo.NoLoadVO;
import com.hl.analyze.query.NoLoadListQuery;
import com.hl.analyze.service.NoLoadService;
import com.hl.analyze.utils.ListMappingUtil;
import com.integration.utils.MyPagUtile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NoLoadServiceImpl implements NoLoadService {
    private final NoLoadDao noLoadDao;
    private static final LoadsEntityMapper MAPPER = LoadsEntityMapper.MAPPER;


    @Override
    public List<NoLoadVO> getList(NoLoadListQuery query) {
        MyPagUtile.startPage();
        final List<NoLoad> pagedList = noLoadDao.selectPage(query);
        return ListMappingUtil.copyList(pagedList, MAPPER::toVo);
    }

    @Override
    public NoLoadVO getById(Integer id) {
        final NoLoad needs = noLoadDao.selectByPrimaryKey(id);
        return MAPPER.toVo(needs);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return noLoadDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(NoLoad record) {
        return noLoadDao.insert(record);
    }

    @Override
    public int insertSelective(NoLoad record) {
        return noLoadDao.insertSelective(record);
    }

    @Override
    public NoLoad selectByPrimaryKey(Integer id) {
        return noLoadDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(NoLoad record) {
        return noLoadDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(NoLoad record) {
        return noLoadDao.updateByPrimaryKey(record);
    }

}


