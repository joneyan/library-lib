package com.lib.utils;

/**
 * Created by Administrator on 2018-2-2.
 */

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 表格导入数据库
 */
public class ExcelImport {
    private static void importExcel(File file, Map<String, Object> map) {
        List<String> columNames=new ArrayList<String>();

        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String absolutePath = file.getAbsolutePath();
        Workbook workbook = null;
        try {
            if (absolutePath.contains(".xlsx")) {
                workbook = new XSSFWorkbook(is);

            } else if (absolutePath.contains(".xls")) {
                workbook = new HSSFWorkbook(is);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 1; i <= numberOfSheets; i++) {
            Sheet sheet = workbook.getSheet("sheet" + i);
            if (sheet.getRow(0) != null) {
                int rowNum = sheet.getLastRowNum()+1;
                int colsNum = sheet.getRow(0).getPhysicalNumberOfCells();
                for (int j = 0; j < rowNum; j++) {
                    Row row = sheet.getRow(j);
                    HashMap<String, Object> values = new HashMap<String, Object>();
                    if(j==0){
                        dealColumnName(colsNum,columNames,row);
                    }else{
                        dealColumnValue(colsNum,values,row,columNames);
                        map.put(j+"",values);
                    }

                }
            }

        }


    }

    /**
     * 处理表格列头
     * @author yanjing
     * @param colsNum
     * @param columNames
     * @param row
     */
    private static void dealColumnName(Integer colsNum,List<String> columNames,Row row){
        for (int k=0;k<colsNum;k++){

            Cell cell = row.getCell(k);
            String cellValue = "";
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    //如果为时间格式的内容
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        cellValue=sdf.format(HSSFDateUtil.getJavaDate(cell.
                                getNumericCellValue())).toString();
                        break;
                    } else {
                        cellValue = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    cellValue = cell.getCellFormula() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    cellValue = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    cellValue = "非法字符";
                    break;
                default:
                    cellValue = "未知类型";
                    break;
            }

            columNames.add(k,cellValue);
        }
    }

    /**
     * 处理表格内容：将每行和列头相对应
     * @param colsNum 列数
     * @param values 内容
     * @param row 行
     * @param columNames 列头名
     */
    private static void dealColumnValue(Integer colsNum,HashMap<String, Object> values,Row row,List<String> columNames){
        for (int k=0;k<colsNum;k++){

            Cell cell = row.getCell(k);
            String cellValue = "";
            switch (cell.getCellType()) {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    //如果为时间格式的内容
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        //注：format格式 yyyy-MM-dd hh:mm:ss 中小时为12小时制，若要24小时制，则把小h变为H即可，yyyy-MM-dd HH:mm:ss
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        cellValue=sdf.format(HSSFDateUtil.getJavaDate(cell.
                                getNumericCellValue())).toString();
                        break;
                    } else {
                        cellValue = new DecimalFormat("0").format(cell.getNumericCellValue());
                    }
                    break;
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    cellValue = cell.getStringCellValue();
                    break;
                case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                    cellValue = cell.getBooleanCellValue() + "";
                    break;
                case HSSFCell.CELL_TYPE_FORMULA: // 公式
                    cellValue = cell.getCellFormula() + "";
                    break;
                case HSSFCell.CELL_TYPE_BLANK: // 空值
                    cellValue = "";
                    break;
                case HSSFCell.CELL_TYPE_ERROR: // 故障
                    cellValue = "非法字符";
                    break;
                default:
                    cellValue = "未知类型";
                    break;
            }
            values.put(columNames.get(k),cellValue);
        }
    }


}
