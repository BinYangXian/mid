package com.cdsxt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cdsxt.vo.Employee;

public class EmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		HttpSession session=request.getSession();
		Object manager=session.getAttribute("manager");
		if(manager==null){
			request.setAttribute("msg", "<h3>请登陆后再使用本系统</h3>");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		String mark=request.getParameter("mark");
		if("del".equals(mark)){
			delEmployee(request,response);
		}else if("add".equals(mark)){
			addEmployee(request,response);
		}else if("update".equals(mark)){
			updateEmployee(request,response);
		}else if("queryForUpdate".equals(mark)){
			queryForUpdate(request,response);
		}
	}
	
	//根据员工id删除对应员工
	public void delEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取要删除的id
		int id=Integer.parseInt(request.getParameter("id").trim());
		ServletContext context=this.getServletContext();
		List<Employee> empList=(List<Employee>) context.getAttribute("empList");
		Employee employee=null;
		for(int i=0;i<empList.size();i++){
			if(empList.get(i).getId()==id){
				//如果员工编号相等  则赋值要删除的对象
				employee=empList.get(i);
				break;
			}
		}
		//从empList中删除员工
		empList.remove(employee);
		//回到员工显示页面
		request.getRequestDispatcher("showEmps.jsp").forward(request, response);
	}
	
	//添加员工
	public void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> empList=(List<Employee>) this.getServletContext().getAttribute("empList");
		//获取员工的表单参数
		int id=Integer.parseInt(request.getParameter("id"));
		//编号是否存在
		boolean result=true;
		for(Employee emp:empList){
			if(emp.getId()==id){
				result=false;
				break;
			}
		}
		//不存在的时候才走添加的逻辑
		if(result){
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			int gender=Integer.parseInt(request.getParameter("gender"));
			empList.add(new Employee(id, name, age, gender));
			request.getRequestDispatcher("showEmps.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "<h3>不能使用重复的编号</h3>");
			request.getRequestDispatcher("addEmp.jsp").forward(request, response);
		}
	}
	
	//修改用户信息
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> empList=(List<Employee>) this.getServletContext().getAttribute("empList");
		//获取员工的表单参数
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int age=Integer.parseInt(request.getParameter("age"));
		int gender=Integer.parseInt(request.getParameter("gender"));
		
		//查找到要修改的员工
		Employee employee=null;
		for(int i=0;i<empList.size();i++){
			if(empList.get(i).getId()==id){
				//如果员工编号相等  则赋值要修改的对象
				employee=empList.get(i);
				break;
			}
		}
		//修改员工信息
		if(employee!=null){
			employee.setAge(age);
			employee.setGender(gender);
			employee.setName(name);
		}
		//返回显示页面
		request.getRequestDispatcher("showEmps.jsp").forward(request, response);
	}
	
	//根据id查询员工信息返回到修改页面
	public void queryForUpdate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> empList=(List<Employee>) this.getServletContext().getAttribute("empList");
		//获取要修改员工的id
		int id=Integer.parseInt(request.getParameter("id"));
		//查找到要修改的员工
		Employee employee=null;
		for(int i=0;i<empList.size();i++){
			if(empList.get(i).getId()==id){
				//如果员工编号相等  则赋值要修改的对象
				employee=empList.get(i);
				break;
			}
		}
		request.setAttribute("emp", employee);
		request.getRequestDispatcher("updateEmp.jsp").forward(request, response);
	}
}
