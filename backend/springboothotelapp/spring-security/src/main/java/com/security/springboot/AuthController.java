package com.security.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import com.security.springboot.models.AuthenticationRequest;
import com.security.springboot.models.AuthenticationResponse;
import com.security.springboot.models.UserModel;
import com.security.springboot.models.UserRepository;

@CrossOrigin
@RestController
public class AuthController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;

//	@Autowired
//	private RestTemplate restTemplate;
	
	
	@PostMapping("/subs")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest ){
	String username=authenticationRequest.getUsername();
	String password=authenticationRequest.getPassword();
	String email=authenticationRequest.getEmail();
	UserModel userModel =new UserModel(username,password,email);
	
	try {
		userRepository.save(userModel);	
	} catch (Exception e) {
		return ResponseEntity.ok(new AuthenticationResponse("error") );
	}
	
	
	return ResponseEntity.ok(new AuthenticationResponse("Registeration successful") );
	
	}
	
	
	@PostMapping("/auth")
private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest ){
		String username=authenticationRequest.getUsername();
		String password=authenticationRequest.getPassword()	;
		String email=authenticationRequest.getEmail();
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Authentication error") );
		} 
		
//		finally {
//			this.restTemplate.getForObject("http://booking-service/booking/user/"+username, List.class);
//			user.setBooking(booking);
//			return user;
//		}
		
		
		return ResponseEntity.ok(new AuthenticationResponse("Authentication successful") );	
	}
	
	
}
