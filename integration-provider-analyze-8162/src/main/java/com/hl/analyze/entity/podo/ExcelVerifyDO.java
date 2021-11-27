package com.hl.analyze.entity.podo;

import cn.afterturn.easypoi.handler.inter.IExcelDataHandler;
import cn.afterturn.easypoi.handler.inter.IExcelDataModel;
import cn.afterturn.easypoi.handler.inter.IExcelModel;

import java.util.List;

/**
 * @author pcj
 * @description
 */
public class ExcelVerifyDO implements IExcelModel, IExcelDataModel {

    private int sheetNum;
    private Integer rowNum;
    private String errorMsg;

    private List<String> errorColumnList;

    public String getErrorMessage(String fileName) {
        return fileName + ":" + "第" + rowNum + "行" + errorMsg;
    }

    public int getSheetNum() {
        return sheetNum;
    }

    public void setSheetNum(int sheetNum) {
        this.sheetNum = sheetNum;
    }

    @Override
    public Integer getRowNum() {
        return rowNum;
    }

    @Override
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    public List<String> getErrorColumnList() {
        return errorColumnList;
    }

    public void setErrorColumnList(List<String> errorColumnList) {
        this.errorColumnList = errorColumnList;
    }

    public void addErrorColumnList(String errorColumn) {
        this.errorColumnList.add(errorColumn);
    }


}
