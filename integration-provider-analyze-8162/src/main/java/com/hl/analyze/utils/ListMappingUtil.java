package com.hl.analyze.utils;

import com.github.pagehelper.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 分页实体 {@link com.github.pagehelper.Page} 的实体转化.
 *
 * @author ForteScarlet
 */
public final class ListMappingUtil {

    public static <T, R> List<R> copyList(List<T> sourcePage, Function<T, R> mapper) {
        // 不是分页数据
        if (!(sourcePage instanceof Page)) {
            return mapping(sourcePage.stream(), mapper, new ArrayList<>(sourcePage.size()));
        }

        final Page<R> newPage = copyPage((Page<T>) sourcePage);
        return mapping(sourcePage.stream(), mapper, newPage);
    }


    private static <T, R> List<R> mapping(Stream<T> source, Function<T, R> mapper, List<R> baseCollection) {
        return source.map(mapper).collect(Collectors.toCollection(() -> baseCollection));

    }

    /**
     * 赋值page的属性，除了列表元素
     */
    private static <T, R> Page<R> copyPage(Page<T> sourcePage) {
        Page<R> newPage = new Page<>();

        newPage.setOrderBy(sourcePage.getOrderBy());
        newPage.setPageNum(sourcePage.getPageNum());
        newPage.setPageSize(sourcePage.getPageSize());
        newPage.setPages(sourcePage.getPages());
        newPage.setPageSizeZero(sourcePage.getPageSizeZero());
        newPage.setCountSignal(sourcePage.getCountSignal());
        newPage.setCount(sourcePage.isCount());
        newPage.setEndRow(sourcePage.getEndRow());
        newPage.setOrderByOnly(sourcePage.isOrderByOnly());
        newPage.setReasonable(sourcePage.getReasonable());
        newPage.setTotal(sourcePage.getTotal());
        newPage.setStartRow(sourcePage.getStartRow());

        return newPage;
    }


}


