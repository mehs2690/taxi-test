package com.mehs.dev.taxitest.data.repositories;

import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.data.schemas.MongoDriver;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DriverRepository extends MongoRepository<MongoDriver, String> {

	@Query("{'status': ?0}")
	List<MongoDriver> findByStatus(StatusEnum status);

	@Query("{$and:[{'status':?0},{'locations.$id': { $in: ?1 }}]}")
	List<MongoDriver> findByStatusAndLocation(StatusEnum status, List<String> location);
}
