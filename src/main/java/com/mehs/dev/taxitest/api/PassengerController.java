package com.mehs.dev.taxitest.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PassengerController {

	@GetMapping("/passengers")
	public List<Object> getAllPassengers() {
		return new ArrayList<Object>();
	}

	@GetMapping("/passengers/{id}")
	public Object getPassengerById(
		@PathVariable(required = true) String id
	) {
		return new Object();
	}

	@PutMapping("/passengers/{id}/travel")
	public Object requestANewTravel(
		@PathVariable(required = true) String id
	) {
		return new Object();
	}
}
