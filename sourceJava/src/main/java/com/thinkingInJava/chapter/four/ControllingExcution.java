package com.thinkingInJava.chapter.four;

import org.junit.Test;



public class ControllingExcution {
	
	static boolean condition(){
		boolean result = Math.random()<0.4;
		return result;
	}
	
	@Test
	public void testFor(){
		int count=0;
		do{
				count++;
				System.out.print(count+" ");
		}while(condition());
		
	}
	@Test
	public void testReturn(){
		
		for(int i=1;i<=20;i++){
			System.out.print(i+" ");
			if(i>10){
				return;//return break continue; 输出不同；
			}
		}
		System.out.println("output");
	}
}
