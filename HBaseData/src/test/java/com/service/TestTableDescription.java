package com.service;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sky.service.ColumnDescriptionService;
import com.sky.service.PackageInfoService;
import com.sky.service.TableDescriptionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class TestTableDescription {
	@Autowired
	private TableDescriptionService tableDescriptionService;
	
	@Autowired
	private ColumnDescriptionService colunmDescriptionService;
	
	@Autowired
	private PackageInfoService PackageInfoService;
	
	@Test
	public void query(){
		// tableDescriptionService.queryAll();
		//System.out.println(tableDescriptionService.queryAll());
		
		Date date = tableDescriptionService.queryAll().get(0).getCreateDate();
		System.out.println(date.toString());
	}
	@Test
	public void queryCol(){
		
		//System.out.println(colunmDescriptionService.queryAll());
		System.out.println(colunmDescriptionService.queryById("TBL_SCORE_STUDENT_SCANIMAGE"));
	}
	@Test
	public void queryPackageInfo(){
		System.out.println(PackageInfoService.queryAll().get(0).toString());
	}
	
	
	
	
}
