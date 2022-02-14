package com.userinfo.springmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.springmicroservice.model.User;
import com.userinfo.springmicroservice.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
//	List<User> list=List.of(
//			new User("Queany","queanycarol@gmail.com",false),
//			new User("Kevin","kevin@gmail.com",false),
//			new User("Ethan","ethanl@gmail.com",false),
//			new User("Luke","luke@gmail.com",false)
//			);
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User getUser(String username) {
		List<User> users=getAllUser();
		return users.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
	}
	
	


}
