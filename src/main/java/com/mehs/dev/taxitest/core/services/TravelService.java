package com.mehs.dev.taxitest.core.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.core.models.Driver;
import com.mehs.dev.taxitest.core.models.Travel;
import com.mehs.dev.taxitest.data.repositories.DriverRepository;
import com.mehs.dev.taxitest.data.repositories.InvoiceRepository;
import com.mehs.dev.taxitest.data.repositories.LocationRepository;
import com.mehs.dev.taxitest.data.repositories.TravelRepository;
import com.mehs.dev.taxitest.data.schemas.MongoDriver;
import com.mehs.dev.taxitest.data.schemas.MongoInvoice;
import com.mehs.dev.taxitest.data.schemas.MongoLocation;
import com.mehs.dev.taxitest.data.schemas.MongoTravel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class TravelService {

	@Autowired
	private TravelRepository repository;
	@Autowired
	private InvoiceRepository invoiceRep;
	@Autowired
	private LocationRepository locationRep;
	@Autowired
	private DriverRepository driverRep;
	private ModelMapper mapper = new ModelMapper();

	public Travel getById(String id) {
		MongoTravel document = this.repository.findById(id).get();
		return mapper.map(document, Travel.class);
	}

	public List<Travel> getAllTravels(){
		List<MongoTravel> documents = this.repository.findAll();
		List<Travel> travels = new ArrayList<>();
		documents.forEach(document -> {
			travels.add(this.mapper.map(document, Travel.class));
		});
		return travels;
	}

	public List<Travel> getAllActiTravels(StatusEnum status){
		List<MongoTravel> documents = this.repository.findByStatus(status);
		List<Travel> travels = new ArrayList<>();
		documents.forEach(document ->{
			travels.add(this.mapper.map(document, Travel.class));
		});
		return travels;
	}

	public Travel completeATravel(String id){
		MongoTravel document = this.repository.findById(id).get();
		document.setStatus(StatusEnum.FINISHED);
		MongoInvoice invoiceDoc = new MongoInvoice();
		invoiceDoc.setTravel(document);
		invoiceDoc.setAmount(500);
		invoiceDoc.setTax(16);
		invoiceDoc.setCreatedDate(new Date());
		MongoInvoice savedInvoice = this.invoiceRep.save(invoiceDoc);
		document.setInvoice(savedInvoice);
		return this.mapper.map(this.repository.save(document), Travel.class);
	}

	public List<Driver> getClosestDriversToTravel(String id){
		MongoTravel travel = this.repository.findById(id).get();
		Integer distance = travel.getStartingPoint().getDistance();
		List<MongoLocation> locations = this.locationRep.findByDistance(distance);
		List<String> ids = locations.stream()
										.map(location -> location.getId())
										.distinct()
										.collect(Collectors.toList());
		List<MongoDriver> driverDocs = this.driverRep.findByStatusAndLocation(StatusEnum.ACTIVE, ids);
		List<Driver> drivers = new ArrayList<>();
		driverDocs.forEach(document -> {
			drivers.add(this.mapper.map(document, Driver.class));
		});
		return drivers;
	}
}
