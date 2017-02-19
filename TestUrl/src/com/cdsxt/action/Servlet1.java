package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
	    <servlet-name>Servlet1</servlet-name>
	    <url-pattern>/one/two/servlet1</url-pattern>
	    <servlet-name>Servlet2</servlet-name>
	    <url-pattern>/three/servlet2</url-pattern>
	    
	    http://localhost:8080/TestUrl/one/two/servlet1
	    http://localhost:8080/TestUrl/three/servlet2
	  	*/
		//请求转发相对路径去访问
//		request.getRequestDispatcher("../../three/servlet2").forward(request, response);
		//请求转发绝对路径去访问
//		request.getRequestDispatcher("/three/servlet2").forward(request, response);
		
		//重定向的相对路径
//		response.sendRedirect("../../three/servlet2");
		//重定向的绝对路径
//		response.sendRedirect("/TestUrl/three/servlet2");
//		response.sendRedirect(request.getContextPath()+"/three/servlet2");
		
		System.out.println("哎哟不错哦！！！");
		
	}

}
