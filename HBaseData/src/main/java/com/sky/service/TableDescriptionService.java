package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.TableDescriptionDao;
import com.sky.pojo.TableDescription;

@Service
public class TableDescriptionService {
	@Autowired
	private TableDescriptionDao tableDescriptionDao ;
	
	public List<TableDescription> queryAll() {
		return tableDescriptionDao.query();
	}
	
	public TableDescription queryById(String id) {
		return tableDescriptionDao.queryById(id);
	}
	

	
}
