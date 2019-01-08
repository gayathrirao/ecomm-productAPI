package com.gayathri.spring.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gayathri.spring.model.Category;




@Repository
public interface CategoryDaoRepository extends PagingAndSortingRepository<Category,Long> {



	List<Category> findAll();


}
