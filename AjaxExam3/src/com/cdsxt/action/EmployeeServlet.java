package com.cdsxt.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.Employee;
import com.google.gson.Gson;

public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		List<Employee> empList=(List<Employee>) this.getServletContext().getAttribute("empList");
		System.out.println(new Gson().toJson(empList));
		response.getWriter().write(new Gson().toJson(empList));
	}
}
