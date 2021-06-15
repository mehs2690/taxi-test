package com.mehs.dev.taxitest.api;

import java.util.List;

import com.mehs.dev.taxitest.core.models.Location;
import com.mehs.dev.taxitest.core.services.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService service;

	@GetMapping("/locations")
	public List<Location> getAllLocations(){
		return this.service.getAllLocations();
	}
}
