package com.cdsxt.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import com.cdsxt.base.BaseDao;

public class Test {
	public static void main(String[] args) throws Exception {
		List<Manager> managerList=BaseDao.queryList("select * from manager", null, new Manager());
		Workbook wb=POIUtil.getWorkBook(new String[]{"编号=id","用户名=uname","密码=pwd"}, "管理者表", managerList);
		OutputStream out=new FileOutputStream(new File("d:/manager.xls"));
		wb.write(out);
	}
}
