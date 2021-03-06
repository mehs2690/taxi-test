package com.mehs.dev.taxitest.core.models;

import java.io.Serializable;
import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

public class Driver implements Serializable {

	private String id;
	private String firstName;
	private String lastName;
	private List<String> locations;
	private StatusEnum status;


	public Driver() {
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

	public List<String> getLocations() {
		return this.locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	public StatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", firstName='" + getFirstName() + "'" +
			", lastName='" + getLastName() + "'" +
			", locations='" + getLocations() + "'" +
			", status='" + getStatus() + "'" +
			"}";
	}

}
