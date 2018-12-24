package com.gayathri.spring.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.gayathri.exception.HTTP400Exception;
import com.gayathri.exception.HTTP404Exception;
import com.gayathri.exception.HTTP500Exception;
import com.gayathri.exception.RestAPIExceptionInfo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

public class AbstractController implements ApplicationEventPublisherAware {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	private ApplicationEventPublisher eventPublisher;
	Counter HTTP400ErrorCounter = Metrics.counter("HTTP400");
	Counter HTTP404ErrorCounter = Metrics.counter("HTTP404");
	Counter HTTP500ErrorCounter = Metrics.counter("HTTP500");
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.setEventPublisher(applicationEventPublisher);
		
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HTTP400Exception.class)
	public @ResponseBody RestAPIExceptionInfo handleBadRequest( HTTP400Exception ex,
				WebRequest request, HttpServletResponse response)
	{
		logger.error("The resource is not found");
		RestAPIExceptionInfo exceptionInfo = new RestAPIExceptionInfo(ex.getMessage(), "Bad Request ");
		HTTP400ErrorCounter.increment();
		return exceptionInfo;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(HTTP404Exception.class)
	public @ResponseBody RestAPIExceptionInfo handleResourceNotFound( HTTP404Exception ex,
			WebRequest request, HttpServletResponse response)
	{
		logger.error("The resource is not found");
		RestAPIExceptionInfo exceptionInfo = new RestAPIExceptionInfo(ex.getMessage(), "Resource Not found");
		HTTP404ErrorCounter.increment();
		return exceptionInfo;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(HTTP500Exception.class)
	public @ResponseBody RestAPIExceptionInfo handleResourceNotFound( HTTP500Exception ex,
			WebRequest request, HttpServletResponse response)
	{
		logger.error("The resource is not found");
		RestAPIExceptionInfo exceptionInfo = new RestAPIExceptionInfo(ex.getMessage(), "Resource Not found");
		HTTP500ErrorCounter.increment();
		return exceptionInfo;
	}

	public ApplicationEventPublisher getEventPublisher() {
		return eventPublisher;
	}

	public void setEventPublisher(ApplicationEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}
	
	public  <T> T checkResourceFound(final T resource) {
		if (resource == null) {
			throw new HTTP404Exception("Recource Not Found");
		}
		return resource;
	}

}
