package com.mehs.dev.taxitest.data.schemas;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("users")
public class MongoUser {
	@Id
	private String id;
	@Indexed(unique = true)
	private String username;
	private String password;
	@Field("driver")
	@DBRef
	private MongoDriver driver;
	@Field("passenger")
	@DBRef
	private MongoPassenger passenger;

	public MongoUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MongoDriver getDriver() {
		return this.driver;
	}

	public void setDriver(MongoDriver driver) {
		this.driver = driver;
	}

	public MongoPassenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(MongoPassenger passenger) {
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return this.getId();
	}
}
