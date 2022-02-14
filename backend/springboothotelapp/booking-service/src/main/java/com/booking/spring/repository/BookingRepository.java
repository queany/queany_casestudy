package com.booking.spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booking.spring.model.Booking;
//import com.rooms.spring.model.Rooms;


@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
		public Booking findByUsername(String username);
		public Optional<Booking> findById(String id);


}
