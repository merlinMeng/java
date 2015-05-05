package com.sky.web;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sky.pojo.PackageDic;
import com.sky.pojo.PackageInfo;
import com.sky.service.JobInfoService;
import com.sky.service.PackageInfoService;
import com.sky.util.BeginJob;

@Controller
@RequestMapping(value ="/packageinfo")
public class PackageInfoController {
	
	private final static Logger  logger = Logger.getLogger(PackageInfoController.class);
	
	@Autowired
	private PackageInfoService PackageInfoService;
	@Autowired
	private JobInfoService jobInfoService;
	
	
	@RequestMapping(value="/listJson")
	public @ResponseBody  Object dapamaList(){
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("root", PackageInfoService.queryAll());  
        map.put("success", true); 
		return map;
	}
	
	@RequestMapping(value="/listjsonforpagination")
	public @ResponseBody  Object dapamaListForPagination(String start,String limit){
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("data", PackageInfoService.queyrForPagination(start, limit));  
        map.put("success", true); 
        map.put("totalCount", PackageInfoService.countPackageInfo());
       return map;
	}
	@RequestMapping(value="/turnList")
	public String turnDapamaList(){
		return "main/dapama/packageInfo";
	}
	
	@RequestMapping(value="/pojoJson")
	@ResponseBody
	public Object queryById(int packageId){
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("data", PackageInfoService.queryById(packageId));  
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
		BufferedReader br = new BufferedReader(new InputStreamReader(mFile.getInputStream()));
		String[] jpd = new String[10];
		int i=0;
		while((line=br.readLine())!=null){
			jpd[i]=line;
			i++;
		}
		return "main/dapama/adddapama";
	}
	@RequestMapping(value="/createJob")
	@ResponseBody
	public Object createJob(int[] packageIds){
		
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("success", true);  
		List<Integer> list = new ArrayList<Integer>();
		for(int packageId:packageIds){
			int jobId = jobInfoService.save(packageId);
			PackageInfo packageInfo = PackageInfoService.queryById(packageId);
			if(packageInfo.getState().equals("END")){
				//暂时删除。。
				//BeginJob.createFile(packageInfo.getExamTypeID(), packageInfo.getExamYear(), packageInfo.getAreaId(),jobId);
				//命令 ***.exe + 参数 packageInfo.getExamTypeID(), packageInfo.getExamYear(), packageInfo.getAreaId(),jobId
//				String cmdStr = "D:\\python\\plsc\\EdAnalysisCtrlMultiProcess.exe "+packageInfo.getExamTypeID()+" "+packageInfo.getExamYear()+" "+packageInfo.getAreaId()+" D:\\Output\\eDaas "+jobId;
//				System.out.println(cmdStr);
//				BeginJob bj =new BeginJob(cmdStr);
//				Thread td = new Thread(bj);
//				td.start();
				//bj.createFile(cmdStr);
			}else{
				list.add(packageId);
			}
		}
		map.put("ids", list);
		
		
        return map;  
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public Object deletePackageInfo(int id){
		PackageInfoService.delPackageId(id);
		Map<String,Object> map = new HashMap<String,Object>();  
		map.put("success", true);  
		return map;
	}
	
	//ws rest
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	@ResponseBody
	public  Object packageInfo(){
		List<PackageDic> list = new ArrayList<PackageDic>();
		for(PackageInfo pinfo :PackageInfoService.queryAll()){
			PackageDic dic = new PackageDic();
			dic.setAreaId(pinfo.getAreaId());
			dic.setExamTypeID(pinfo.getExamTypeID());
			dic.setExamYear(pinfo.getExamYear());
			list.add(dic);
		}
		return list;
	}
	
}
