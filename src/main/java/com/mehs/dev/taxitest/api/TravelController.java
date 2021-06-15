package com.mehs.dev.taxitest.api;

import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.core.models.Driver;
import com.mehs.dev.taxitest.core.models.Travel;
import com.mehs.dev.taxitest.core.services.TravelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {

	@Autowired
	private TravelService service;

	@PostMapping("/travels")
	public Object createANewRequestTravel(
		@RequestBody Object requestTravel
	) {
		return null;
	}

	@GetMapping("/travels/{id}")
	public Travel getById(
		@PathVariable(required = true) String id
	){
		return this.service.getById(id);
	}

	@PatchMapping("/travels/{id}")
	public Travel completeATravelById(
		@PathVariable(required = true) String id
	) {
		return this.service.completeATravel(id);
	}

	@GetMapping("/travels")
	public List<Travel> getAllTravels(
		@RequestParam(value = "status", required = true) StatusEnum status
	){
		return this.service.getAllActiTravels(status);
	}

	@GetMapping("/travels/{id}/drivers")
	public List<Driver> getThreeClosestDrivers(
		@PathVariable(required = true) String id
	) {
		return this.service.getClosestDriversToTravel(id);
	}
}
