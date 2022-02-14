package com.booking.spring.controller;

import java.util.List;
import java.util.Optional;

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

import com.booking.spring.model.Booking;
import com.booking.spring.model.BookingResponse;
import com.booking.spring.service.BookingService;
import com.booking.spring.service.BookingService;

@CrossOrigin
@RestController
//@RequestMapping("/booking")
public class BookingController {	
	@Autowired
	private BookingService bookingService;
//	public List<Booking> getBooking(){
//		return this.bookingService.getAllBooking();
//		}
	@GetMapping("/booking/{id}")
	public Optional<Booking> getBookingById(@PathVariable("id") String id){
		return this.bookingService.getBookingById(id);
		}
	
	@GetMapping("/booking/user/{username}")
	public List<Booking> getBooking(@PathVariable("username") String username){
		return this.bookingService.getBookingByUser(username);
		}
	
	@GetMapping("/booking")
	public List<Booking> getAllBooking() {
		return bookingService.getAllBooking();
		
	}
	
	@PostMapping("/booking")
	private ResponseEntity<?> create(@RequestBody Booking bookingRequest) {
		try {
			bookingService.create(bookingRequest);	
		} catch (Exception e) {
			return ResponseEntity.ok(new BookingResponse("error"));
		}
		
		return ResponseEntity.ok(new BookingResponse("ok"));
	}
	
	@PutMapping("/booking/{bookingid}")
	private ResponseEntity<?> cancel(@PathVariable String bookingid){
		System.out.println(bookingid);
		try {
			bookingService.cancel(bookingid);	
		} catch (Exception e) {
			return ResponseEntity.ok(new BookingResponse("error"));
		}
		
		return ResponseEntity.ok(new BookingResponse("ok"));
	}
	
	@DeleteMapping("/booking/{id}")
	private ResponseEntity<?> delete(@PathVariable String id) {
		try {
			if(id!="") {
//				bookingService.deleteById(id);
			}	
		} catch (Exception e) {
			return ResponseEntity.ok(new BookingResponse("deletion unsuccessful"));
		}
		
		return ResponseEntity.ok(new BookingResponse("Deleted "+id));
	}
}
