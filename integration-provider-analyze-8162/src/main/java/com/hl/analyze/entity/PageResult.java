package com.hl.analyze.entity;

import java.io.Serializable;

/**
 * @param <T>
 * @author xupengan
 */
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -2768501249684767697L;

    /**
     * 方法执行是否成功
     */
    private boolean returnBoolean;
    /**
     * 方法执行提示信息
     */
    private String returnMessage;
    /**
     * 返回编码
     */
    private String returnCode;
    /**
     * 方法返回结果
     */
    private Object returnObject;

    /**
     * 分页参数：总页数
     */
    private Integer totalPage;
    /**
     * 分页参数：总条数
     */
    private Integer totalResult;
    /**
     * 分页参数：当前页码
     */
    private Integer currentPage;

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isReturnBoolean() {
        return returnBoolean;
    }

    public void setReturnBoolean(boolean returnBoolean) {
        this.returnBoolean = returnBoolean;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }
}
