package com.cdsxt.action;

public class test {
public static void main(String[] args) {
	StringBuffer sb=new StringBuffer("\"a\",\"aab\",\"aac\",\"aaa\",");
	System.out.println(sb);
	System.out.println(sb.substring(0, sb.toString().length()-1));;
}
}
