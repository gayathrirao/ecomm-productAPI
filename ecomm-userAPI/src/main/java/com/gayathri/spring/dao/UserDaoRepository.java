package com.gayathri.spring.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gayathri.spring.model.User;

public interface UserDaoRepository extends MongoRepository<User, String>{
	
	
}
