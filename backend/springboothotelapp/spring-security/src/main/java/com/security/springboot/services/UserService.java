package com.security.springboot.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.springboot.models.UserModel;
import com.security.springboot.models.UserRepository;

@Service
public class UserService implements UserDetailsService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel founderUser=userRepository.findByUsername(username);
		if(founderUser==null) return null;
		String name=founderUser.getUsername();
		String password=founderUser.getPassword();
		
		return new User(name, password, new ArrayList<>());
		
		
		
	}
 
}
