package com.cdsxt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmpInfoDao {
	public boolean addColumn(String ename,String job){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "proot");
			Statement st=conn.createStatement();
			//TODO
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public ResultSet queryTab(){
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "proot");
			Statement st=conn.createStatement();
			String sqlQuery="SELECT * FROM myemp;";
			resultSet = st.executeQuery(sqlQuery);
			System.out.println("resultSet="+resultSet);
			return resultSet;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}