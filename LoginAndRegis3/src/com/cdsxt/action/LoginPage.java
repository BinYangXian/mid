package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
		//设置从服务器往页面书写的中文乱码问题
		response.setHeader("content-type", "text/html;charset=utf-8");
		Cookie[] cookies=request.getCookies();
		String uname="";
		String pwd="";
		if(cookies!=null&&cookies.length>0){
			for(Cookie cookie:cookies){
				if("uname".equals(cookie.getName())){
					uname=cookie.getValue();
				}else if("pwd".equals(cookie.getName())){
					pwd=cookie.getValue();
				}
			}
		}
		
		PrintWriter pw=response.getWriter();
		pw.write("<h1>用户登陆页面</h1>");
		String msg=(String) request.getAttribute("msg");
		if(msg!=null){
			pw.write(msg);
		}
		pw.write("<script>");
		pw.write("function showOrHide(result){");
		pw.write("var timeDiv=document.getElementsByTagName('div')[0];");
		pw.write("var times=document.getElementsByName('time');");
		pw.write("if(result){");
		pw.write("times[1].checked=true;");
		pw.write("timeDiv.style.display='block';");
		pw.write("}else{");
		pw.write("for(var i=0;i<times.length;i++){");
		pw.write("times[i].checked=false;");
		pw.write("}");
		pw.write("timeDiv.style.display='none';");
		pw.write("}}</script>");
		
		pw.write("<form action='userServlet?mark=login' method='post'>");
		pw.write("用户名:<input type='text' name='uname' value='"+uname+"' /><br/>");
		pw.write("密码:<input type='password' name='pwd' value='"+pwd+"' /><br/>");
		pw.write("<input type=\"checkbox\" onclick=\"showOrHide(this.checked)\" />是否保存用户名和密码<br/>");
		pw.write("<div style=\"display: none\">");
		pw.write("<input type=\"radio\" name=\"time\" value=\"1\" />一天");
		pw.write("<input type=\"radio\" name=\"time\" value=\"2\" />一周");
		pw.write("<input type=\"radio\" name=\"time\" value=\"3\" />一个月");
		pw.write("</div>");
		pw.write("<input type='submit' value='登陆' />");	
		pw.write("</form>");
		pw.flush();
		pw.close();
	}

}
