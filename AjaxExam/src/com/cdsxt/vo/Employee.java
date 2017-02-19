package com.cdsxt.vo;

public class Employee {
	//员工属性（员工编号(唯一确定员工),姓名，年龄，性别）
	private String empName;
	private String empId;
	private String empSex;
	private String empAge;
	public Employee(String empName, String empId, String empSex, String empAge) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.empSex = empSex;
		this.empAge = empAge;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getEmpAge() {
		return empAge;
	}
	public void setEmpAge(String empAge) {
		this.empAge = empAge;
	}
	
}
