package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//第一步  获取servletConfig对象  
		ServletConfig config=this.getServletConfig();
		//第二步获取web.xml中的信息  servlet名字
//		String servletName=config.getServletName();
//		System.out.println("servlet的名字："+servletName);
		
		
		String pwd1=config.getInitParameter("zhangsan");
		String pwd2=config.getInitParameter("lisi");
		System.out.println(pwd1);
		System.out.println(pwd2);
		System.out.println("----------------------------------");
		Enumeration<String> enums=config.getInitParameterNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			System.out.println(name+"-------"+config.getInitParameter(name));
		}
	}

}
