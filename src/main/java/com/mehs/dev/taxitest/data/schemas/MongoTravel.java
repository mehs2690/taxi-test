package com.mehs.dev.taxitest.data.schemas;

import java.util.Date;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("travels")
public class MongoTravel {
	@Id
	private String id;
	private Date createdDate;
	private MongoPassenger passenger;
	private MongoDriver driver;
	private MongoLocation startingPoint;
	private MongoLocation destination;
	private Date startingPointDate;
	private Date destinationDate;
	@Indexed
	private StatusEnum status;
	private MongoInvoice invoice;

	public MongoTravel() {
	}

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

	public MongoPassenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(MongoPassenger passenger) {
		this.passenger = passenger;
	}

	public MongoDriver getDriver() {
		return this.driver;
	}

	public void setDriver(MongoDriver driver) {
		this.driver = driver;
	}

	public MongoLocation getStartingPoint() {
		return this.startingPoint;
	}

	public void setStartingPoint(MongoLocation startingPoint) {
		this.startingPoint = startingPoint;
	}

	public MongoLocation getDestination() {
		return this.destination;
	}

	public void setDestination(MongoLocation destination) {
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

	public MongoInvoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(MongoInvoice invoice) {
		this.invoice = invoice;
	}

}
