package com.gayathri.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.gayathri.spring.dao.UserDaoRepository;
import com.gayathri.spring.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDaoRepository userdao ;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Optional<User> findByUsername(String user_name) {
		User user = new User();
		user.setUserName(user_name);
		Example<User> example = Example.of(user);
		Optional<User> foundUser =  userdao.findOne(example );
		if (foundUser != null) logger.info("User found "+ foundUser.get());
		return foundUser;
		
				
	}

	@Override
	public List<User> listOfAllUser() {

		return userdao.findAll();
	}

	@Override
	public User save(User user) {
		return userdao.save(user);
	}

	@Override
	public User update(String existingUserName,User user) {
		Optional<User> existingUser = findByUsername(existingUserName);
		if ( existingUser.get() != null) 
				userdao.delete(existingUser.get());
		return userdao.save(user);
	}

	@Override
	public void delete(String user_name) {
		Optional<User> usrTobeDeleted = findByUsername(user_name);
		if (usrTobeDeleted !=null)
		   userdao.delete(usrTobeDeleted.get());
		
		
	}


}
