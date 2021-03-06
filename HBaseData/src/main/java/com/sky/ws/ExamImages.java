package com.sky.ws;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.service.JobInfoService;
import com.sky.util.HandleSmallFiles;
import com.sky.util.StringTool;

@Controller
@RequestMapping("/examimages")
public class ExamImages {
	@Autowired
	private JobInfoService jobService;
	@RequestMapping(value="/{examType}/{examYear}/{areaId}",method = RequestMethod.GET)
	@ResponseBody
	public Object getStudentResult(@PathVariable String examType,@PathVariable String examYear,
			@PathVariable String areaId,@RequestParam String url  ) throws Exception{
		StringBuilder  sbUrl =new StringBuilder();
		String path = "http://10.8.4.21:8080/images";
		String cleanUrl = new StringTool().dealUrl(url);
		String absolutePath ="D:/apache-tomcat-6.0.39/webapps/images";
		
//		HandleSmallFiles hf = new HandleSmallFiles();
//		String dst = hf.mapFileReader(examType, examYear, areaId, cleanUrl, absolutePath);
//		//判断图片是否存在
//		StringBuilder  absoluteUrl =new StringBuilder();
//		absoluteUrl.append(absolutePath).append(dst);
//		File file = new File(absoluteUrl.toString());
//		if(file.isFile()){
//			sbUrl.append(path).append(dst);
//		}else{
//			sbUrl.append("404");
//		}
		//判断图片是否存在
		StringBuilder  absoluteUrl =new StringBuilder();
		absoluteUrl.append(absolutePath).append("/");
		absoluteUrl.append(examType).append("/").append(examYear).append("/").append(areaId)
		.append("/tif/").append(cleanUrl);
		System.out.println(absoluteUrl.toString());
		File file = new File(absoluteUrl.toString());
		if(file.isFile()){
			sbUrl.append(path).append("/");
			sbUrl.append(examType).append("/").append(examYear).append("/").append(areaId)
			.append("/tif/").append(cleanUrl);
		}else{
			sbUrl.append("404");
		}		
		return sbUrl.toString();
	}
}
