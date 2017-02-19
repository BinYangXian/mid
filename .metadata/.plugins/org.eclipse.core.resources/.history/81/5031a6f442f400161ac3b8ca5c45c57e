package com.cdsxt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ManagerDao {

	//验证用户名是否存在  存在则为true  不存在则为false
	public boolean valiUname(String uname){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "root");
			Statement st=conn.createStatement();
			//select * from manager where uname='zhangsan';
			String sql="select * from manager where uname='"+uname+"'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//往数据库中添加管理员
	public void managerRegis(String uname,String pwd){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "root");
			Statement st=conn.createStatement();
			String sql="insert into manager(uname,pwd) values('"+uname+"','"+pwd+"')" ;
			st.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//管理员的登陆
	public boolean managerLogin(String uname,String pwd){
		int count=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "root");
			Statement st=conn.createStatement();
			
			String sql="select count(*) from manager where uname='"+uname+"' and pwd='"+pwd+"'";
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count==0?false:true;
	}
}
