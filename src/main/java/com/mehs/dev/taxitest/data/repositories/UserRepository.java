package com.mehs.dev.taxitest.data.repositories;

import com.mehs.dev.taxitest.data.schemas.MongoUser;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<MongoUser, String> {

}
