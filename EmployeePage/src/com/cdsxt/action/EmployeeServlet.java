package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.dao.EmployeeDao;
import com.cdsxt.po.Employee;
import com.cdsxt.util.PageUtil;

public class EmployeeServlet extends HttpServlet {
	private EmployeeDao employeeDao=new EmployeeDao();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mark=request.getParameter("mark");
		if("query".equals(mark)){
			queryEmps(request,response);
		}
	}
	
	//数据库查询所有员工并且返回到显示员工的页面
	public void queryEmps(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//从页面获取当前页是第几页  如果没有传 默认显示第一页
		int curPage=request.getParameter("curPage")==null?1:Integer.parseInt(request.getParameter("curPage"));
		//查询数据库的数据条数 用于创建分页对象
		int count=employeeDao.queryCount();
		PageUtil pageUtil=new PageUtil(curPage, count);
		List<Employee> empList=employeeDao.queryEmps(pageUtil.getStartRow(),pageUtil.getPageRow());
		request.setAttribute("empList", empList);
		//将pageUtil对象放入作用域  生成导航栏
		request.setAttribute("page", pageUtil);
		request.getRequestDispatcher("showEmps.jsp").forward(request, response);
	}
}
