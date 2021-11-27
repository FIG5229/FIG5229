package com.hl.analyze.utils;

import java.util.UUID;

/**
 * @description uuid生成工具
 * @author xupengan
 * @date 2020/10/20
 */
public class UUIDGenerate {

    /**
     * 生成UUID
     */
    public static String getUUID() {
        String s = UUID.randomUUID().toString();
        s = s.replace("-", "");
        return s;
    }

}
