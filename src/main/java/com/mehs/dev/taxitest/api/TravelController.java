package com.mehs.dev.taxitest.api;

import java.util.ArrayList;
import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TravelController {

	@PostMapping("/travels")
	public Object createANewRequestTravel(
		@RequestBody Object requestTravel
	) {
		return new Object();
	}

	@PatchMapping("/travels/{id}")
	public Object completeATravelById(
		@PathVariable(required = true) String id
	) {
		return new Object();
	}

	@GetMapping("/travels")
	public List<Object> getAllTravels(
		@RequestParam(value = "status", required = true) StatusEnum status
	){
		return new ArrayList<Object>();
	}

	@GetMapping("/travels/{id}/drivers")
	public List<Object> getThreeClosestDrivers(
		@PathVariable(required = true) String id
	) {
		return new ArrayList<Object>();
	}
}
