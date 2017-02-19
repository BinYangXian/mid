package com.cdsxt.vo;

public class TestBean {
	
	public TestBean() {
	}
	
	public TestBean(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	private TestBean(String email, boolean handsome, String a) {
		this.email = email;
		this.handsome = handsome;
		this.a = a;
	}

	//用于反射测试的属性
	private int id;
	String name;
	protected String email;
	public boolean handsome;
	public static int gender;
	public String a;
	//用于反射测试的方法
	public void test(){
		System.out.println("hello reflect!!");
	}
	
	public int add(int a,int b){
		System.out.println("a+b的结果:"+(a+b));
		return a+b;
	}
	
	public static void test2(){
		System.out.println("静态的方法");
	}
	private String test3(String name){
		return "你好帅啊"+name;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isHandsome() {
		return handsome;
	}

	public void setHandsome(boolean handsome) {
		this.handsome = handsome;
	}

	public static int getGender() {
		return gender;
	}

	public static void setGender(int gender) {
		TestBean.gender = gender;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}
	
}
