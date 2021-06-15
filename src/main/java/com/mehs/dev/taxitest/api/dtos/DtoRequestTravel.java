package com.mehs.dev.taxitest.api.dtos;

import java.util.Date;

public class DtoRequestTravel {

	private String startingPoint;
	private String destination;
	private Date createdDate;

	public DtoRequestTravel() {
		this.createdDate = new Date();
	}

	public String getStartingPoint() {
		return this.startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "{" +
			" startingPoint='" + getStartingPoint() + "'" +
			", destination='" + getDestination() + "'" +
			", createdDate='" + getCreatedDate() + "'" +
			"}";
	}

}
