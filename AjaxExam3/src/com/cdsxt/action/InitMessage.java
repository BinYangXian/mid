package com.cdsxt.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.cdsxt.vo.Employee;
import com.cdsxt.vo.Manager;

public class InitMessage extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		//初始化 管理员
		List<Manager> managerList=new ArrayList<Manager>();
		managerList.add(new Manager("zhangsan","123456"));
		//初始化 员工
		List<Employee> empList=new ArrayList<Employee>();
		for(int i=1;i<=10;i++){
			empList.add(new Employee(i,"测试"+i,(int)(Math.random()*43+18),(int)(Math.random()*2)));
		}
		//将初始化号的员工和管理员存入作用域
		context.setAttribute("managerList", managerList);
		context.setAttribute("empList", empList);
	}

}
