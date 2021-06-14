package com.mehs.dev.taxitest.data.schemas;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("invoices")
public class MongoInvoice {
	@Id
	private String id;
	private MongoTravel travel;
	private Integer amount;
	private Date createdDate;
	private Integer tax;

	public MongoInvoice() {
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MongoTravel getTravel() {
		return this.travel;
	}

	public void setTravel(MongoTravel travel) {
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

}
