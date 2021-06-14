package com.mehs.dev.taxitest.data.repositories;

import com.mehs.dev.taxitest.data.schemas.MongoTravel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TravelRepository extends MongoRepository<MongoTravel,String>{
	
}
