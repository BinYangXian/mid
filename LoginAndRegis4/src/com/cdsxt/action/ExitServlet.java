package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExitServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//使cookie失效
		Cookie unameCookie=new Cookie("uname", "123");
		Cookie pwdCookie=new Cookie("pwd", "123");
		unameCookie.setMaxAge(0);
		pwdCookie.setMaxAge(0);
		unameCookie.setPath(request.getContextPath()+"/loginPage");
		pwdCookie.setPath(request.getContextPath()+"/loginPage");
		response.addCookie(unameCookie);
		response.addCookie(pwdCookie);
		
		request.getRequestDispatcher("loginPage").forward(request, response);
	}
}
