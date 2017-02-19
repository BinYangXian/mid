package com.cdsxt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class JDBCQuery {
	//测试JDBC的查询操作
	public static void main(String[] args) throws Exception{
		//第一步加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
		//获取执行sql语句的对象
		Statement st=conn.createStatement();
		//获取结果集对象ResultSet
		ResultSet rs=st.executeQuery("select * from test");
		//rs.next 迭代结果集     没进去一次  表示有一条数据
		while(rs.next()){
			// 第一种  通过第几个字段去取值
//			Date time=rs.getDate(3);
//			int id=rs.getInt(1);
//			String name=rs.getString(2);
			
			// 第二种  通过字段的名字去取值
			int id=rs.getInt("id");
			String name=rs.getString("name");
			Date time=rs.getDate(3);
			System.out.println("id:"+id+" name:"+name+" time:"+time);
		}
	}
}
