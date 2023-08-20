package com.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

	@Pointcut("execution(* com.spring.aop.*.*(..))")
	public void pointCut() {
	}

	@Before("pointCut()")
	public void beforeAdvice() {
		System.out.println("beforeAdvice: Going to setup Employee profile.");
	}

	@After("pointCut()")
	public void afterAdvice() {
		System.out.println("afterAdvice: Employee profile has been setup.");
	}

}
