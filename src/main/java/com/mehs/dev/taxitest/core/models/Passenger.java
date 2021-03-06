package com.mehs.dev.taxitest.core.models;

import java.io.Serializable;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

public class Passenger implements Serializable{

	private String id;
	private String firstName;
	private String lastName;
	private StatusEnum status;
	private String user;


	public Passenger() {
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

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", firstName='" + getFirstName() + "'" +
			", lastName='" + getLastName() + "'" +
			", status='" + getStatus() + "'" +
			", user='" + getUser() + "'" +
			"}";
	}


}
