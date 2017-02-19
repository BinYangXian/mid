package com.cdsxt.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.cdsxt.vo.Manager;
import com.cdsxt.vo.Student;

public class InitMessage extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		//初始化 管理员
		List<Manager> managerList=new ArrayList<Manager>();
		managerList.add(new Manager("zhangsan","123456"));
		//初始化 员工
		List<Student> empList=new ArrayList<Student>();
		for(int i=1;i<=20;i++){
			empList.add(new Student(i,"测试"+i,(int)(Math.random()*43+18),(int)(Math.random()*3+1)));
		}
		//将初始化号的员工和管理员存入作用域
		context.setAttribute("managerList", managerList);
		context.setAttribute("empList", empList);
	}

}
