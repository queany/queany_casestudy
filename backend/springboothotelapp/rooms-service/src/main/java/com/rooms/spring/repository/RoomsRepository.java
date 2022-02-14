package com.rooms.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rooms.spring.model.Rooms;

@Repository
public interface RoomsRepository extends MongoRepository<Rooms, String> {
	public Rooms findByid(String id);

}
