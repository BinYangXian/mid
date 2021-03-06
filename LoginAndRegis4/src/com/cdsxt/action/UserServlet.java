package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {
	private Map<String, String> map=new HashMap<String, String>();
	
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
		if("regis".equals(mark)){
			userRegis(request,response);
		}else if("login".equals(mark)){
			userLogin(request,response);
		}
	}
	
	//用户注册的逻辑
	public void userRegis(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取表单传入的用户名密码和重复密码
		String uname=request.getParameter("uname");
		System.out.println("用户名:"+uname);
		String pwd=request.getParameter("pwd");
		String repwd=request.getParameter("repwd");
		
		if(uname.isEmpty()||pwd.isEmpty()||repwd.isEmpty()){
//			response.getWriter().write("<h1>注册信息填写不完整，即将返回注册页面</h1>");
//			response.setHeader("refresh", "3;url=regisPage");
			
			//如果有没填写完整 返回注册页面
			request.setAttribute("msg", "<h3>注册信息填写不完整</h3>");
			request.getRequestDispatcher("regisPage").forward(request, response);
		}else if(!pwd.equals(repwd)){
			request.setAttribute("msg", "<h3>两次密码输入不一致</h3>");
			request.getRequestDispatcher("regisPage").forward(request, response);
		}else{
			//验证该用户名是否可用 true表示已注册  false 表示可以使用
			boolean result=map.containsKey(uname);
			if(result){
				request.setAttribute("msg","<h3>好名字被使用了!!</h3>");
				request.getRequestDispatcher("regisPage").forward(request, response);
			}else{
				//将用户信息保存在map中
				map.put(uname, pwd);
				//跳转到登陆页面
				request.setAttribute("msg", "<h3>注册成功，请登陆！</h3>");
				request.getRequestDispatcher("loginPage").forward(request, response);
			}
		}
	}
	
	//用户 登陆的逻辑
	public void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取表单传入的用户名密码
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		
		if(uname.isEmpty()||pwd.isEmpty()){
			request.setAttribute("msg", "<h3>登陆信息填写不完整</h3>");
			request.getRequestDispatcher("loginPage").forward(request, response);
		}else{
			String rightPwd=map.get(uname);
			if(!pwd.equals(rightPwd)){
				request.setAttribute("msg", "<h3>用户名或密码错误</h3>");
				request.getRequestDispatcher("loginPage").forward(request, response);
			}else{
				
				String autoLogin=request.getParameter("autoLogin");
				if(autoLogin!=null){
					Cookie unameCookie=new Cookie("uname", uname);
					Cookie pwdCookie=new Cookie("pwd", pwd);
					
					unameCookie.setPath(request.getContextPath()+"/loginPage");
					pwdCookie.setPath(request.getContextPath()+"/loginPage");
					
					unameCookie.setMaxAge(60*60*24*7);
					pwdCookie.setMaxAge(60*60*24*7);
					
					response.addCookie(unameCookie);
					response.addCookie(pwdCookie);
				}
				request.getRequestDispatcher("successPage").forward(request, response);
			}
		}
	}
}
