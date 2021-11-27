package com.hl.analyze.controller;

import com.hl.analyze.entity.PageResult;
import com.hl.analyze.service.ToolService;
import com.hl.analyze.utils.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author jason
 * @date 2021/11/11
 */

@RestController
@RequestMapping("tool")
public class ToolController {

    @Resource
    private ToolService toolService;

    @RequestMapping("getAxisInfoByBaidu")
    public PageResult<Integer> getAxisInfoByBaidu(Integer start, Integer end) {
        if (true) {
            return null;
        }
        List<Integer> axisInfoByBaidu = this.toolService.getAxisInfoByBaidu(start, end);
        return ResultUtil.success(axisInfoByBaidu);
    }

}
