package com.cdsxt.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdsxt.vo.Student;
import com.google.gson.Gson;

public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		String className=request.getParameter("className");
		List<Student> empList=(List<Student>) this.getServletContext().getAttribute("empList");
		List<Student> stuList=new ArrayList<Student>();
		System.out.println(new Gson().toJson(empList));
		for (int i = 0; i < empList.size(); i++) {
			int currClaName=empList.get(i).getClassName();
			if(String.valueOf(currClaName).equals(className)){
				stuList.add(empList.get(i));
			}
		}
		String stuListJsonStr=new Gson().toJson(stuList);
		response.getWriter().write(stuListJsonStr);
	}
}
