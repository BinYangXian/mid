package com.cdsxt.test;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class TestPOI1 {
	public static void main(String[] args) throws Exception{
		//97版工作簿的创建方式
		Workbook wb = new HSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream("d:/firstExcel.xls");
		//07版工作簿的创建方式
//		Workbook wb = new XSSFWorkbook();
//	    FileOutputStream fileOut = new FileOutputStream("d:/secondExcel.xlsx");
	    //创建表空间
		Sheet sheet1=wb.createSheet("sheetone");
		Sheet sheet2=wb.createSheet("sheettwo");
	    
		//创建行
		Row row1=sheet1.createRow(1);
		//创建单元格
		Cell cell=row1.createCell(1);
		//往单元格书写值
		cell.setCellValue("test");
	    //将文件写出去
	    wb.write(fileOut);
	    fileOut.close();
	}
}
