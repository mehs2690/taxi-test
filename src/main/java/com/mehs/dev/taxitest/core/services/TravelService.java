package com.mehs.dev.taxitest.core.services;

import com.mehs.dev.taxitest.core.models.Travel;
import com.mehs.dev.taxitest.data.repositories.TravelRepository;
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
	private ModelMapper mapper = new ModelMapper();

	public Travel getById(String id){
		MongoTravel document = this.repository.findById(id).get();
		return mapper.map(document,Travel.class);
	}
}
