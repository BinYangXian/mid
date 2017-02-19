package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.Employee;

public class AjaxServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		String uname=request.getParameter("uname");
		ServletContext context=this.getServletContext();
		boolean isExistUname=((Map<String, String>)context.getAttribute("managers")).containsKey(uname);
		System.out.println("接收到的需要验证的uname:"+uname);
		if(isExistUname){
			response.getWriter().write("该管理员已经存在！");
		}
	}
}
