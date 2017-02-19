package com.cdsxt.test;

public class Singleton1 {
	//单例模式之恶汉(饿汉)模式
	//第一步将构造器私有化
	private Singleton1(){}
	//第二步持有自己的一个对象
	private static final Singleton1 singleton1=new Singleton1();
	//第三步给外部开口
	public static Singleton1 getSingleton1(){
		return singleton1;
	}
}
