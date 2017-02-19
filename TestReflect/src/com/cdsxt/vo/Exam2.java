package com.cdsxt.vo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Exam2 {
	public static void main(String[] args) {
		try {
			Class clazz=Exam.class;
			//创建Exam对象
			Constructor constructor=clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			Object obj=constructor.newInstance();
			Field field=clazz.getDeclaredField("name");
			field.setAccessible(true);
			field.set(obj, "陈陈陈");
			Method method=clazz.getDeclaredMethod("test");
			method.setAccessible(true);
			method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}	
