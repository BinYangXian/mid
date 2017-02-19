package com.cdsxt.vo;

public class Student {
	private int id;
	private String name;
	private int age;
	//  1为男     0为女
	private int className;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getClassName() {
		return className;
	}
	public void setClassName(int className) {
		this.className = className;
	}
	public Student(int id, String name, int age, int className) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.className = className;
	}
	
}
