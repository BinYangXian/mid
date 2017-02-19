package com.cdsxt.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.cdsxt.vo.Employee;
import com.cdsxt.vo.Managers;

public class InitInfoServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		ServletContext context=this.getServletContext();
		Map<String, String> managersMap=new HashMap();
		/*List<Managers> managersList=new ArrayList();
		managersList.add(new Managers("zhangsan", "123456"));
		managersList.add(new Managers("lisi", "123456"));
		context.setAttribute("managers", managersList);*/
		managersMap.put("zhangsan", "123456");
		managersMap.put("lisi", "123456");
		context.setAttribute("managers", managersMap);
		
		List<Employee>  employeeList=new ArrayList();
		//员工属性（员工编号(唯一确定员工),姓名，年龄，性别）
		employeeList.add(new Employee("张三", "123","19","男"));
		employeeList.add(new Employee("李四", "1234","20","男"));
		employeeList.add(new Employee("王五", "1235","21","男"));
		employeeList.add(new Employee("钱多多", "12356","22","女"));
		context.setAttribute("employees", employeeList);
	}
}
