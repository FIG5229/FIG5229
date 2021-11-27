package com.integration.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author hupg
 * @description 数据转换工具类
 * @date 2021/11/5 16:37
 */
public class DataConversionUtils {

    /**
     * 明细数据映射转换
     *
     * @param dataList       源数据
     * @param relationString 映射关系字符串--Map
     * @return java.util.List<java.util.Map < java.lang.String, java.lang.Object>>
     * @author hupg
     * @date 2021/11/5 17:03
     */
    public static List<Map<String, Object>> detailsConversion(List<?> dataList, String relationString) {
        List<Map<String, Object>> returnList = new ArrayList<>();

        String dataJson = JSONArray.toJSONString(dataList);
        List<Map> dataMapList = JSONArray.parseArray(dataJson, Map.class);

        Map<String, String> relation = JSONObject.parseObject(relationString, Map.class);

        dataMapList.forEach(data -> {
            Map<String, Object> map = new HashMap<>();
            returnList.add(map);
            new ArrayList<>(data.keySet()).forEach(key -> {
                if (StringUtils.isNotEmpty(relation.get(key))) {
                    map.put(relation.get(key), data.get(key));
                }
            });
        });
        return returnList;
    }

}
