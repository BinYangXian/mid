package com.cdsxt.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet2 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		System.out.println(request.getRemoteAddr());
		System.out.println("---------------------------------------------");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		System.out.println("uname:"+uname);
		System.out.println("pwd:"+pwd);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("闹哪样?");
	}
}
