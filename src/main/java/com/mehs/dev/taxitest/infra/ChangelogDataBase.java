package com.mehs.dev.taxitest.infra;

import java.util.ArrayList;
import java.util.List;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.data.repositories.PassengerRepository;
import com.mehs.dev.taxitest.data.schemas.MongoPassenger;

@ChangeLog
public class ChangelogDataBase {

	@ChangeSet(order = "001", id="seedPassengers", author = "mehs-dev")
	public void seedPassengers(PassengerRepository repository){
		List<MongoPassenger> passengers = new ArrayList<>();
		passengers.add(this.createPassenger("Lola", "Hernandez", StatusEnum.ACTIVE));
		passengers.add(this.createPassenger("Rulo", "Lopez", StatusEnum.ACTIVE));
		passengers.add(this.createPassenger("Chava", "Serte", StatusEnum.ACTIVE));
		repository.insert(passengers);
	}

	private MongoPassenger createPassenger(
		String name, 
		String lastName,
		StatusEnum status
	){
		MongoPassenger passenger = new MongoPassenger();
		passenger.setFirstName(name);
		passenger.setLastName(lastName);
		passenger.setStatus(status);
		return passenger;
	}
}
