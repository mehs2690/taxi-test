package com.mehs.dev.taxitest.infra;

import java.util.ArrayList;
import java.util.List;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.data.repositories.DriverRepository;
import com.mehs.dev.taxitest.data.repositories.LocationRepository;
import com.mehs.dev.taxitest.data.repositories.PassengerRepository;
import com.mehs.dev.taxitest.data.schemas.MongoDriver;
import com.mehs.dev.taxitest.data.schemas.MongoLocation;
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

	@ChangeSet(order = "002", id="seedDrivers", author = "mehs-dev")
	public void seedDrivers(DriverRepository repository){
		List<MongoDriver> drivers = new ArrayList<>();
		drivers.add(createDriver("Ramiro", "Palmas", StatusEnum.ACTIVE));
		drivers.add(createDriver("Josué", "Tellez", StatusEnum.INACTIVE));
		drivers.add(createDriver("Alicia", "Villarreal", StatusEnum.ACTIVE));
		drivers.add(createDriver("Marcela", "Panessi", StatusEnum.ACTIVE));
		repository.insert(drivers);
	}

	@ChangeSet(order = "003", id = "seedLocations", author = "mehs-dev")
	public void seedLocations(LocationRepository repository){
		List<MongoLocation> locations = new ArrayList<>();
		locations.add(createLocation("Mercado", 10));
		locations.add(createLocation("Cine", 3));
		locations.add(createLocation("Teatro", 9));
		locations.add(createLocation("Hospital", 3));
		locations.add(createLocation("Banco", 5));
		locations.add(createLocation("Gasolinera", 1));
		locations.add(createLocation("Hotel", 2));
		locations.add(createLocation("Tienda", 7));
		repository.insert(locations);
	}

	private MongoLocation createLocation(
		String name,
		Integer distance
	){
		MongoLocation location = new MongoLocation();
		location.setName(name);
		location.setDistance(distance);
		return location;
	}

	private MongoDriver createDriver(
		String firstName,
		String lastName,
		StatusEnum status
	){
		MongoDriver driver = new MongoDriver();
		driver.setFirstName(firstName);
		driver.setLastName(lastName);
		driver.setStatus(status);
		return driver;
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
