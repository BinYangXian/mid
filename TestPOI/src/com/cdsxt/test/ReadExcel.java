package com.cdsxt.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	public static void main(String[] args) throws Exception{
		//可以通过输入流和文件的方式 读取工作簿   都可以使用时   使用文件更好
//		// Use an InputStream, needs more memory
//		Workbook wb = WorkbookFactory.create(new FileInputStream(new File("d:/thirdExcel.xls")));
		// Use a file
		Workbook wb = WorkbookFactory.create(new File("d:/thirdExcel.xls"));
		//可以通过表空间名字读取     也可以同索引读
//		Sheet sheetone=wb.getSheet("sheetone");
		Sheet sheetone=wb.getSheetAt(0);
		//通过表空间 获取行
		Row titleRow=sheetone.getRow(0);
		//获取表名所在的单元格
		Cell titleCell=titleRow.getCell(0);
		//获取值
		String title=titleCell.getStringCellValue();
		System.out.println(title);
		
		//获取表头
		Row headRow=sheetone.getRow(2);
		//获取该行使用了多少列
		short cellNum= headRow.getLastCellNum();
		for(int i=0;i<cellNum;i++){
			Cell headCell=headRow.getCell(i);
			String headVal=headCell.getStringCellValue();
			System.out.println(headVal);
		}
		//读数据
		//获取使用了多少行   注意 这里比实际使用行 少一行
		int rowNum=sheetone.getLastRowNum();
		for(int i=3;i<=rowNum;i++){
			Row dataRow=sheetone.getRow(i);
			int id=(int)dataRow.getCell(0).getNumericCellValue();
			String name=dataRow.getCell(1).getStringCellValue();
			int age=(int)dataRow.getCell(2).getNumericCellValue();
			String email=dataRow.getCell(3).getStringCellValue();
			System.out.println(id+"--"+name+"--"+age+"--"+email);
		}
		
	}
}
