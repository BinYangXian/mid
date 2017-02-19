package com.cdsxt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cdsxt.po.Employee;
import com.cdsxt.util.DBUtil;

public class EmployeeDao {
	//全表查询所有员工并且装入一个list返回 startRow 起始行  pageRow 每页显示多少条
	public List<Employee> queryEmps(int startRow,int pageRow){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Employee> empList=new ArrayList<Employee>();
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement("select * from employee limit ?,?");
			ps.setInt(1, startRow);
			ps.setInt(2, pageRow);
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				int age=rs.getInt("age");
				int gender=rs.getInt("gender");
				empList.add(new Employee(id, name, age, email, gender));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,ps,conn);
		}
		return empList;
	}
	
	//查询数据条数
	public int queryCount(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try {
			conn=DBUtil.getConn();
			ps=conn.prepareStatement("select count(*) from employee");
			rs=ps.executeQuery();
			while(rs.next()){
				count=rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,ps,conn);
		}
		return count;
	}
}
