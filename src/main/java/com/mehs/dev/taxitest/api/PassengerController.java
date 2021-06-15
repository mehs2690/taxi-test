package com.mehs.dev.taxitest.api;

import java.util.List;

import com.mehs.dev.taxitest.api.dtos.DtoCreatePassenger;
import com.mehs.dev.taxitest.api.dtos.DtoRequestTravel;
import com.mehs.dev.taxitest.api.dtos.DtoSetDriverToTravel;
import com.mehs.dev.taxitest.core.models.Passenger;
import com.mehs.dev.taxitest.core.services.PassengerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PassengerController {

	@Autowired
	private PassengerService service;

	@PostMapping("/passengers")
	public Passenger createPassenger(
		@RequestBody DtoCreatePassenger dto
	){
		return this.service.createPassenger(dto);
	}

	@GetMapping("/passengers")
	public List<Passenger> getAllPassengers() {
		return this.service.getAllPassengers();
	}

	@GetMapping("/passengers/{id}")
	public Passenger getPassengerById(
		@PathVariable(required = true) String id
	) {
		return this.service.getById(id);
	}

	@PutMapping("/passengers/{id}/travel")
	public Passenger requestANewTravel(
		@PathVariable(required = true) String id,
		@RequestBody DtoRequestTravel dto
	) {
		return this.service.putNewRequestTravel(id, dto);
	}

	@PatchMapping("/passengers/{id}")
	public Passenger setDriverToTravel(
		@PathVariable(required = true) String id,
		@RequestBody DtoSetDriverToTravel dto
	){
		return this.service.patchSetDriverToTravel(id, dto);
	}
}
