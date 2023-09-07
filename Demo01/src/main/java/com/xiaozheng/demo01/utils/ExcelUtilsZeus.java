package com.xiaozheng.demo01.utils;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExcelUtilsZeus {
    private static final String XLSX = ".xlsx";
    private static final String XLS = ".xls";
    private static final String ROW_NUM = "rowNum";

    /**
     * 导出excel
     *
     * @param response HttpServletResponse
     * @param list     导出数据集合
     * @param lables   表头数组
     * @param fields   key数组
     * @param title    文件名
     */
    public static void exportTest(HttpServletResponse response, List<Map<String, Object>> list, String[] lables, String[] fields, String title) {
        response.setContentType("application/octet-stream");//告诉浏览器输出内容为流
        String filename = "";
        try {
            filename = new String(title.getBytes("UTF-8"), "ISO_8859_1");
        } catch (UnsupportedEncodingException e1) {
            log.error("报错：",e1.getMessage(),e1);
        }
        response.setHeader("Content-Disposition", "attachment;filename=" + filename + ";" + "filename*=utf-8''" + filename);
        response.setHeader("content-Type","application/vnd.ms-excel");
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        OutputStream os = null;
        SXSSFWorkbook sxssfWorkbook = null;
        try {
            // 获取SXSSFWorkbook
            sxssfWorkbook = new SXSSFWorkbook();
            Sheet sheet = sxssfWorkbook.createSheet("Sheet1");
            // 冻结第一行
            sheet.createFreezePane(0, 1);
            // 创建第一行,作为header表头
            Row header = sheet.createRow(0);
            // 创建单元格样式对象
            CellStyle cellStyle = sxssfWorkbook.createCellStyle();
            cellStyle.setFillForegroundColor(IndexedColors.LIME.getIndex());
            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            // 循环创建header单元格
            for (int cellnum = 0; cellnum < lables.length; cellnum++) {
                Cell cell = header.createCell(cellnum);
                //cell.setCellStyle(getAndSetXSSFCellStyleHeader(sxssfWorkbook));//设置表头单元格样式,根据需要设置
                cell.setCellValue(lables[cellnum]);
                cell.setCellStyle(cellStyle);
                //设置每列固定宽度
                sheet.setColumnWidth(cellnum, 20 * 256);
            }
            // 遍历创建行,导出数据
            for (int rownum = 1; rownum <= list.size(); rownum++) {
                Row row = sheet.createRow(rownum);
                Map<String, Object> map = list.get(rownum - 1);
                // 循环创建单元格
                for (int cellnum = 0; cellnum < fields.length; cellnum++) {
                    Cell cell = row.createCell(cellnum);
                    //cell.setCellStyle(getAndSetXSSFCellStyleOne(sxssfWorkbook));//设置数据行单元格样式,根据需要设置
                    cell.setCellValue(map.get(fields[cellnum]) == null ? "" : map.get(fields[cellnum]).toString());
                }
            }
            //自定义各列宽度
            //setSheet(sheet);
            os = response.getOutputStream();
            sxssfWorkbook.write(os);
        } catch (Exception e) {
            log.error("exportTest报错：",e.getMessage(),e);
        } finally {
            try {
                if (sxssfWorkbook != null) {
                    //处理SXSSFWorkbook导出excel时，产生的临时文件
                    sxssfWorkbook.dispose();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                log.error("exportTest报错：",e.getMessage(),e);
            }
        }
    }
}
