package com.cdsxt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cdsxt.base.BaseDao;
import com.cdsxt.po.Employee;
import com.cdsxt.util.DBUtil;
import com.cdsxt.vo.AgeArea;

public class EmployeeDao {
	//全表查询所有员工并且装入一个list返回
	public List<Employee> queryEmps(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Employee> empList=new ArrayList<Employee>();
		try {
			conn=DBUtil.getConn();
			String sql="select * from employee";
			ps=conn.prepareStatement(sql);
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
	
	//添加员工
	public void addEmp(String name,String email,int age,int gender){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConn();
			String sql="insert into employee(name,age,gender,email) values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setInt(3, gender);
			ps.setString(4, email);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(ps,conn);
		}
	}
	
	//根据id删除员工
	public void delEmp(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConn();
			String sql="delete from employee where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(ps,conn);
		}
	}
	//根据id查询员工信息
	public Employee queryForUpdate(int id){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Employee employee=null;
		try {
			conn=DBUtil.getConn();
			String sql="select * from employee where id=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				String email=rs.getString("email");
				int age=rs.getInt("age");
				int gender=rs.getInt("gender");
				employee=new Employee(id, name, age, email, gender);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,ps,conn);
		}
		return employee;
	}
	
	//修改员工信息
	public void updateEmp(int id,String name,int age,int gender,String email){
		Connection conn=null;
		PreparedStatement ps=null;
		try {
			conn=DBUtil.getConn();
			String sql="update employee set name=?,age=?,gender=?,email=? where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setInt(3, gender);
			ps.setString(4, email);
			ps.setInt(5, id);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(ps,conn);
		}
	}
	
	//分页查询员工数据
	public List<Employee> queryByPage(int startRow,int pageRow){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Employee> empList=new ArrayList<Employee>();
		try {
			conn=DBUtil.getConn();
			String sql="select * from employee limit ?,?";
			ps=conn.prepareStatement(sql);
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
	
	//查询年龄分布
	
	public List<AgeArea> queryAgeArea(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<AgeArea> ageList=new ArrayList<AgeArea>();
		try {
			conn=DBUtil.getConn();
			String sql="select "+ 
					"case when age>=0 and age <=10 then '0-10' "+
					"when age>=11 and age<=20 then '11-20' "+
			 		"when age>=21 and age<=30 then '21-30' "+
			 		"when age>=31 and age<=40 then '31-40' "+
			 		"when age>=41 and age<=50 then '41-50' "+
			 		"when age>=51 and age<=60 then '51-60' "+
			 		"else '60以上' end ageArea,count(*) count "+
			 		"from employee group by ageArea;";
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				String ageArea=rs.getString(1);
				int count=rs.getInt(2);
				ageList.add(new AgeArea(ageArea, count));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(rs,ps,conn);
		}
		
		return ageList;
	}
	
	//通过最小年龄和最大年龄查询员工
	/*public List<Employee> queryByAge(int...ages){
		if(ages.length==2){
			return BaseDao.queryList("select * from employee where age>=? and age<=?", new Object[]{ages[0],ages[1]}, new Employee());
		}else{
			return BaseDao.queryList("select * from employee where age>?", new Object[]{ages[0]}, new Employee());
		}
	}*/
	public List<Employee> queryByAge(int minAge,int maxAge){
		return BaseDao.queryList("select * from employee where age>=? and age<=?", new Object[]{minAge,maxAge}, new Employee());
	}
	public List<Employee> queryByAge(int minAge){
		return BaseDao.queryList("select * from employee where age>?", new Object[]{minAge}, new Employee());
	}
}
