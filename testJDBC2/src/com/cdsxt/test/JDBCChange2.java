package com.cdsxt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCChange2 {
	// 测试java对数据库进行增删改
	public static void main(String[] args) throws Exception{
		//第一步加载驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest", "root", "root");
		//获取执行sql语句的对象Statement
		Statement st=conn.createStatement();
		//传入增删改的sql语句
//		st.execute("insert into test(name,time) values('wangwu',SYSDATE())");
//		st.execute("update test set name='lisi' where id=2");
//		st.execute("delete from test where id=1");
		//批处理  效率高于  一条一条的execute
		st.addBatch("insert into test(name,time) values('wangwu',SYSDATE())");
		st.addBatch("update test set name='lisi' where id=2");
		st.addBatch("delete from test where id=1");
		st.executeBatch();
	}
}
