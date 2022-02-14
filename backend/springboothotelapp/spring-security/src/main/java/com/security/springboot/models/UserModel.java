package com.security.springboot.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="users")
public class UserModel {

	@Id
	private String id;
	private String username;
	private String password;
	private String email;
	private Boolean isAdmin=false;
	private LocalDateTime time;
	public UserModel() {
		
	}
	
	public UserModel( String username, String password,String email) {
		super();
		
		this.username = username;
		this.password = password;
		this.email=email;
		this.time=LocalDateTime.now();
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
