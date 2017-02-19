package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");		
		String mark=request.getParameter("mark");
		if(mark==null){
			userLogin(request,response);
		}else if("pay".equals(mark)){
			payMoney(request,response);
		}
	}
	
	public void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		ServletContext context=this.getServletContext();
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		if(uname.isEmpty()||pwd.isEmpty()){
			request.setAttribute("msg", "<h3>登陆信息填写不完整</h3>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			String rightPwd=(String)context.getAttribute(uname);
			if(!pwd.equals(rightPwd)){
				request.setAttribute("msg", "<h3>用户名或密码错误</h3>");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else{
				String save=request.getParameter("save");
				//创建保存用户名和密码的cookie
				Cookie unameCookie=new Cookie("uname", uname);
				Cookie pwdCookie=new Cookie("pwd", pwd);
				
				//设置cookie的作用范围
				unameCookie.setPath(request.getContextPath()+"/login.jsp");
				pwdCookie.setPath(request.getContextPath()+"/login.jsp");
				
				//根据是否保存  设置cookie时间
				if(save==null){
					unameCookie.setMaxAge(0);
					pwdCookie.setMaxAge(0);
				}else{
					unameCookie.setMaxAge(60*60*24*7);
					pwdCookie.setMaxAge(60*60*24*7);
				}
				//响应给客户端
				response.addCookie(unameCookie);				
				response.addCookie(pwdCookie);		
				
				
				//将用户信息装入session，最大空闲时间10秒
				session.setAttribute("user", uname);
				session.setMaxInactiveInterval(10);
				request.getRequestDispatcher("shop.jsp").forward(request, response);
			}
		}
	}
	//验证用户信息是否存在，如果存在则购买，不存在则跳回登录页面
	public void payMoney(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		Object user=session.getAttribute("user");
		if(user==null){
			request.setAttribute("msg", "<h3>用户信息已过期，请重新登陆</h3>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("pay.jsp").forward(request, response);
		}
	}
}
