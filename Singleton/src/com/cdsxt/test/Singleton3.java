package com.cdsxt.test;

public class Singleton3 {
	//静态内部类单例模式
	private Singleton3(){}
	
	static class Singleton{
		private static final Singleton3 singleton3=new Singleton3();
	}
	
	public static Singleton3 getSingleton(){
		return Singleton.singleton3;
	}
}
