package com.cdsxt.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.cdsxt.vo.Student;

public class InitServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		List<Student> stuList=new ArrayList<Student>();
		for(int i=1;i<=100;i++){
			stuList.add(new Student(i, "学生"+i, 18, (int)(Math.random()*3+1)));
		}
		context.setAttribute("stuList", stuList);
	}

}
