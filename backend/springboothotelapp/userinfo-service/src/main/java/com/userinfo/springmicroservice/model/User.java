package com.userinfo.springmicroservice.model;

//import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
private String username;
private String email;
private Boolean isAdmin;
//private LocalDateTime time;
List<Booking> booking=new ArrayList<>();
public User() {
	
}
public User(String username, String email, Boolean isAdmin, List<Booking> booking) {
	super();
	this.username = username;
	this.email = email;
	this.isAdmin = isAdmin;
	//this.time = time;
	this.booking = booking;
}

public User(String username, String email, Boolean isAdmin) {
	super();
	this.username = username;
	this.email = email;
	this.isAdmin = isAdmin;
}

public String getUsername() {
	return username;
}

public String getEmail() {
	return email;
}

public Boolean getIsAdmin() {
	return isAdmin;
}


public List<Booking> getBooking() {
	return booking;
}
public void setBooking(List<Booking> booking) {
	this.booking = booking;
}




}
