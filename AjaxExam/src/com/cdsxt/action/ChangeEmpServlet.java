package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.Employee;

public class ChangeEmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
			String mark=request.getParameter("mark");
			System.out.println("mark="+mark);
			String staIndex=request.getParameter("staIndex");
			ServletContext context=this.getServletContext();
			List<Employee> employees=(List<Employee>) context.getAttribute("employees");
			if("delete".equals(mark)){
				employees.remove(Integer.parseInt(staIndex));//这里草率
//				context.setAttribute("employees", employees);//这里多余
				response.sendRedirect("successPage.jsp");//用请求转发，效率更高
			}else if("change".equals(mark)){
				Employee e=new Employee(request.getParameter("empName"), request.getParameter("empId"),
						request.getParameter("empSex"), request.getParameter("empAge"));
				System.out.println("request.getParameter(\"empName\")="+request.getParameter("empName"));
				employees.set(Integer.parseInt(staIndex), e);
//				context.setAttribute("employees", employees);//这里多余
				response.sendRedirect("successPage.jsp");
			}
	}

}
