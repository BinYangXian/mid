package com.cdsxt.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cdsxt.po.Employee;
import com.cdsxt.util.DBUtil;

public class Test {
	public static void main(String[] args) {
		//插入300条用于分页的测试数据
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement("insert into employee(name,age,gender,email) values(?,?,?,?)");
			for(int i=1;i<=300;i++){
				ps.setString(1, "测试"+i);
				ps.setInt(2, 30);
				ps.setInt(3, 1);
				ps.setString(4, "9527@qq.com");
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(ps,conn);
		}
	}
}
