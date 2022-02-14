package com.user.spring.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
public class User {
	@Id
private String id;
private String username;
private String email;
private Boolean isAdmin;
List<Booking> booking=new ArrayList<>();
public User() {
	
}
public User(String username, String email, Boolean isAdmin, List<Booking> booking) {
	super();
	this.username = username;
	this.email = email;
	this.isAdmin = isAdmin;
	this.booking = booking;
}

public User(String username, String email, Boolean isAdmin) {
	super();
	this.username = username;
	this.email = email;
	this.isAdmin = isAdmin;
}

@Override
public String toString()
{
	return this.username + " " + this.email + " " + this.isAdmin + " " + this.booking;
}


public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Boolean getIsAdmin() {
	return isAdmin;
}
public void setIsAdmin(Boolean isAdmin) {
	this.isAdmin = isAdmin;
}
public List<Booking> getBooking() {
	return booking;
}
public void setBooking(List<Booking> booking) {
	this.booking = booking;
}

}
