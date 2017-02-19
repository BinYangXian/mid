package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PurchasePage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String mark = request.getParameter("mark");
			if("purchase".equals(mark)){ //初步验证是否是从成功页面跳转到此页面的
				//获取session对象
				HttpSession session=request.getSession();
				String uname=(String) session.getAttribute("uname");
				String pwd=(String) session.getAttribute("pwd");
				if(!uname.isEmpty()&&!pwd.isEmpty()){
				
					request.getRequestDispatcher("testSession2").forward(request, response);
				}
			}
	}

}
