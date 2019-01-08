package com.gayathri.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gayathri.spring.dao.CategoryDaoRepository;
import com.gayathri.spring.model.Category;



@Service

public class CategoryServiceImpl implements CategoryService {

   @Autowired
   private CategoryDaoRepository categoryDao;

  
   @Override
   public Category save(Category category) {
      return categoryDao.save(category);
   }

   @Override
   public Category get(long id) {
     Optional<Category> category = categoryDao.findById(id);
	return category.get();
   }

   @Override
   public List<Category> list() {
    return categoryDao.findAll();
   }

 
   @Override
   public void update(long id, Category category) {
       categoryDao.save(category);
   }


   @Override
   public void delete(long id) {
	   Optional<Category> category = categoryDao.findById(id);
      categoryDao.delete(category.get());
   }

}
