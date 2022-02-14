package com.user.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.spring.model.Booking;
import com.user.spring.model.User;
import com.user.spring.model.UserResponse;
import com.user.spring.service.UserService;

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
		return userService.getAllUser();
	}
	
	@GetMapping("/user/{username}")
	public User getUser(@PathVariable("username") String username) {
		User user = userService.getUser(username);
		if (user != null) {
			List booking=restTemplate.getForObject("http://booking-service/booking/user/"+username, List.class);
//			System.out.println(booking.toString());
			user.setBooking(booking);
		}
		return user;
		
}
	@GetMapping("/check/{username}")
	private ResponseEntity<?> checkUsername(@PathVariable("username") String username) {
		User user = userService.getUser(username);
		if (user != null) {
			return ResponseEntity.ok(new UserResponse("invalid"));
		} else {
			return ResponseEntity.ok(new UserResponse("valid"));
		}
	}
	
}
