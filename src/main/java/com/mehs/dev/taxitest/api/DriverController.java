package com.mehs.dev.taxitest.api;

import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.core.models.Driver;
import com.mehs.dev.taxitest.core.services.DriverService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DriverController {

	private static final Logger log = LoggerFactory.getLogger(DriverController.class);

	@Autowired
	private DriverService service;

	@GetMapping("/drivers")
	public List<Driver> getAllDrivers(
		@RequestParam(value = "status", required = false) StatusEnum status,
		@RequestParam(value = "ratio", required = false) Integer ratio 
	) {
		log.info(String.format("status %s", status));
		log.info(String.format("ratio %d", ratio));
		return this.service.getAllDrivers(status, ratio);
	}

	@GetMapping("/drivers/{id}")
	public Driver getDriverById(
		@PathVariable(required = true) String id
	){
		return this.service.getById(id);
	}
}
