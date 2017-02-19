package com.cdsxt.vo;

public class Student {
	private int id;
	private String name;
	private int age;
	private int classId;
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
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public Student(int id, String name, int age, int classId) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.classId = classId;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
