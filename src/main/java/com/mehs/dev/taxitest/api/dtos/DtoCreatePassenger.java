package com.mehs.dev.taxitest.api.dtos;

import java.io.Serializable;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

public class DtoCreatePassenger implements Serializable{

	private String firstName;
	private String lastName;
	private StatusEnum status;


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

}
