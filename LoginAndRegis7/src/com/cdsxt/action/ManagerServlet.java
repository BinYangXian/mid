package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdsxt.dao.ManagerDao;

public class ManagerServlet extends HttpServlet {
	private ManagerDao managerDao=new ManagerDao();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String mark=request.getParameter("mark");
		if("login".equals(mark)){
			managerLogin(request,response);
		}else if("regis".equals(mark)){
			managerRegis(request,response);
		}
	}
	//管理员登陆
	public void managerLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		//登陆成功则为true 否则为false
		boolean result=managerDao.managerLogin(uname,pwd);
		if(result){
			HttpSession session=request.getSession();
			session.setAttribute("manager", uname);
			request.getRequestDispatcher("employeeServlet?mark=query").forward(request, response);
		}else{
			request.setAttribute("msg", "<h3>用户名或密码错误</h3>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
	
	//管理员注册
	public void managerRegis(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		//调用jdbc验证用户名是否存在 true为存在 false 不存在
		boolean result=managerDao.valiUname(uname);
		if(result){
			request.setAttribute("msg", "<h3>用户名已存在</h3>");
			request.getRequestDispatcher("regis.jsp").forward(request, response);
		}else{
			//保存用户名和密码
			managerDao.managerRegis(uname,pwd);
			request.setAttribute("msg", "<h3>注册成功请登录</h3>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}
}