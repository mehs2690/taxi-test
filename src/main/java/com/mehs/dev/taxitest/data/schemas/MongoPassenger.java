package com.mehs.dev.taxitest.data.schemas;

import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("passengers")
public class MongoPassenger {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private StatusEnum status;
	@Field("user")
	@DBRef
	private MongoUser user;
	@Field("travels")
	@DBRef
	private List<MongoTravel> travels;

	public MongoPassenger() {
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public StatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public MongoUser getUser() {
		return this.user;
	}

	public void setUser(MongoUser user) {
		this.user = user;
	}

	public List<MongoTravel> getTravels() {
		return this.travels;
	}

	public void setTravels(List<MongoTravel> travels) {
		this.travels = travels;
	}

	@Override
	public String toString(){
		return this.getId();
	}

}
