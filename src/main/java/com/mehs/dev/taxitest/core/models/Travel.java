package com.mehs.dev.taxitest.core.models;

import java.util.Date;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

public class Travel {

	private String id;
	private Date createdDate;
	private String passenger;
	private String driver;
	private String startingPoint;
	private String destination;
	private Date startingPointDate;
	private Date destinationDate;
	private StatusEnum status;
	private String invoice;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPassenger() {
		return this.passenger;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}

	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
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

	public Date getStartingPointDate() {
		return this.startingPointDate;
	}

	public void setStartingPointDate(Date startingPointDate) {
		this.startingPointDate = startingPointDate;
	}

	public Date getDestinationDate() {
		return this.destinationDate;
	}

	public void setDestinationDate(Date destinationDate) {
		this.destinationDate = destinationDate;
	}

	public StatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", createdDate='" + getCreatedDate() + "'" +
			", passenger='" + getPassenger() + "'" +
			", driver='" + getDriver() + "'" +
			", startingPoint='" + getStartingPoint() + "'" +
			", destination='" + getDestination() + "'" +
			", startingPointDate='" + getStartingPointDate() + "'" +
			", destinationDate='" + getDestinationDate() + "'" +
			", status='" + getStatus() + "'" +
			", invoice='" + getInvoice() + "'" +
			"}";
	}


}
