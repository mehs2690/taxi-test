package com.mehs.dev.taxitest.data.repositories;

import com.mehs.dev.taxitest.data.schemas.MongoDriver;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<MongoDriver, String> {

}
