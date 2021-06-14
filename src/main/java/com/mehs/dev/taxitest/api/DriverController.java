package com.mehs.dev.taxitest.api;

import java.util.ArrayList;
import java.util.List;

import com.mehs.dev.taxitest.core.enums.StatusEnum;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DriverController {

	@GetMapping("/drivers")
	public List<Object> getAllDrivers(
		@RequestParam(value = "status", required = false) StatusEnum status,
		@RequestParam(value = "ratio", required = false) Integer ratio 
	) {
		return new ArrayList<Object>();
	}

	@GetMapping("/drivers/{id}")
	public Object getDriverById(
		@PathVariable(required = true) String id
	){
		return new Object();
	}
}
