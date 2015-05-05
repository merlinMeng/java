package com.sky.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspectJ {
	@Pointcut(
			"execution(* com.sky.dao.UserDao.getMatchCount(..))")
	public void tet(){}
	@Before("tet()")
	public void say(){
		System.out.println("begin......................................................");
	}
	@AfterReturning("tet()")
	public void after(){
		System.out.println("after..........");
	}
	
	
}
