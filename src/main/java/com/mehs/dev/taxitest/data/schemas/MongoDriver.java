package com.mehs.dev.taxitest.data.schemas;

import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("drivers")
public class MongoDriver {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private List<MongoLocation> locations;
	private StatusEnum status;


	public MongoDriver() {
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

	public List<MongoLocation> getLocations() {
		return this.locations;
	}

	public void setLocations(List<MongoLocation> locations) {
		this.locations = locations;
	}

	public StatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
