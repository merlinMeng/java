package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sky.pojo.DataPackage;
import com.sky.pojo.User;
import com.sky.service.DataPackageService;
import com.sky.service.PackageInfoService;
import com.sky.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml"})
public class TestService {
		@Autowired
		private UserService userService;
		@Autowired
		private DataPackageService dataPackageService;
		@Autowired
		private PackageInfoService pacService;
		
		@Test
		public void tesss(){
			User user = new User();
			user.setUserName("mqz");
			user.setPassWord("123");
			user.setUserGroup("2");
			user.setCreateDate(new Date());
			userService.save(user);
			
		}
		
		@Test
		public void queryUser(){
			List<User> list = new ArrayList<User>();
			
			list = userService.queryAll();
			System.out.println(list);
		}
		
		@Test
		public void match(){
			String username="mqz";
			String password="123";
			boolean bn =userService.matchUser(username, password);
			System.out.println(bn);
		}
		
		@Test
		public void queryDataPackage(){
			List<DataPackage> list = new ArrayList<DataPackage>();
			list = dataPackageService.queryByPackageId(2);
			System.out.println(list);
		}
		
		@Test
		public void queryById(){
			
			DataPackage dataPackage = dataPackageService.queryById(3);
			System.out.println(dataPackage);
		}
		@Test
		public void updateById(){
			
			DataPackage dataPackage = dataPackageService.queryById(3);
			dataPackage.setScanImgDir("dddd");
			dataPackageService.updateById(dataPackage);
		}
		@Test
		public void deleteById(){
			pacService.delPackageId(1);
		}
		@Test
		public void pagination(){
			String start ="5";
			String limit = "5";
			int count =dataPackageService.queyrForCount();
			System.out.println(count);
			System.out.println(dataPackageService.queyrForPagination(start, limit));
		}
}
