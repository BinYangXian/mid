package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		//获取信息
		String msg=(String) request.getAttribute("msg");
		PrintWriter pw=response.getWriter();
		pw.write("<h1>用户登陆页面</h1>");
		if(msg!=null){
			pw.write(msg);
		}
		pw.write("<form action='userServlet?mark=login' method='post'  >");
		pw.write("用户名:<input type='text' name='uname' /><br/>");
		pw.write("密码:<input type='password' name='pwd' /><br/>");
		pw.write("<input type='submit' value='登陆' />");
		pw.write("<a href='regisPage' >去注册</a>");
		pw.write("</form>");
		pw.flush();
		pw.close();
	}

}
