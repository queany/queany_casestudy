package com.booking.spring.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.booking.spring.model.Booking;

@Repository
public interface BookingRepositoryById extends MongoRepository<Booking, String> {
	public Optional<Booking> findById(String id);
}