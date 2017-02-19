package com.cdsxt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cdsxt.util.DBUtil;

public class JDBCQuery2 {
	//基于PreparedStatement 的查询
	public static void main(String[] args) {
		int id=10;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			conn=DBUtil.getConn();
			//预处理   挖坑    
			String sql="select * from manager where id=?";
			ps=conn.prepareStatement(sql);
			//填坑
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				String uname=rs.getString("uname");
				String pwd=rs.getString(3);
				System.out.println(uname+"--"+pwd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,ps,conn);
		}
	}
}
