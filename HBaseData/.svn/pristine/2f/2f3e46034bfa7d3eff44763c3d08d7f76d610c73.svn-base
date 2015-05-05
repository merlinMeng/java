package com.sky.util;

import org.junit.Test;

public class StringTool {
	@Test
	public void testMethod(){
		String cleanUrl = dealUrl("\\10.10.79.188\\2014thzk\\tif\\lizong\\00\\102000055\\00000001.Tif");
		System.out.println(cleanUrl);
	}
	public String dealUrl(String url){
		String[] args =  url.replace("\\", "/").split("/");
		 StringBuilder sb = new StringBuilder();
		 for(int i=4;i<args.length;i++){  
			 if(i!=(args.length-1)){
				 sb.append(args[i].toLowerCase()).append("/");
			 }else{
				 sb.append(args[i]);
			 }
		}
		return sb.toString();
	}

}
