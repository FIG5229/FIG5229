package com.hl.analyze.entity.vo;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

/**
 * 资源池卡片数据。
 * <p>
 * 资源池的卡片数据有两个，
 * 一个是中心点为重过载，周围4个点是轻空载
 * 一个是中心点为用户需求，周围4个点是轻空载
 *
 * @author ForteScarlet
 */
@Data
public class ResourcePoolCard {
    private Long id;

    /**
     * 0: 用户需求 或 重过载
     * 1: 低空载
     */
    private int type;

    private double[] coordinate;
}
