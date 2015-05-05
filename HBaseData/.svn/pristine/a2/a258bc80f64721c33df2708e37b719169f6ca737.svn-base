package com.sky.web;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.sky.pojo.DataPackage;
import com.sky.pojo.JsonJdfCourse;
import com.sky.pojo.JsonJdfPackage;
import com.sky.pojo.PackageInfo;
import com.sky.service.DataPackageService;
import com.sky.service.PackageInfoService;

@Controller
@RequestMapping(value ="/dapama")
public class DaPaMaController {
	
	private static final Logger logger = Logger.getLogger(DaPaMaController.class);
	@Autowired
	private DataPackageService dataPackageService;
	@Autowired
	private PackageInfoService packageInfoService;
	
	@RequestMapping(value="/listJson")
	public @ResponseBody  Object dapamaList(){
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("root", dataPackageService.queryAll());  
        map.put("success", true); 
		return map;
	}
	
	@RequestMapping(value="/listcoursejson")
	public @ResponseBody  Object courseList(Integer packageId){
		Map<String,Object> map = new HashMap<String,Object>();  
		System.out.println(packageId+"-packageId-");
		if(packageId==null){
			map.put("data", null);  
		}else{
			map.put("data", dataPackageService.queryByPackageId(packageId));  
		}
        map.put("success", true); 
		return map;
	}
	
	@RequestMapping(value="/listJsonForPagination")
	public @ResponseBody  Object dapamaListForPagination(String start,String limit){
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("data", dataPackageService.queyrForPagination(start, limit));  
        map.put("success", true); 
        map.put("totalCount", dataPackageService.queyrForCount()); 
       return map;
	}
	@RequestMapping(value="/turnList")
	public String turnDapamaList(){
		return "main/dapama/dapama";
	}
	
	@RequestMapping(value="/pojoJson")
	@ResponseBody
	public Object queryById(int packageId){
		
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("data", dataPackageService.queryById(packageId));  
        map.put("success", true);  
        return map;  
	}
	

	
	@RequestMapping(value="/updateDataPackage")
	@ResponseBody
	public Object updateById(DataPackage dataPackage){
	
		 dataPackageService.updateById(dataPackage);
		 Map<String,Object> map = new HashMap<String,Object>();  
		 map.put("success", true);  
		 return map;
	}
	
	@RequestMapping(value="/deleteDataPackage")
	@ResponseBody
	public Object updateById(int[] packageIds){
	
		 dataPackageService.deleteById(packageIds);
		 Map<String,Object> map = new HashMap<String,Object>();  
		 map.put("success", true);  
		 return map;
	}
	
	@RequestMapping(value="/peparedaddList")
	public String peparedaddList(String[] packageIds){
		return "main/dapama/adddapama";
	}
	
	@RequestMapping(value="/addList")
	@ResponseBody
	public Object addList(@RequestParam("datapaSource") String name,
			@RequestParam("datapaDescri") CommonsMultipartFile mFile) throws Exception{
		String line= null;
		BufferedReader br = new BufferedReader(new InputStreamReader(mFile.getInputStream(),"UTF-8"));
		String[] jpfTemp = new String[10];
		int i=0;
		while((line=br.readLine())!=null){
			jpfTemp[i]=line;
			i++;
		}
		
		br.close();
		//转化成JsonJdfPackage 对象
		JsonJdfPackage jsonPackage = JSON.parseObject(jpfTemp[2], JsonJdfPackage.class);
		

		//把JsonJdfPackage对象转成 packageinfo和datapackage
		
		PackageInfo packInfo = new PackageInfo();
	
		packInfo.setExamName(jsonPackage.getExamName());
		packInfo.setExamTypeID(jsonPackage.getExamTypeID());
		packInfo.setAreaId(jsonPackage.getAreaId());
		packInfo.setAreaName(jsonPackage.getAreaName());
		packInfo.setExamYear(jsonPackage.getExamYear());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		packInfo.setExamDate(sdf.parse(jsonPackage.getExamYear()+"-6-9"));
		packInfo.setCourseNum(Integer.parseInt(jsonPackage.getCourseNum()));
		packInfo.setRootDir(name);
		packInfo.setCourseStr(jsonPackage.getCourseStr());
		packInfo.setReg_Date(new Date());
		//1 初始状态 REGISTER 2  正在处理 PROCESSING  3正在上传 UPLOADING  4 上传完毕 END
		packInfo.setState("REGISTER");
		packInfo.setImageUploadStatus("0");
		packageInfoService.addPackageInfo(packInfo);
		int packageId = packageInfoService.queryMaxId();
		
		//装成科目信息表
		for(JsonJdfCourse jsonJdfCourse:jsonPackage.getKm()){
			DataPackage dataPackage = new DataPackage();
			dataPackage.setPackageId(packageId);
			dataPackage.setExamName(packInfo.getExamName());
			dataPackage.setCourseId(jsonJdfCourse.getCourseId());
			dataPackage.setCourseName(jsonJdfCourse.getCourseName());
			dataPackage.setBMKFileName(jsonJdfCourse.getBMKFileName());
			dataPackage.setBMKMode(jsonJdfCourse.getBMKMode());
			dataPackage.setScanFileName(jsonJdfCourse.getScanFileName());
			dataPackage.setScanMode(jsonJdfCourse.getScanMode());
			dataPackage.setPjFileName(jsonJdfCourse.getPjFileName());
			dataPackage.setPjMode(jsonJdfCourse.getPjMode());
			dataPackage.setCjFileName(jsonJdfCourse.getCjFileName());
			dataPackage.setCjMode(jsonJdfCourse.getCjMode());
			dataPackage.setScanImgDir(jsonJdfCourse.getScanImgDir());
			dataPackage.setWriteItemId(0); 
			dataPackage.setCardNum(0);
			dataPackage.setFullScore(Integer.parseInt(jsonJdfCourse.getFullScore()));
			dataPackage.setKgMaxScore(Double.parseDouble(jsonJdfCourse.getKgMaxScore()));
			dataPackage.setZHgMaxScore(dataPackage.getFullScore()-dataPackage.getKgMaxScore());
			dataPackageService.addDataPackage(dataPackage);
		}
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("success", true);  
		
		return map;
	}
	
	@RequestMapping(value="/pepareddownList")
	public String pepareddownList(){
		return "main/dapama/downdapama";
	}
	
	@RequestMapping(value="/downList")
	@ResponseBody
	public Object downList(String examType,String year,String area,String filedir){
		
		String cmdStr = "D:\\python\\dist\\EdAnalysisCtrl.exe "+examType+" "+year+" "+area+" "+filedir;
		System.out.println(cmdStr);
		try{
			Process ob=  Runtime.getRuntime().exec(cmdStr);
			
			BufferedReader brInput = new BufferedReader(new InputStreamReader(ob.getInputStream()));
			  String str = null;
			  while((str=brInput.readLine())!=null){
				 logger.info(str);
			 }
			 BufferedReader brError = new  BufferedReader(new InputStreamReader(ob.getErrorStream()));
			
			 while((str=brError.readLine())!=null){
				 logger.info(str);
			 }
			 brInput.close();
			 brError.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("success", true);  
		return map;
	}
}
