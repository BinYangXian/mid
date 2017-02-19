package com.cdsxt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCChang3 {
	public static void main(String[] args) {
		String uname="xxxxx";
		String pwd="xxxxx";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root","root");
//			Statement st=conn.createStatement();
			//预处理   挖坑    
			String sql="insert into manager(uname,pwd) values(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			//填坑
			ps.setString(1,uname );
			ps.setString(2, pwd);
			
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
