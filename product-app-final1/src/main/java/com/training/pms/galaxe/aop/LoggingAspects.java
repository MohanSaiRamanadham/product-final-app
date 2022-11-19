package com.training.pms.galaxe.aop;



import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspects {

	@Before(value="execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
		public void doLogging() {
			System.out.println("looged in at:"+new Date()+"by Aspects");
		}
	@After(value="execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doSomeWork() {
		System.out.println("Do some work is called in at:"+new Date()+"by Aspects");
	}
	
	//here  to execute this function we should use ProceedingJoinPoint otherwise it will show error.
	@Around(value="execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	//return type of this method should match to the return type of method which are using this function.
	//if we want to use this function with every method then make return type to be "Object".
	public Object doSomeWork2(ProceedingJoinPoint point) throws Throwable {
		System.out.println("before method is called in at:"+new Date()+"by Aspects");
		Object retval=point.proceed();
		System.out.println("After method is called in at:"+new Date()+"by Aspects");

		return retval;
		
	}

}
