package com.cdsxt.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdsxt.vo.Manager;

public class ManagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uname=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		if(uname.isEmpty()||pwd.isEmpty()){
			request.setAttribute("msg", "<h3>登陆信息填写不完整</h3>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			ServletContext context=this.getServletContext();
			List<Manager> managerList=(List<Manager>) context.getAttribute("managerList");
			for(Manager manager:managerList){
				if(uname.equals(manager.getUname())&&pwd.equals(manager.getPwd())){
					//登陆成功的逻辑
					HttpSession session=request.getSession();
					session.setAttribute("manager", uname);
					request.getRequestDispatcher("showEmps.jsp").forward(request, response);
					return;
				}
			}
			//登陆信息有误的逻辑
			request.setAttribute("msg", "<h3>用户名或密码错误</h3>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
