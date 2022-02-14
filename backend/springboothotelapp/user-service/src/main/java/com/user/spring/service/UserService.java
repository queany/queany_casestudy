package com.user.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.spring.model.User;
import com.user.spring.repository.UserRepository;

@Service
public class UserService{
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public User getUser(String username) {
		List<User> users=getAllUser();
		return users.stream().filter(user -> user.getUsername().equals(username)).findAny().orElse(null);
	}
		
//	public List<User> getBookingByUser(String username) {
//		List<User> bookings=getAllBooking();
//	 return bookings.stream().filter(booking ->booking.getUsername().equals(username)).collect(Collectors.toList());
//
//	}
	
	
}
