package com.cdsxt.action;

import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class InitUserServlet extends HttpServlet {
	//初始化默认的用户名和密码
	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		ServletConfig config=this.getServletConfig();
		Enumeration<String> enums=config.getInitParameterNames();
		while(enums.hasMoreElements()){
			String name=enums.nextElement();
			String value=config.getInitParameter(name);
			context.setAttribute(name, value);
		}
	}

}
