package com.userinfo.springmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userinfo.springmicroservice.model.User;
import com.userinfo.springmicroservice.service.UserService;

@CrossOrigin
@RestController
//@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/user")
	public List<User> getAllUser(){
		return this.userService.getAllUser();
	}
	
	@GetMapping("/user/{username}")
	public User getUser(@PathVariable("username") String username) {
		User user= this.userService.getUser(username);
		List booking=this.restTemplate.getForObject("http://booking-service/booking/user/"+username, List.class);
//		user.setBooking(booking);
		return user;
}
}