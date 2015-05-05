package com.sky.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sky.dao.ImageJobDao;
import com.sky.pojo.ImageJob;

@Service
public class ImageJobService {
	@Autowired
	private ImageJobDao dao;
	
	public void addImageJob(ImageJob imageJob){
		dao.addImageJob(imageJob);
	}
	
	public ImageJob queryImageJobForId(String id){
		return dao.queryById(id);
	}
}
