package com.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sky.pojo.JobInfo;
import com.sky.service.JobInfoService;
import com.sky.service.PackageInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class jobTestService {
		@Autowired
		private JobInfoService jobInfoService;
		
		@Autowired
		private PackageInfoService ps;
		
		@Test
		public void tesss(){
			
			ps.delPackageId(1);
		}
		@Test
		public void te1(){
			for(JobInfo jobInfo:jobInfoService.queryAll()){
				System.out.println(jobInfo.toString());
			}
		}
		
		
		
}
