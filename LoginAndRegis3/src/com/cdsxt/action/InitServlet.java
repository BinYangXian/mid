package com.cdsxt.action;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitServlet extends HttpServlet {

	//用来初始化默认的用户名和密码
	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		ServletConfig config=this.getServletConfig();
		//获取所有用户名
		Enumeration<String> enums=config.getInitParameterNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			context.setAttribute(name, config.getInitParameter(name));
		}
		//以下 代码是测试是否成功装入servletContext
		/*Enumeration<String> enums2=context.getAttributeNames();
		while(enums2.hasMoreElements()){
			String name=enums2.nextElement();
			System.out.println(name+"---"+context.getAttribute(name));
		}*/
	}

	
}
