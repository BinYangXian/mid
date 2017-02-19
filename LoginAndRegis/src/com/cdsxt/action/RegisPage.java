package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisPage extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置从服务器往页面书写的中文乱码问题
		response.setHeader("content-type", "text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.write("<h1>用户注册页面</h1>");
		//如果request作用域中 有msg说明，验证没有通过，向页面输出错误信息
		String msg=(String) request.getAttribute("msg");
		if(msg!=null){
			pw.write(msg);
		}
		pw.write("<form action='userServlet' method='get'>");
		pw.write("<input type='hidden' name='mark' value='regis' />");
		//因为使用get方式，在form中添加:action='userServlet/mark=regis',
		//会被表单提交的参数覆盖，所以可以使用下述隐藏域/改为post方式！
		pw.write("用户名:<input type='text' name='uname' /><br/>");
		pw.write("密码:<input type='password' name='pwd' /><br/>");
		pw.write("重复密码:<input type='password' name='repwd' /><br/>");
		pw.write("<input type='submit' value='注册' />");		
		pw.write("<a href='loginPage' >登陆页面</a>");
		pw.write("</form>");
		pw.flush();
		pw.close();
	}

}
