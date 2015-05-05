package com.sky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.ColumnDescriptionDao;
import com.sky.pojo.ColumnDescription;

@Service
public class ColumnDescriptionService {
	@Autowired
	private ColumnDescriptionDao columnDescriptionDao ;
	
	public List<ColumnDescription> queryAll() {
		return columnDescriptionDao.query();
	}
	public List<ColumnDescription> queryById(String id) {
		return columnDescriptionDao.queryById(id);
	}
}
