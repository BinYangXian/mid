package com.cdsxt.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
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

public class POIUtil {
	public static Workbook getWorkBook(String[] headAndFields,String title,List dataList){
		//97版工作簿的创建方式
		Workbook wb = new HSSFWorkbook();
		try {
			//获取list中对象的反射模板
			Class clazz=dataList.get(0).getClass();
			//初始化 表头  和属性的数组
			String[] heads=new String[headAndFields.length];
			String[] fields=new String[headAndFields.length];
			for(int i=0;i<headAndFields.length;i++){
				String[] strs=headAndFields[i].split("=");
				heads[i]=strs[0];
				fields[i]=strs[1];
			}
		    //创建表空间
			Sheet sheet=wb.createSheet("sheet");	 
			//设置表名  (合并单元格)   合并后  行依然索引没有变
			sheet.addMergedRegion(new CellRangeAddress(
		            0, //first row (0-based)
		            1, //last row  (0-based)
		            0, //first column (0-based)
		            heads.length-1 //last column  (0-based)
		    ));
			Row titleRow=sheet.createRow(0);
			Cell titleCell=titleRow.createCell(0);
			//将表名的值设入单元格
			titleCell.setCellValue(title);
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
	        cellStyle.setFont(titleFont);
			titleCell.setCellStyle(cellStyle);
			
			//创建表头
			Row headRow=sheet.createRow(2);
			for(int i=0;i<heads.length;i++){
				headRow.createCell(i).setCellValue(heads[i]);
			}
			
			//给工作簿添加数据
			//反射知识点的应用  注意复习
			for(int i=0;i<dataList.size();i++){
				Row dataRow=sheet.createRow(i+3);
				for(int j=0;j<fields.length;j++){
					//获取属性名  fields[]    [id,name,age,email,phone]
					String fieldName=fields[j];
					//通过属性名获取属性
					Field field=clazz.getDeclaredField(fieldName);
					field.setAccessible(true);
					Object value=field.get(dataList.get(i));
					field.setAccessible(false);
					dataRow.createCell(j).setCellValue(value==null?"":value.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wb;
	}
}
