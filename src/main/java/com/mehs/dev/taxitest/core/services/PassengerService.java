package com.mehs.dev.taxitest.core.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.mehs.dev.taxitest.api.dtos.DtoCreatePassenger;
import com.mehs.dev.taxitest.api.dtos.DtoRequestTravel;
import com.mehs.dev.taxitest.api.dtos.DtoSetDriverToTravel;
import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.core.models.Passenger;
import com.mehs.dev.taxitest.data.repositories.DriverRepository;
import com.mehs.dev.taxitest.data.repositories.LocationRepository;
import com.mehs.dev.taxitest.data.repositories.PassengerRepository;
import com.mehs.dev.taxitest.data.repositories.TravelRepository;
import com.mehs.dev.taxitest.data.schemas.MongoDriver;
import com.mehs.dev.taxitest.data.schemas.MongoLocation;
import com.mehs.dev.taxitest.data.schemas.MongoPassenger;
import com.mehs.dev.taxitest.data.schemas.MongoTravel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class PassengerService {

	@Autowired
	private PassengerRepository repository;
	@Autowired
	private TravelRepository travelRepository;
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private LocationRepository locationRepository;
	private ModelMapper mapper = new ModelMapper();

	public Passenger createPassenger(DtoCreatePassenger dto) {
		MongoPassenger document = mapper.map(dto, MongoPassenger.class);
		MongoPassenger inserted = this.repository.insert(document);
		return mapper.map(inserted, Passenger.class);
	}

	public List<Passenger> getAllPassengers() {
		List<MongoPassenger> documents = this.repository.findAll();
		List<Passenger> passengers = new ArrayList<>();
		documents.forEach(document -> {
			passengers.add(mapper.map(document, Passenger.class));
		});
		return passengers;
	}

	public Passenger getById(String id) {
		Optional<MongoPassenger> document = this.repository.findById(id);
		Passenger passenger = null;
		if (document.isPresent()) {
			passenger = mapper.map(document.get(), Passenger.class);
		}
		return passenger;
	}

	public Passenger putNewRequestTravel(
		String id, 
		DtoRequestTravel dto
	) {
		Passenger passenger = this.getById(id);
		if (passenger != null) {
			MongoPassenger passengerDocument = this.mapper.map(passenger, MongoPassenger.class);
			MongoLocation locationDestDocument = this.locationRepository.findById(dto.getDestination()).get();
			MongoLocation locationStarDocument = this.locationRepository.findById(dto.getStartingPoint()).get();
			MongoTravel document = new MongoTravel();
			document.setPassenger(passengerDocument);
			document.setStartingPointDate(new Date());
			document.setDestination(locationDestDocument);
			document.setStartingPoint(locationStarDocument);
			document.setCreatedDate(dto.getCreatedDate());
			document.setPassenger(passengerDocument);
			document.setStatus(StatusEnum.STARTED);
			MongoTravel inserted = this.travelRepository.insert(document);
			if (inserted.getId() != "" || inserted.getId() != null) {
				passenger = this.getById(id);
			}
		}
		return passenger;
	}

	public Passenger patchSetDriverToTravel(
		String id,
		DtoSetDriverToTravel dto
	) {
		Passenger passenger = this.getById(id);
		if (passenger != null) {
			Optional<MongoTravel> travelDocument = this.travelRepository.findById(dto.getTravel());
			Optional<MongoDriver> driverDocument = this.driverRepository.findById(dto.getDriver());
			travelDocument.get().setDriver(driverDocument.get());
			travelRepository.save(travelDocument.get());
			passenger = this.getById(id);
		}
		return passenger;
	}
}
