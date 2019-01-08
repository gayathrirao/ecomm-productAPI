package com.gayathri.spring.service;

import java.util.List;
import java.util.Optional;

import com.gayathri.spring.model.User;

public interface UserService {
	public Optional<User> findByUsername(String user_name);
	public List<User> listOfAllUser();
	public User save(User user);
	public User update(User user);
	public void delete(String user_name);

}
