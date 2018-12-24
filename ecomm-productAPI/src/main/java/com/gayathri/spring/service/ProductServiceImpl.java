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

import com.gayathri.spring.dao.ProductDaoRepository;
import com.gayathri.spring.model.Product;


@Service

public class ProductServiceImpl implements ProductService {

	  final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

   @Autowired
   private ProductDaoRepository productDao;
   
  


   @Override
   public Product save(Product product) {
	   
	   if (product.getCategory() == null) {
		   logger.info("Product Category is null :");
	   }else {
		   
		   logger.info("Product Category is not null ID :"+product.getCategory().getId());

	   }
	   
	   if (product.getParentCategory() == null) {
		   logger.info("Product Parent Category is null :");
	   }else {
		  
		   logger.info("Product Parent Category is not null Id :"+product.getParentCategory().getId());

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

}
