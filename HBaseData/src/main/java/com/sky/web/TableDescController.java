package com.sky.web;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.service.ColumnDescriptionService;
import com.sky.service.TableDescriptionService;

@Controller
@RequestMapping(value ="/table")
public class TableDescController {
	
	@Autowired
	private TableDescriptionService tableDescriptionService;
	@Autowired
	private ColumnDescriptionService columnDescriptionService;
	
	
	@RequestMapping(value="/listJson")
	@DateTimeFormat
	public @ResponseBody  Object dapamaList(){
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("data", tableDescriptionService.queryAll());  
        map.put("success", true); 
		return map;
	}
	
	@RequestMapping(value="/turnList")
	public  String tblDescList(){
		
		return "/main/table/tabledesc";
	}
	@RequestMapping(value="/listJsonForColumn")
	@DateTimeFormat
	public @ResponseBody  Object columnList(String tableName){
		
		Map<String,Object> map = new HashMap<String,Object>();  
        map.put("data", columnDescriptionService.queryById(tableName));  
        map.put("success", true); 
		return map;
	}
	
	
	
	
	
	
}
