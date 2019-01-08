package com.gayathri.spring.service;

import java.util.List;

import com.gayathri.spring.model.Category;



public interface CategoryService {

	Category save(Category category);
	Category get(long id);
   List<Category> list();
   void update(long id, Category category);
   void delete(long id);
}
