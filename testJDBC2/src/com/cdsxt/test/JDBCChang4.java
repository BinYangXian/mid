package com.cdsxt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.cdsxt.util.DBUtil;

public class JDBCChang4 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConn();
			//预处理   挖坑    
			String sql="insert into manager(uname,pwd) values(?,?)";
			ps=conn.prepareStatement(sql);
			/*ps.setString(1, "aaa");
			ps.setString(2, "aaa");
			ps.execute();
			ps.setString(1, "bbb");
			ps.setString(2, "bbb");
			ps.execute();*/
			ps.setString(1, "ccc");
			ps.setString(2, "ccc");
			ps.addBatch();
			ps.setString(1, "ddd");
			ps.setString(2, "ddd");
			ps.addBatch();
			ps.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
