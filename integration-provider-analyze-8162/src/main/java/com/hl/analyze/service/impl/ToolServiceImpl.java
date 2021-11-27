package com.hl.analyze.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.hl.analyze.dao.ToolDao;
import com.hl.analyze.entity.bo.BaiDuMapEntityBO;
import com.hl.analyze.entity.po.DistributedPhotovoltaic;
import com.hl.analyze.service.ToolService;
import com.hl.analyze.utils.AxisUtil;
import com.hl.analyze.utils.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @author jason
 * @date 2021/11/11
 */

@Service
public class ToolServiceImpl implements ToolService {

    private static final Logger logger = LoggerFactory.getLogger(ToolServiceImpl.class);

    private static final Pattern PATTERN = Pattern.compile("^-?\\d+(\\.\\d+)?$");

    @Resource
    private ToolDao toolDao;


    @Override
    public List<Integer> getAxisInfoByBaidu(Integer start, Integer end) {

        List<DistributedPhotovoltaic> allPhotoAxis = toolDao.getAllPhotoAxis(start, end);

        List<Integer> existId = toolDao.getMaxId();

        for (DistributedPhotovoltaic item : allPhotoAxis) {

            double[] doubles;

            try {

                if (existId.contains(item.getId()) ) {
                    continue;
                }
                if (!StringUtils.contains(item.getLatitude(), ".")
                        || !StringUtils.contains(item.getLongitude(), ".") ||
                        StringUtils.split(item.getLongitude(), ".").length > 3 ||
                        StringUtils.split(item.getLatitude(), ".").length > 3 ||
                        !PATTERN.matcher(item.getLatitude()).matches() ||
                        !PATTERN.matcher(item.getLongitude()).matches()) {

                    toolDao.insertDelId(item.getId(), "格式不对");
                    toolDao.insertExistId(item.getId());
                    continue;
                }

                doubles = AxisUtil.gps84_To_bd09(Double.parseDouble(item.getLatitude()), Double.parseDouble(item.getLongitude()));

                Map<String, String> paramMap = Maps.newHashMap();
                paramMap.put("output", "json");

                paramMap.put("location", doubles[0] + "," + doubles[1]);
                paramMap.put("key", "37492c0ee6f924cb5e934fa08c6b1676");
                BaiDuMapEntityBO baiduAxis = this.getBaiduAxis(paramMap);
                if (StringUtils.equals(baiduAxis.getDistrict(), "陵县")) {
                    baiduAxis.setDistrict("陵");
                }

                if (!StringUtils.equals(baiduAxis.getCity(), "德州市")) {
                    toolDao.insertDelId(item.getId(), "地市不对");
                } else if (!StringUtils.contains(item.getGeographicPosition(), baiduAxis.getDistrict())) {
                    logger.info("Id为{}，获取到{}, 实际{}", item.getId(), baiduAxis.getDistrict(), item.getGeographicPosition());
                    toolDao.insertDelId(item.getId(), "县不对");
                }

                toolDao.insertExistId(item.getId());
            } catch (Exception e) {
            }
        }

        return null;
    }


    private BaiDuMapEntityBO getBaiduAxis(Map<String, String> paramMap) {
        try {
            String response = HttpClientUtil.doGet("http://api.map.baidu.com/geocoder", paramMap);
            Map<String, Object> rspMap = (Map<String, Object>) JSON.parse(response);
            Map<String, Object> dataMap = (Map<String, Object>) rspMap.get("result");
            BaiDuMapEntityBO baiDuMapEntityBO = ((JSONObject) dataMap.get("addressComponent")).toJavaObject(BaiDuMapEntityBO.class);
            if (null == baiDuMapEntityBO || null == baiDuMapEntityBO.getCity()) {
                getBaiduAxis(paramMap);
            }
            return baiDuMapEntityBO;
        } catch (Exception e) {
            return getBaiduAxis(paramMap);
        }
    }

}
