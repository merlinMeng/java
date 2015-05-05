package com.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sky.pojo.Dictionary;
import com.sky.service.DictionaryService;
import com.sky.service.JobInfoService;
import com.sky.service.PackageInfoService;
import com.sky.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class TestSpringWS {
	@Autowired
	private UserService us;
	@Autowired
	private DictionaryService dicService;
	@Autowired
	private JobInfoService js;
	
	@Autowired
	private PackageInfoService ps;
	
	@Test
	public void query(){
		us.matchUser("admin", "123");
	}
	@Test
	public void testDictionary(){
		Dictionary dic = new Dictionary();
		//dicService.addDictionary(dic);
		dicService.delDictionary("5");
	}
	@Test
	public void job(){
			long one = new Date().getTime();
			 try {
				ps.uploadImage();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 long two = new Date().getTime();
			 System.out.println(two-one);
		
	}
	
	
	
	
	
	
}
