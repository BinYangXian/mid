package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		System.out.println("哎哟，不错哦~");
//		http://localhost:8080/TestUrl/one/two/servlet1
//		http://localhost:8080/TestUrl/three/servlet2
		//请求转发相对路径
//		request.getRequestDispatcher("../one/two/servlet1").forward(request, response);
		//请求转发绝对路径
//		request.getRequestDispatcher("/one/two/servlet1").forward(request, response);
		
		//重定向的相对路径
//		response.sendRedirect("../one/two/servlet1");
		//重定向的绝对路径
		response.sendRedirect("/TestUrl/one/two/servlet1");
	}

}
