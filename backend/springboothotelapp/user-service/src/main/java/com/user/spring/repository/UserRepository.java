package com.user.spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.user.spring.model.User;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
		public User findByUsername(String username);
//		public Booking findById(String id);


}
