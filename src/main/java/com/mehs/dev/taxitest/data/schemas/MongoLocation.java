package com.mehs.dev.taxitest.data.schemas;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("locations")
public class MongoLocation {
	@Id
	private String id;
	private String name;
	private Integer distance;
	@Field("driver")
	@DBRef
	private MongoDriver driver;
	@Field("travel")
	@DBRef
	private MongoTravel travel;

	public MongoLocation() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistance() {
		return this.distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public MongoDriver getDriver() {
		return this.driver;
	}

	public void setDriver(MongoDriver driver) {
		this.driver = driver;
	}

	public MongoTravel getTravel() {
		return this.travel;
	}

	public void setTravel(MongoTravel travel) {
		this.travel = travel;
	}

	@Override
	public String toString() {
		return this.getId();
	}

}
