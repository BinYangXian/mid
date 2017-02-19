package com.cdsxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DBUtil {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static{
		try {
			//创建properties文件的对象
			Properties properties=new Properties();
			//读哪个文件
			properties.load(DBUtil.class.getResourceAsStream("/db.properties"));
			
			driver=properties.getProperty("driver");
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConn(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			System.out.println("获取数据库连接出错");
			e.printStackTrace();
		}
		return conn;
	}
	
	//关闭资源 
	public static void close(Object...objs){
		if(objs!=null&&objs.length>0){
			try {
				for(Object obj:objs){
					if(obj instanceof Connection){
						((Connection)obj).close();
					}else if(obj instanceof PreparedStatement){
						((PreparedStatement)obj).close();
					}else if(obj instanceof ResultSet){
						((ResultSet)obj).close();
					}
				}
			} catch (Exception e) {
				System.out.println("关闭资源出错");
				e.printStackTrace();
			}
		}
	} 
	public static void main(String[] args) {
		getConn();
	}
}
