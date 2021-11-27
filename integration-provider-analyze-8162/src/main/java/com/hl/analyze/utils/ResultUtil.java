package com.hl.analyze.utils;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hl.analyze.entity.PageResult;
import org.apache.http.HttpStatus;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

/**
 * 返回工具类补充类
 *
 * @author XuPengan
 * @since 2020/8/25 3:14 下午
 */

public class ResultUtil {

    /**
     * 返回分页数据
     *
     * @param page
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> success(Page<T> page) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setTotalPage(page.getPages());
        pageResult.setCurrentPage(page.getPageNum());
        pageResult.setReturnBoolean(Boolean.TRUE);
        pageResult.setReturnCode(String.valueOf(HttpStatus.SC_OK));
        pageResult.setTotalResult(new Long(page.getTotal()).intValue());
        pageResult.setReturnObject(page.getResult());
        return pageResult;
    }

    public static <T> PageResult<T> successPage(List<T> pageInfo) {
        return success(new PageInfo<>(pageInfo));
    }

    public static <T> PageResult<T> success(PageInfo<T> pageInfo) {
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setTotalPage(pageInfo.getPages());
        pageResult.setTotalResult(new Long(pageInfo.getTotal()).intValue());
        pageResult.setCurrentPage(pageInfo.getPageNum());
        pageResult.setReturnObject(pageInfo.getList());
        pageResult.setReturnCode(String.valueOf(HttpStatus.SC_OK));
        pageResult.setReturnBoolean(true);
        pageResult.setReturnMessage("成功");
        return pageResult;
    }

    /**
     * 成功
     *
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> success() {
        PageResult<T> result = new PageResult<>();
        result.setReturnBoolean(Boolean.TRUE);
        result.setReturnCode(String.valueOf(HttpStatus.SC_OK));
        return result;
    }

    public static <T> PageResult<T> success(Object o) {
        return ResultUtil.success(null, o);
    }

    public static <T> PageResult<T> success(String message, Object o) {
        return ResultUtil.success(HttpStatus.SC_OK, message, o);
    }

    public static <T> PageResult<T> success(int code, String message, Object o) {
        PageResult<T> result = new PageResult<>();
        result.setReturnBoolean(Boolean.TRUE);
        result.setReturnCode(String.valueOf(code));
        result.setReturnMessage(message);
        result.setReturnObject(o);
        return result;
    }


    /**
     * 失败
     *
     * @param <T>
     * @return
     */
    public static <T> PageResult<T> error() {
        return ResultUtil.error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "系统错误！", null);
    }

    public static <T> PageResult<T> error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static <T> PageResult<T> error(int code, String msg) {
        return error(code, msg, null);
    }

    public static <T> PageResult<T> error(int code, String msg, Object data) {
        PageResult<T> result = new PageResult<>();
        result.setReturnObject(data);
        result.setReturnBoolean(Boolean.FALSE);
        result.setReturnCode(String.valueOf(code));
        result.setReturnMessage(msg);
        return result;
    }

    /**
     * 发送错误信息
     *
     * @param bindingResult 信息绑定
     * @return
     */
    public static <T> PageResult<T> error(BindingResult bindingResult) {
        String errorMessage = Optional.ofNullable(bindingResult.getFieldError())
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .orElse("参数校验失败");
        return error(HttpStatus.SC_BAD_REQUEST, errorMessage);
    }

}
