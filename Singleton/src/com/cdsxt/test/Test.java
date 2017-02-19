package com.cdsxt.test;

public class Test {
	public static void main(String[] args) {
//		Singleton1 singleton1=Singleton1.getSingleton1();
//		Singleton1 singleton2=Singleton1.getSingleton1();
//		System.out.println(singleton1==singleton2);
		
//		Singleton2 singleton1=Singleton2.getSingleton();
//		Singleton2 singleton2=Singleton2.getSingleton();
//		System.out.println(singleton1==singleton2);
		
		
		Singleton3 singleton1=Singleton3.getSingleton();
		Singleton3 singleton2=Singleton3.getSingleton();
		System.out.println(singleton1==singleton2);
	}
}
