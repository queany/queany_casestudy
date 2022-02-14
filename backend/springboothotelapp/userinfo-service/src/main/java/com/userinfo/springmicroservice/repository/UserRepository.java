package com.userinfo.springmicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.userinfo.springmicroservice.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	public User findByUsername(String username);
}
