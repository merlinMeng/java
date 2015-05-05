package com.sky.web;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.service.JobInfoService;
import com.sky.util.FileToZip;

@Controller
@RequestMapping(value ="/jobinfo")
public class JobInfoController {
	
	private static final Logger logger = Logger.getLogger(JobInfoController.class);
	@Autowired
	private JobInfoService jobInfoService;
	
	
	
	
	
	@RequestMapping(value="/listjsonforpagination")
	@ResponseBody
	public  Object jobListForPagination(String start,String limit){
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("data", jobInfoService.queyrForPagination(start, limit));  
        map.put("success", true); 
        map.put("totalCount", jobInfoService.countJobInfo()); 
       return map;
	}
	@RequestMapping(value="/turnList")
	public String turnDapamaList(){
		
		return "main/dapama/jobInfo";
	}
	@RequestMapping(value="/down")
	public void down(HttpServletRequest request,HttpServletResponse response,String fileName) throws Exception{
		response.setContentType("application/octet-stream");  
	    fileName = URLDecoder.decode(fileName, "utf-8"); 
	    String zipName ="D:\\Output\\eDaas\\"+fileName+".zip";
	    if(!new File(zipName).isFile()){
	    	FileToZip fileToZip = new FileToZip();
	 	    fileToZip.zip("D:\\Output\\eDaas\\"+fileName, zipName);
	    }
	    
	    response.setContentType("text/html;charset=UTF-8");  
        request.setCharacterEncoding("UTF-8");  
        BufferedInputStream bis = null;  
        BufferedOutputStream bos = null;  
  
        String ctxPath = "D:\\Output\\eDaas\\";
        String downLoadPath = zipName;  
  
        long fileLength = new File(downLoadPath).length();  
        String realName = fileName+".zip";
       
        response.setHeader("Content-disposition", "attachment; filename="  
                + new String(realName.getBytes("utf-8")));  
        response.setHeader("Content-Length", String.valueOf(fileLength));  
  
	 
	    bis = new BufferedInputStream(new FileInputStream("D:\\Output\\eDaas\\"+fileName+".zip"));  
        bos = new BufferedOutputStream(response.getOutputStream());  
        byte[] buff = new byte[2048];  
        int bytesRead;  
        while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
            bos.write(buff, 0, bytesRead);  
        }  
        bis.close();  
        bos.close();  
	    
	}
	
	

	
	
	
	
	
	
	
	
}
