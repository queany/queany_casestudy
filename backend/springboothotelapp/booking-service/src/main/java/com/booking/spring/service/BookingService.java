package com.booking.spring.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.spring.model.Booking;
import com.booking.spring.repository.BookingRepository;
import com.booking.spring.repository.BookingRepositoryById;

@Service
public class BookingService{
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private BookingRepositoryById bookingRepositoryById;
	
	public Booking create(Booking obj) {
		return bookingRepository.save(obj);

}
	public Booking cancel(String Id) {
		Booking booking = getBookingById(Id).orElse(null);
		booking.setStatus("cancelled");
		return bookingRepository.save(booking);
	}
	
	public List<Booking> getAllBooking(){
		return bookingRepository.findAll();
		
	}
	
	public Optional<Booking> getBookingById(String Id) {
		return bookingRepository.findById(Id);
	}
	
//	public Booking findById(String id) {
//		return bookingRepository.findById(id);
//		
//	}
	
	public Booking findByUsername(String username) {
		return bookingRepository.findByUsername(username);
		
	}
	
//	@Autowired
//	private BookingRepositoryForId bookingRepositoryForId;
//	public void deleteById(String id) {
//		Booking b=bookingRepositoryForId.findById(id);
//		bookingRepository.delete(b);
//	}
	
//List<Booking> list=List.of(
//		new Booking("adbcxsd12", "Queany", "12345df", "2022-01-2","2022-01-6",2,6000f),
//		new Booking("adbcxsd13", "Queany", "12345de", "2022-01-5","2022-01-6",1,6000f),
//		new Booking("adbcxsd14", "Ethan", "12345dg", "2022-01-7","2022-01-8",1,6000f),
//		new Booking("adbcxsd15", "Luke", "12345dj", "2022-01-9","2022-01-10",1,6000f)
//		);

	public List<Booking> getBookingByUser(String username) {
		List<Booking> bookings=getAllBooking();
//		bookings.stream().forEach(booking -> System.out.println(booking));
		 return bookings.stream().filter(booking -> booking.getUsername().equals(username)).collect(Collectors.toList());

	}
	
	
}
