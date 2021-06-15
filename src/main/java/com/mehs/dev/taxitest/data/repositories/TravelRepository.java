package com.mehs.dev.taxitest.data.repositories;

import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.data.schemas.MongoTravel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TravelRepository extends MongoRepository<MongoTravel,String>{
	@Query("{'status':?0}")
	List<MongoTravel> findByStatus(StatusEnum status);
}
