package com.sky.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class Memu {
	
	
	@RequestMapping("/menuList")
	public String menuList(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("begin..........");
		
		String jav = "['tinking in java'],['java base']";
		String books = "["+jav+"]";
		response.getWriter().write(books);
		return null;
	}

}
