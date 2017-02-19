package com.cdsxt.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class TestPOI3 {
	public static void main(String[] args) throws Exception{
		List<TestBean> beanList=new ArrayList<TestBean>();
		beanList.add(new TestBean(1, "zhangsan",18 , "zhangsan@qq.com"));
		beanList.add(new TestBean(2, "lisi",28 , "lisi@qq.com"));
		beanList.add(new TestBean(3, "wangwu",15 , "wangwu@qq.com"));
		beanList.add(new TestBean(4, "qianqi", 20, "qianqi@qq.com"));
		//97版工作簿的创建方式
		Workbook wb = new HSSFWorkbook();
		FileOutputStream fileOut = new FileOutputStream("d:/thirdExcel.xls");
	    //创建表空间
		Sheet sheet=wb.createSheet("sheetone");	 
		//设置表名  (合并单元格)   合并后  行依然索引没有变
		sheet.addMergedRegion(new CellRangeAddress(
	            0, //first row (0-based)
	            1, //last row  (0-based)
	            0, //first column (0-based)
	            3  //last column  (0-based)
	    ));
		Row titleRow=sheet.createRow(0);
		Cell titleCell=titleRow.createCell(0);
		titleCell.setCellValue("学生信息表");
		//设置表名的单元格格式  setAlignment  设置水平位置  setVerticalAlignment 设置垂直
		CellStyle cellStyle=wb.createCellStyle();
		//设置位置
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        //设置字体
        Font titleFont=wb.createFont();
        //大小
        titleFont.setFontHeightInPoints((short)27);
        //斜体
        titleFont.setItalic(true);
        cellStyle.setFont(titleFont);
		titleCell.setCellStyle(cellStyle);
		//设置表头
		Row headRow=sheet.createRow(2);
		headRow.createCell(0).setCellValue("编号");
		headRow.createCell(1).setCellValue("姓名");
		headRow.createCell(2).setCellValue("年龄");
		headRow.createCell(3).setCellValue("邮箱");
		for(int i=0;i<beanList.size();i++){
			Row newRow=sheet.createRow(i+3);
			newRow.createCell(0).setCellValue(beanList.get(i).getId());
			newRow.createCell(1).setCellValue(beanList.get(i).getName());
			newRow.createCell(2).setCellValue(beanList.get(i).getAge());
			newRow.createCell(3).setCellValue(beanList.get(i).getEmail());
		}
		
	    //将文件写出去
	    wb.write(fileOut);
	    fileOut.close();
	}
}
