package com.gayathri.spring.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gayathri.spring.model.Product;
@Repository
public interface ProductDaoRepository extends PagingAndSortingRepository<Product,Long>{
	List<Product> findAll();

}
