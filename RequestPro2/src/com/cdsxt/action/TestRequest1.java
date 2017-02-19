package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestRequest1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//往作用域中保存信息
		request.setAttribute("a", "aaa");
		request.setAttribute("b", "bbb");
		
		//使用请求转发跳转到TestRequest2
		//特点：
		//整个过程一次请求
		//地址栏没有发生变化
		//只能访问服务器内部的资源
		//请求转发的绝对路径  的/  代表项目的根目录
		//习惯性在请求转发或重定向后面添加一个return   避免再次请求转发或重定向会报错
//		request.getRequestDispatcher("testRequest2").forward(request, response);
		//http://localhost/RequestPro2/testRequest2
		request.getRequestDispatcher("/testRequest2").forward(request, response);
		return;
//		request.getRequestDispatcher("http://www.baidu.com").forward(request, response);
		
	}
}
