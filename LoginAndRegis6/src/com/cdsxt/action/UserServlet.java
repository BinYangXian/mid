package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理服务器到页面的乱码问题
		response.setHeader("content-type", "text/html;charset=utf-8");
		//处理页面到服务器的乱码问题 处理的是请求实体的编码
		//如果要同时处理uri的编码  需要在配置端口号的地方添加    useBodyEncodingForURI="true"
		request.setCharacterEncoding("utf-8");
		String mark=request.getParameter("mark");
		if("login".equals(mark)){
			userLogin(request,response);
		}
	}
	
	
	//用户 登陆的逻辑
	public void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		if(uname.isEmpty()||pwd.isEmpty()){
			request.setAttribute("msg", "<h3>登陆信息填写不完整</h3>");
			request.getRequestDispatcher("loginPage").forward(request, response);
		}else{
			String rightPwd=(String) this.getServletContext().getAttribute(uname);
			//用户名没有注册  或者  密码错误
			if(rightPwd==null){
				request.setAttribute("msg", "<h3>该用户没有注册</h3>");
				request.getRequestDispatcher("loginPage").forward(request, response);
			}else if(!rightPwd.equals(pwd)){
				request.setAttribute("msg", "<h3>密码错误</h3>");
				request.getRequestDispatcher("loginPage").forward(request, response);				
			}else{
				request.getRequestDispatcher("successPage").forward(request, response);
			}
		}
	}
}
