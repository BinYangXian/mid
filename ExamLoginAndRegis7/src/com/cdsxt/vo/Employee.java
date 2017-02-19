package com.cdsxt.vo;

public class Employee {
	private int number;
	private String name;
	private String job;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Employee(int number, String name, String job) {
		super();
		this.number = number;
		this.name = name;
		this.job = job;
	}
	
}
