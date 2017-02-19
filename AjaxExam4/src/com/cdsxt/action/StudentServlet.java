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

public class StudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=utf-8");
		List<Student> stuList=(List<Student>) this.getServletContext().getAttribute("stuList");
		List<Student> resultList=new ArrayList<Student>();
		int classId=Integer.parseInt(request.getParameter("classId"));
		for(Student s:stuList){
			if(classId==s.getClassId()){
				resultList.add(s);
			}
		}
		response.getWriter().write(new Gson().toJson(resultList));
	}
}
