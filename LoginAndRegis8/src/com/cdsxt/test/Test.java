package com.cdsxt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "root");
			Statement st=conn.createStatement();
			for(int i=1;i<=100;i++){
				String sql="insert into employee(name,age,email,gender) values('员工"+i+"',"+Math.random()*60+",'888888@qq.com',0)";
				st.addBatch(sql);
			}
			st.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
