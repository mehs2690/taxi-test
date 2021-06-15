package com.mehs.dev.taxitest.core.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.core.models.Driver;
import com.mehs.dev.taxitest.data.repositories.DriverRepository;
import com.mehs.dev.taxitest.data.repositories.LocationRepository;
import com.mehs.dev.taxitest.data.schemas.MongoDriver;
import com.mehs.dev.taxitest.data.schemas.MongoLocation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DriverService {

	@Autowired
	private DriverRepository repository;
	@Autowired
	private LocationRepository locationRep;
	private ModelMapper mapper = new ModelMapper();

	private List<Driver> getDrivers(StatusEnum status, Integer ratio) {
		List<Driver> drivers = new ArrayList<>();
		if (status != null) {
			this.repository.findByStatus(status).forEach(document -> {
				drivers.add(this.mapper.map(document, Driver.class));
			});
			return drivers;
		} else if (ratio != null) {
			List<MongoLocation> locations = this.locationRep.findByDistance(ratio);
			List<String> ids = locations.stream()
										.map(location -> location.getId())
										.distinct()
										.collect(Collectors.toList());
			this.repository.findByStatusAndLocation(status, ids).forEach(document -> {
				drivers.add(this.mapper.map(document, Driver.class));
			});
			return drivers;
		} else {
			this.repository.findAll().forEach(document -> {
				drivers.add(mapper.map(document, Driver.class));
			});
			return drivers;
		}
	}

	public List<Driver> getAllDrivers(){
		return this.getDrivers(null, null);
	}

	public List<Driver> getAllDrivers(StatusEnum status){
		return this.getDrivers(status, null);
	}

	public List<Driver> getAllDrivers(StatusEnum status,Integer ratio){
		return this.getDrivers(status, ratio);
	}

	public Driver getById(String id){
		MongoDriver document = this.repository.findById(id).get();
		return this.mapper.map(document, Driver.class);
	}
}
