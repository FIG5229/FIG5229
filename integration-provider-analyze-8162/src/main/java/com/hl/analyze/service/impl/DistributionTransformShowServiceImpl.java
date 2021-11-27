package com.hl.analyze.service.impl;

import com.github.pagehelper.PageInfo;
import com.hl.analyze.dao.DistributionTransformShowDao;
import com.hl.analyze.service.DistributionTransformShowService;
import com.integration.utils.MyPagUtile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DistributionTransformShowServiceImpl implements DistributionTransformShowService {

    @Autowired
    private DistributionTransformShowDao distributionTransformShowDao;

    @Override
    public PageInfo<?> getDistributionTransformShowList(String unit) {
        MyPagUtile.startPage();
        List<Map<String, Object>> distributionTransformShowList = distributionTransformShowDao.getDistributionTransformShowList(unit);
        PageInfo pageInfo = new PageInfo(distributionTransformShowList);
        return pageInfo;
    }
}



