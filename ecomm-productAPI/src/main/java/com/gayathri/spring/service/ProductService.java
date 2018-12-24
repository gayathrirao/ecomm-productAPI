package com.gayathri.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.gayathri.spring.model.Product;

public interface ProductService {

   Product save(Product product);
   Optional<Product> get(long id);
   List<Product> list();
   void update(long id, Product product);
   void delete(long id);
   Page<Product> getProductByPage(Integer PageNumber,Integer PageSize);
}
