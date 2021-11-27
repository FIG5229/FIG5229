package com.hl.analyze.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.hl.analyze.dto.JkjcListDTO;
import com.hl.analyze.entity.po.EsWellMonthDataPO;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author:
 * @DateL 2021/10/25 15:06
 * @ClassName: ExcelUtils
 * @return
 **/
public class ExcelUtils {
    private static Logger mLogger = LoggerFactory.getLogger(ExcelUtils.class);
    /**
     * 利用JAVA的反射机制，将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上<br>
     * 用于单个sheet
     *
     * @param <T>
     * @param headers 表格属性列名数组
     * @param dataset 需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
     *                javabean属性的数据类型有基本数据类型及String,Date,String[],Double[]
     * @param filePath  excel文件输出路径
     * @param pattern 如果有时间数据，设定输出格式。默认为"yyyy-MM-dd"
     */
    public static <T> void exportExcel(String[] headers, Collection<T> dataset, String filePath, String pattern) {
        try {
            // 声明一个工作薄
            Workbook workbook = getExportWorkbook(filePath);
            if (workbook != null) {
                // 生成一个表格
                Sheet sheet = workbook.createSheet();

                write2Sheet((HSSFWorkbook) workbook,"sheet0", headers, dataset, pattern);
                OutputStream out = new FileOutputStream(new File(filePath));
                workbook.write(out);
                out.close();
            }
        } catch (IOException e) {
            mLogger.error(e.toString(), e);
        }
    }
    /**
     * 根据excel文件输出路径来获取对应的workbook
     * @param filePath
     * @return
     * @throws IOException
     */
    public static Workbook getExportWorkbook(String filePath) throws IOException {
        Workbook wb = null;
        File file = new File(filePath);

        String fileName = file.getName();
        String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1); // 获取文件后缀

        if ("xls".equals(extension)) { // for 少量数据
            wb = new HSSFWorkbook();
        } else if ("xlsx".equals(extension)) { // for 大量数据
            wb = new SXSSFWorkbook(5000); // 定义内存里一次只留5000行
        } else {
            throw new IOException("不支持的文件类型");
        }
        return wb;
    }


    /**
     * 每个sheet的写入
     * @param workbook   工作薄
     * @param sheetName   sheet名称
     * @param headers 表头
     * @param dataset 数据集合 map、list、object[]、dtoBean
     * @param pattern 日期格式
     */
    public static <T> void write2Sheet(HSSFWorkbook workbook,String sheetName, String[] headers, Collection<T> dataset, String pattern) {
        // sheet样式
        HSSFSheet sheet = workbook.createSheet(sheetName);
        sheet.setDefaultColumnWidth(20);
        // cell样式
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFillForegroundColor((short)23);
        style.setFillPattern(FillPatternType.BIG_SPOTS);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.LEFT);
        // font样式
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontName("宋体");
        font.setColor((short)9);
        font.setFontHeightInPoints((short)11);
        style.setFont(font);

        HSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor((short)9);
        style.setFillPattern(FillPatternType.BIG_SPOTS);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.GENERAL);
        style2.setVerticalAlignment(VerticalAlignment.TOP);
        HSSFFont font2 = workbook.createFont();
        font2.setBold(false);
        style2.setFont(font2);

        // 产生表格标题行
        Row row = sheet.createRow(0);
        for (int i = 0; i < headers.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(style);
            cell.setCellValue(new HSSFRichTextString(headers[i]));
        }
        // 遍历集合数据，产生数据行
        Iterator<T> it = dataset.iterator();
        int index = 0;
        while (it.hasNext()) {
            index++;
            row = sheet.createRow(index);
            T t = (T) it.next();
            if (t instanceof Map) { // row data is map
                @SuppressWarnings("unchecked")
                Map<String, Object> map = (Map<String, Object>) t;
                int cellNum = 0;
                for (String k : headers) {
                    if (map.containsKey(k) == false) {
                        mLogger.error("Map 中 不存在 key [" + k + "]");
                        continue;
                    }
                    Cell cell = row.createCell(cellNum);
                    Object value = map.get(k);
                    if (value == null) {
                        cell.setCellValue(StringUtils.EMPTY);
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                    cellNum++;
                }
            } else if (t instanceof Object[]) { // row data is Object[]
                Object[] tObjArr = (Object[]) t;
                for (int i = 0; i < tObjArr.length; i++) {
                    Cell cell = row.createCell(i);
                    Object value = tObjArr[i];
                    if (value == null) {
                        cell.setCellValue(StringUtils.EMPTY);
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                }
            } else if (t instanceof List<?>) { // row data is List
                List<?> rowData = (List<?>) t;
                for (int i = 0; i < rowData.size(); i++) {
                    Cell cell = row.createCell(i);
                    Object value = rowData.get(i);
                    if (value == null) {
                        cell.setCellValue(StringUtils.EMPTY);
                    } else {
                        cell.setCellValue(String.valueOf(value));
                    }
                }
            } else { // row data is vo
                // 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
                Field[] fields = t.getClass().getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Cell cell = row.createCell(i);
                    Field field = fields[i];
                    String fieldName = field.getName();
                    String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

                    try {
                        Class<?> tClazz = t.getClass();
                        Method getMethod = tClazz.getMethod(getMethodName, new Class[] {});
                        Object value = getMethod.invoke(t, new Object[] {});
                        String textValue = null;
                        if (value instanceof Integer) {
                            int intValue = (Integer) value;
                            cell.setCellValue(intValue);
                        } else if (value instanceof Float) {
                            float fValue = (Float) value;
                            cell.setCellValue(fValue);
                        } else if (value instanceof Double) {
                            double dValue = (Double) value;
                            cell.setCellValue(dValue);
                        } else if (value instanceof Long) {
                            long longValue = (Long) value;
                            cell.setCellValue(longValue);
                        } else if (value instanceof Boolean) {
                            boolean bValue = (Boolean) value;
                            cell.setCellValue(bValue);
                        } else if (value instanceof Date) {
                            Date date = (Date) value;
                            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                            textValue = sdf.format(date);
                        } else {
                            // 其它数据类型都当作字符串简单处理
                            textValue = value.toString();
                        }
                        if (textValue != null) {
                            // HSSFRichTextString richString = new
                            // HSSFRichTextString(textValue);
                            cell.setCellValue(textValue);
                        } else {
                            cell.setCellValue(StringUtils.EMPTY);
                        }
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        // 设定自动宽度
        for (int i = 0; i < headers.length; i++) {
            sheet.autoSizeColumn(i);
        }
    }


    @SneakyThrows
    public static <T extends JkjcListDTO> void exportExcel(List<T> list, String fileName, HttpServletResponse response) {
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), JkjcListDTO.class, list);

        response.setHeader("Content-Disposition", "attachment;filename*= UTF-8''"+ URLEncoder.encode(fileName,"UTF-8"));
        response.setHeader("content-Type", "application/vnd.ms-excel;charset=utf-8");
        workbook.write(response.getOutputStream());
    }
}