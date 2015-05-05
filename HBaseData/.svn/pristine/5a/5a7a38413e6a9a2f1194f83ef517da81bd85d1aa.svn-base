package com.sky.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sky.service.UserService;

@Controller
@RequestMapping(value ="/login")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index",method=RequestMethod.GET)
	public String loginPage(){
		return "/login/index";
	}
	
	@RequestMapping(value = "/validlogin")
	public String matchUser(HttpServletRequest request,HttpServletResponse respone,String userName,String password,HttpSession session){
		boolean isValid =userService.matchUser(userName, password);
		if(isValid==false){
			request.setAttribute("msg", "账号或密码错误！");
			return  "/login/index";
		}
		session.setAttribute("userName", userName);
		session.setAttribute("password", password);
		respone.addCookie(new Cookie("userName",userName));
		respone.addCookie(new Cookie("password",password));
		return "/main/main";
	}
	
	@RequestMapping(value = "/loginExit")
	public String matchUser(HttpSession session){
		session.invalidate();
		return "/login/index";
	}
	
}
