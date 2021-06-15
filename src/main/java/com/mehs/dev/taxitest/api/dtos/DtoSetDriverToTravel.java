package com.mehs.dev.taxitest.api.dtos;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

public class DtoSetDriverToTravel {
	private String driver;
	private String travel;
	private StatusEnum status;

	public DtoSetDriverToTravel() {
		this.status = StatusEnum.INPROGRESS;
	}

	public String getDriver() {
		return this.driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getTravel() {
		return this.travel;
	}

	public void setTravel(String travel) {
		this.travel = travel;
	}

	public StatusEnum getStatus() {
		return this.status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

}
