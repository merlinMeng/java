package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sky.pojo.ImageJob;
import com.sky.service.ImageJobService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class TestImageJob {
	@Autowired
	private ImageJobService imageServ;
	
	@Test
	public void testadd(){
		ImageJob image = new ImageJob();
		image.setExamType("zikao");
		image.setYear("2012");
		image.setAreaId("11");
		image.setStatus("0");
		imageServ.addImageJob(image);
	}
	@Test
	public void testquery(){
		ImageJob image = new ImageJob();
		image = imageServ.queryImageJobForId("1");
		System.out.println(image.toString());
	}
	
}
