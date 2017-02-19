package com.bjsxt.learnServlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		if("regis".equals(mark)){
//			userRegis(request,response);//此处忽略
		}else if("login".equals(mark)){
			userLogin(request,response);
		}
	}
	
	//用户 登陆的逻辑
	public void userLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取表单传入的用户名密码
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		ServletContext context = this.getServletContext();
		if(uname.isEmpty()||pwd.isEmpty()){
			request.setAttribute("msg", "<h3>登陆信息填写不完整</h3>");
			request.getRequestDispatcher("loginPage").forward(request, response);
		}else{
			String rightPwd=(String) context.getAttribute(uname);
			if(!pwd.equals(rightPwd)){
				request.setAttribute("msg", "<h3>用户名或密码错误</h3>");
				request.getRequestDispatcher("loginPage").forward(request, response);
			}else{
				//判断是否需要保存用户名和密码
				String time=request.getParameter("time");
				//创建用户名和密码的cookie信息
				Cookie unameCookie=new Cookie("uname", uname);
				Cookie pwdCookie=new Cookie("pwd", pwd);
				
				//根据选择的情况 设置时间
				if(time==null){
//					unameCookie.setMaxAge(0);
//					pwdCookie.setMaxAge(0);
				}else if("1".equals(time)){
					unameCookie.setMaxAge(60*60*24);
					pwdCookie.setMaxAge(60*60*24);
				}else if("2".equals(time)){
					unameCookie.setMaxAge(60*60*24*7);
					pwdCookie.setMaxAge(60*60*24*7);
				}else if("3".equals(time)){
					unameCookie.setMaxAge(60*60*24*30);
					pwdCookie.setMaxAge(60*60*24*30);
				}
				
				//设置cookie的作用范围
				unameCookie.setPath(request.getContextPath()+"/loginPage");
				pwdCookie.setPath(request.getContextPath()+"/loginPage");
				
				//响应给浏览器
				response.addCookie(unameCookie);
				response.addCookie(pwdCookie);
				//存入servletContext,键是用户名，值是   用户对象(uname,pwd,path(图片路径在中UploadServlet存))
				context.setAttribute("uname", uname);
				context.setAttribute("pwd", pwd);
				request.getRequestDispatcher("successPage").forward(request, response);
			}
		}
	}
}
