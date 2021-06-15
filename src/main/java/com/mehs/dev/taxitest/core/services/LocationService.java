package com.mehs.dev.taxitest.core.services;

import java.util.ArrayList;
import java.util.List;

import com.mehs.dev.taxitest.core.models.Location;
import com.mehs.dev.taxitest.data.repositories.LocationRepository;
import com.mehs.dev.taxitest.data.schemas.MongoLocation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LocationService {
	@Autowired
	private LocationRepository repository;
	private ModelMapper mapper = new ModelMapper();

	public List<Location> getAllLocations(){
		List<MongoLocation> documents = this.repository.findAll();
		List<Location> locations = new ArrayList<>();
		documents.forEach(document->{
			locations.add(this.mapper.map(document,Location.class));
		});
		return locations;
	}
}
