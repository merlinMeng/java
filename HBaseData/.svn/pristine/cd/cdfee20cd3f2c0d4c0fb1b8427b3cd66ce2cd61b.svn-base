package com.sky.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sky.pojo.Dictionary;
import com.sky.service.DictionaryService;

@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
	@Autowired
	private DictionaryService dicService;
	
	@RequestMapping("/turnlist")
	public String turnList(){
		return "main/dictionary/dic";
	}
	@RequestMapping("/pagination")
	public @ResponseBody Object queryForPagination(String start,String limit){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data", dicService.queryForPagination(start, limit));
		map.put("success", true);
		map.put("totalCount", dicService.countDictionary());
		return map;
	}
	@RequestMapping("/update")
	public void updateDictionary(String id,String examTypeID,String areaId,String areaName,String examYear){
		
		Dictionary dic = new Dictionary();
		dic.setId(id);
		dic.setExamTypeID(examTypeID);
		dic.setAreaId(areaId);
		dic.setAreaName(areaName);
		dic.setExamYear(examYear);
		dicService.updateDictionary(dic);
	}
	@RequestMapping("/delete")
	@ResponseBody
	public Object delDictionary(String id){
		Map<String,Object> map = new HashMap<String,Object>();
		dicService.delDictionary(id);
		map.put("success", true);
		return map;
	}
	@RequestMapping("/addDic")
	@ResponseBody
	public Object addDictionary(Dictionary dictionary){
		Map<String,Object> map = new HashMap<String,Object>();
		dicService.addDictionary(dictionary);
		map.put("success", true);
		return map;
	}
	
}
