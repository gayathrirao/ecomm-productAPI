package com.gayathri.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

@Aspect
@Component
public class RestAspect {
	
	Counter productModificationCounter = Metrics.counter("com.gayathri.spring.productModified");
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("execution (public * com.gayathri.spring.controller.*Controller.*(..))")
	public void onEveryMethod()
	{
		logger.info("Aspect invoked before any method of controller");
	}

	@After("execution (public * com.gayathri.spring.controller.*Controller.save(..))")
	public void OnUpdate()
	{
		logger.info("called only when a product is modified or created");
		productModificationCounter.increment();
		logger.info("Product is modified " + productModificationCounter.count() + " times");
	}
	
	@Around("execution (public * com.gayathri.spring.controller.*Controller.*(..))")
	public Object captureMetrics(ProceedingJoinPoint joinPoint) throws Throwable
	{
		long start = System.currentTimeMillis();
		try {
			String className = joinPoint.getSignature().getDeclaringTypeName();
			String methodName = joinPoint.getSignature().getName();
			Object result = joinPoint.proceed();
			long elapsedTime = System.currentTimeMillis() - start;
			logger.info("Method |" + className + "." + methodName + " ()" + "| execution time :| "
					+ elapsedTime + " |ms");
		
			return result;
		} catch (IllegalArgumentException e) {
			logger.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in "
					+ joinPoint.getSignature().getName() + "()");
			throw e;
		}
	}
}
