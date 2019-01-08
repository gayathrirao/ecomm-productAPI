package com.gayathri.spring.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.gayathri.spring.model.Category;

@FeignClient(name = "ecomm-categoryAPI")
public interface CategoryFeignClient {

	  @GetMapping("/category/{id}")
	   public Category getCategory(@PathVariable("id") long id);
}
