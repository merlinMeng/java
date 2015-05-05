package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.DataPackageDao;
import com.sky.pojo.DataPackage;

@Service
public class DataPackageService {
	@Autowired
	private DataPackageDao dataPackageDao;
	
	public List<DataPackage> queryAll() {
		return dataPackageDao.query();
	}
	
	public DataPackage queryById(int id) {
		return dataPackageDao.queryById(id);
	}
	public List<DataPackage> queryByPackageId(int id) {
		return dataPackageDao.queryByPackageId(id);
	}
	
	public void updateById(DataPackage dataPackage) {  
		dataPackageDao.updateById(dataPackage);
    }  
	public void deleteById(int[] ids) {  
		for(int id :ids){
			dataPackageDao.deleteById(id);
		}
	}  
	
	public int queyrForCount(){
		return dataPackageDao.queyrForCount();
	}
	
	public List<DataPackage> queyrForPagination(String start,String limit){
		
		return dataPackageDao.queyrForPagination(start, limit);
	}
	
	public void addDataPackage(DataPackage dataPackage){
		dataPackageDao.addDataPackage(dataPackage);
	}
}
