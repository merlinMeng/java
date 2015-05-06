package com.thinkingInJava.chapter.four;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	@Test
	public void testSwitch(){
		Random random = new Random(47);
		for(int i=0;i<100;i++){
			int a =random.nextInt(26) +'a';
			System.out.println((char)a+"--------");
			switch(a){
				case 'a':System.out.print("one     ");
				case 'e':System.out.print("two     ");
				case 'i':System.out.print("three   ");break;
				case 'o':System.out.print("four");break;
				case 'u':System.out.print("five");
				case 'y':System.out.println("six");break;
				default:System.out.println("consonant");
			}
			System.out.println();
		}
	}
	//I write
	public String myfibonacci(int initial){
		int a =1;
		StringBuffer sb = new StringBuffer();
		switch(initial){
			case 2:sb.append(a).append(" ");
			case 1:sb.append(a).append(" ");;break;
			default:sb.append(a).append(" ").append(a).append(" ");
		}
		if(initial>=3){
			int b=1;
			for(int i=3;i<=initial;i++){
				int c =a+b;
				sb.append(c).append(" ");
				b = a;
				a = c;
			}
		}
		return sb.toString();
	}
	//network
	public int fibonacci(int n){
		if(n==1||n==2){
			return 1;
		}else{
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	@Test
	public void testFibonacci(){
		//String result = myfibonacci(30);
		List<Integer> list =new ArrayList<Integer>();
		for(int i=1;i<=10;i++){
			list.add(fibonacci(i));
		}

		System.out.println(list.toString());
	}
	
	
}
