package com.gayathri.spring.service;

import java.util.List;
import java.util.Optional;

import com.gayathri.spring.model.User;

public interface UserService {
	 Optional<User> findByUsername(String user_name);
	 List<User> listOfAllUser();
	 User save(User user);
	 void delete(String user_name);
	 User update(String existingUserName, User user);

}
