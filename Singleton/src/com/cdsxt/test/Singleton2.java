package com.cdsxt.test;

public class Singleton2 {
	//单例模式之懒汉模式
	private Singleton2(){}
	private static Singleton2 singleton2=null;
	public static Singleton2 getSingleton(){
		if(singleton2==null){
			singleton2=new Singleton2();
		}
		return singleton2;
	}
}
