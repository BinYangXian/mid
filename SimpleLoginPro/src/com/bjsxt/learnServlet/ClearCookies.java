package com.bjsxt.learnServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClearCookies extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie unameCookie=new Cookie("uname", "");
		Cookie pwdCookie=new Cookie("pwd", "");
		unameCookie.setMaxAge(0);
		pwdCookie.setMaxAge(0);
		//设置cookie的作用范围
		unameCookie.setPath(request.getContextPath()+"/loginPage");
		pwdCookie.setPath(request.getContextPath()+"/loginPage");
		//响应给浏览器
		response.addCookie(unameCookie);
		response.addCookie(pwdCookie);
//		response.sendRedirect("loginPage");
		request.getRequestDispatcher("loginPage").forward(request, response);
	}

}
