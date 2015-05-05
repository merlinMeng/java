package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.DictionaryDao;
import com.sky.pojo.Dictionary;

@Service
public class DictionaryService {
	@Autowired
	private DictionaryDao dicDao;
	
	public Dictionary queryById(String id){
		return dicDao.queryById(id);
	}
	
	public List<Dictionary> queryForPagination(String start,String limit){
		return dicDao.queyrForPagination(start, limit);
	}
	
	public int queryMaxId(){
		
		return dicDao.queryMaxId()+1;
	}
	
	public void addDictionary(Dictionary dictionary){
		dictionary.setId(queryMaxId()+"");
		
		dicDao.addDictionary(dictionary);
	}
	
	public int countDictionary(){
		return dicDao.countDictionary();
	}
	
	public void updateDictionary(Dictionary dictionary){
		 dicDao.updateDictionary(dictionary);
	}
	
	public void delDictionary(String id){
		dicDao.delDictionary(id);
	}
	
	
}
