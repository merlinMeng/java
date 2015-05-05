package com.service;

import org.junit.Test;


public class TestJava {
	@Test
	public void testStringBuffer(){
		StringBuffer sb = new StringBuffer();
		sb.append("a+b");
		System.out.println(sb.toString());
		testPlus(sb);
		System.out.println(sb.toString());
		String str = "b+d";
		System.out.println(str);
		testPlus(str);
		System.out.println(str);
	}
	
	public void testPlus(StringBuffer path){
		path.append("=c");
	}
	public void testPlus(String path){
		path = path+"=e";
	}
	
	
}
