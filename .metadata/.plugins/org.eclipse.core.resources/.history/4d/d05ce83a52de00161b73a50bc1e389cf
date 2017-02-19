package com.cdsxt.action;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//refresh  只写时间    每隔多少秒刷新页面一次
//		response.setHeader("refresh", "3");
//		response.setHeader("REfreSh", "5;url=http://www.baidu.com");
		
//		OutputStream out=response.getOutputStream();  作业基于这个往页面输出一个图片
		
		PrintWriter pw=response.getWriter();
		pw.write("<script>alert(111)</script>");
		pw.write("<h1>this is server msg!</h1>");
		pw.flush();
		pw.close();
	}

}
