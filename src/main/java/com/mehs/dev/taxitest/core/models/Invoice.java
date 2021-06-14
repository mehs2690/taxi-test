package com.mehs.dev.taxitest.core.models;

import java.io.Serializable;
import java.util.Date;

public class Invoice implements Serializable {

	private String id;
	private String travel;
	private Integer amount;
	private Date createdDate;
	private Integer tax;


	public Invoice() {
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTravel() {
		return this.travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getTax() {
		return this.tax;
	}

	public void setTax(Integer tax) {
		this.tax = tax;
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", travel='" + getTravel() + "'" +
			", amount='" + getAmount() + "'" +
			", createdDate='" + getCreatedDate() + "'" +
			", tax='" + getTax() + "'" +
			"}";
	}
	
}
