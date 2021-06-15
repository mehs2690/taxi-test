package com.mehs.dev.taxitest.data.repositories;

import java.util.List;

import com.mehs.dev.taxitest.data.schemas.MongoLocation;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LocationRepository extends MongoRepository<MongoLocation, String> {
	@Query("{'distance':?0}")
	List<MongoLocation> findByDistance(Integer distance);
}
