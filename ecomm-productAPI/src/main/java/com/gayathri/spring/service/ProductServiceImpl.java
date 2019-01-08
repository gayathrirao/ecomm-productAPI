package com.gayathri.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gayathri.exception.HTTP404Exception;
import com.gayathri.spring.dao.ProductDaoRepository;
import com.gayathri.spring.model.Product;
import com.gayathri.spring.service.feign.CategoryFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;


@Service


public class ProductServiceImpl implements ProductService {

	  final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

   @Autowired
   private ProductDaoRepository productDao;
   
   @Autowired
   private CategoryFeignClient categoryClient;


   @Override
   @HystrixCommand(fallbackMethod = "saveProductWithoutValidation")
   public Product save(Product product) {
	   
	   if (product.getCategory() == null) {
		   logger.info("Product Category is null :");
		   throw new HTTP404Exception("Product Category is null");
	   }else {
		   
		   logger.info("Product Category is not null ID :"+product.getCategory().getId());
		 

	   }
	   
	   if (product.getParentCategory() == null) {
		   logger.info("Product Parent Category is null :");
		   throw new HTTP404Exception("Product's parent  Category is null");
	   }else {
		  
		   logger.info("Product Parent Category is not null Id :"+product.getParentCategory().getId());

	   }
	   
	   //Validate category exists or not
	   try {
		   if ( categoryClient.getCategory(product.getCategory().getId())==null)
		   {
			   logger.error("Invalid category assignment" +product.getCategory());
			 
		   }
		   if(categoryClient.getCategory(product.getParentCategory().getId())==null)
		   {
			   logger.error("Invalid parent category assignment" +product.getParentCategory());
			  
		   }
	   }
	   catch(Exception ex)
	   {
		   logger.error("Either product's category or parent category is invalid");
		   throw new HTTP404Exception("Invalid category id passed",ex);
	   }
      return  productDao.save(product);
   }

   @Override
   public Optional<Product> get(long id) {
      return productDao.findById(id);
   }

   @Override
   public List<Product> list() {
      return productDao.findAll();
   }

   @Override
   public Page<Product> getProductByPage(Integer PageNumber,Integer PageSize)
   {
	   Pageable pageable = PageRequest.of(PageNumber, PageSize);
	return productDao.findAll(pageable );
   }

   @Override
   public void update(long id, Product product) {
      //productDao.save(id, product);
	   productDao.save(product);
   }

  
   @Override
   public void delete(long id) {
      
      productDao.deleteById(id);
   }
   
   public Product saveProductWithoutValidation(Product prd)
   {
	  logger.info("Product insert failed and has reached hysterix circuit breaker method");
	  return  productDao.save(prd);
   }
}
