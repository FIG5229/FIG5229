/*
package com.hl.analyze.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hl.analyze.dao.ToolDao;
import com.hl.analyze.entity.bo.BaiDuMapEntityBO;
import com.hl.analyze.entity.po.DistributedPhotovoltaic;
import com.hl.analyze.service.ToolService;
import com.hl.analyze.utils.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

*/
/**
 * @author jason
 * @date 2021/11/11
 *//*


@Service
public class NewToolServiceImpl implements ToolService {

    private static final Logger logger = LoggerFactory.getLogger(NewToolServiceImpl.class);

    @Resource
    private ToolDao toolDao;


    @Override
    public List<String> getAxisInfoByBaidu() {


        List<DistributedPhotovoltaic> allPhotoAxis = toolDao.getAllPhotoAxis();


        List<String> delIdSet = Lists.newLinkedList();

        allPhotoAxis.forEach(item -> {

            Map<String, String> paramMap = Maps.newHashMap();
            paramMap.put("output", "json");

            paramMap.put("location", item.getLongitude() + "," + item.getLatitude());
            paramMap.put("ak", "hcrhqtstCCjK9zESNUpnMbskbVb3drhC");

            BaiDuMapEntityBO baiduAxis = this.getBaiduAxis(paramMap);

//            baiduAxis.get

            logger.debug("完成第{}个", item.getId());

        });


        return null;
    }


    private BaiDuMapEntityBO getBaiduAxis(Map<String, String> paramMap) {
        try {

            // https://api.map.baidu.com/reverse_geocoding/v3/?ak=您的ak&output=json&coordtype=wgs84ll&location=31.225696563611,121.49884033194
            */
/*String response = HttpClientUtil.doGet("http://api.map.baidu.com/geocoder", paramMap);
            Map<String, Object> rspMap = (Map<String, Object>) JSON.parse(response);
            Map<String, Object> dataMap = (Map<String, Object>) rspMap.get("result");
            BaiDuMapEntityBO baiDuMapEntityBO = ((JSONObject) dataMap.get("addressComponent")).toJavaObject(BaiDuMapEntityBO.class);
            if (null == baiDuMapEntityBO || null == baiDuMapEntityBO.getCity()) {
                getBaiduAxis(paramMap);
            }*//*

            String response = HttpClientUtil.doGet("https://api.map.baidu.com/reverse_geocoding/v3/", paramMap);
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
*/
