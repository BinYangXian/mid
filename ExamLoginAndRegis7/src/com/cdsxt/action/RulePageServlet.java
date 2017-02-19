package com.cdsxt.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.Employee;
import com.google.gson.Gson;

public class RulePageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		String saveTag=request.getParameter("saveTag");
		System.out.println("saveTag="+saveTag);
//		ServletContext context=this.getServletContext();
//		List<MyRule> list=(List<MyRule>) context.getAttribute("ruleList");
//		System.out.println("list="+list);
		if("change".equals(saveTag)){
			String jsonData=request.getParameter("chaData");
			System.out.println(jsonData);
			if(!jsonData.isEmpty()){
				Employee oneEmp=new Gson().fromJson(jsonData, Employee.class);
				int i;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "proot");
					Statement st=conn.createStatement();
					String sql="select count(*) from myemp where empno="+oneEmp.getNumber();
					ResultSet rs=st.executeQuery(sql);
					String sql2;
					if(rs.next()){
						 sql2="update myemp set job='"+oneEmp.getJob()+"',set ename='"+oneEmp.getName()+"' where" +
								"empno="+oneEmp.getNumber()+"'";
					}else{
						 sql2="insert into myemp(job,ename) values("+oneEmp.getJob()+"','"+oneEmp.getName()+"' where" +
								"')";
					}
					st.execute(sql2);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if("del".equals(saveTag)){
			delData(request, saveTag);
		}
	}

	private void delData(HttpServletRequest request, String saveTag) {
		String delData=request.getParameter("delData");
		System.out.println("delData="+delData);
		List<Integer> tempDelList=new ArrayList<Integer>();
		Pattern pt=Pattern.compile("\\d+");
		Matcher mt=pt.matcher(delData);
	    //c)通过匹配器检查数据
	    while(mt.find()){
	    	tempDelList.add(Integer.parseInt(mt.group()));
	    }
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mytest","root", "proot");
			Statement st=conn.createStatement();
			
			for (Integer integer : tempDelList) {
				st.addBatch("delete from myemp where empno="+integer);
				System.out.println("删除了"+integer);
			}
			st.executeBatch();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
