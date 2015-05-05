package com.sky.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

    
public class BeginJob implements Runnable {
	
	private final static Logger logger = Logger.getLogger(BeginJob.class);
	
//	private String examType;
//	private String year;
//	private String area;
//	private String jobId;
	private String cmd;
	
//	public BeginJob(String examType,String year,String area,String jobId){
//		this.examType=examType;
//		this.year=year;
//		this.area=area;
//		this.jobId=jobId;
//	}
	public BeginJob(String cmd){
		this.cmd=cmd;
	}
	public void run() {
		createFile(cmd);
	}
	
	public static void createFile(String cmd){
		try{
			File workdir = new File("D:\\python\\plsc\\");
			Process ob=  Runtime.getRuntime().exec(cmd, null, workdir);
			
			//int b =ob.exitValue();
			//System.out.println("a---"+"---b-------"+b);
			BufferedReader brInput = new BufferedReader(new InputStreamReader(ob.getInputStream()));
			// StringBuffer sb = new StringBuffer();
			 String str =null;
			 while((str=brInput.readLine())!=null){
				//sb.append(str).append(System.getProperty("line.separator"));
				 System.out.println(str);
			 }
			 BufferedReader brError = new  BufferedReader(new InputStreamReader(ob.getErrorStream()));
			 
			 while((str=brError.readLine())!=null){
				 //sb.append(str).append(System.getProperty("line.separator"));
				 System.out.println(str);
			 }
			 brInput.close();
			 brError.close();
			// System.out.println(sb.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}    