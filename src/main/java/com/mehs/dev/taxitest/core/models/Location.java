package com.mehs.dev.taxitest.core.models;

import java.io.Serializable;

public class Location implements Serializable{
	
	private String id;
	private String name;
	private Integer distance;


	public Location() {
	}


	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistance() {
		return this.distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}


	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", name='" + getName() + "'" +
			", distance='" + getDistance() + "'" +
			"}";
	}

}
