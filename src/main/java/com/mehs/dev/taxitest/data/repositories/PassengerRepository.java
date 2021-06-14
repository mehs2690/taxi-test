package com.mehs.dev.taxitest.data.repositories;

import com.mehs.dev.taxitest.data.schemas.MongoPassenger;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerRepository extends MongoRepository<MongoPassenger, String> {

}
