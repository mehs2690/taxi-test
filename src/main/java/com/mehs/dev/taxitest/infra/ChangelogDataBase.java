package com.mehs.dev.taxitest.infra;

import java.util.ArrayList;
import java.util.List;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mehs.dev.taxitest.core.enums.StatusEnum;
import com.mehs.dev.taxitest.data.repositories.DriverRepository;
import com.mehs.dev.taxitest.data.repositories.LocationRepository;
import com.mehs.dev.taxitest.data.repositories.PassengerRepository;
import com.mehs.dev.taxitest.data.repositories.UserRepository;
import com.mehs.dev.taxitest.data.schemas.MongoDriver;
import com.mehs.dev.taxitest.data.schemas.MongoLocation;
import com.mehs.dev.taxitest.data.schemas.MongoPassenger;
import com.mehs.dev.taxitest.data.schemas.MongoUser;

@ChangeLog
public class ChangelogDataBase {

	private List<MongoLocation> locations;

	@ChangeSet(order = "001", id="seedPassengers", author = "mehs-dev")
	public void seedPassengers(PassengerRepository repository){
		List<MongoPassenger> passengers = new ArrayList<>();
		passengers.add(this.createPassenger("Lola", "Hernandez", StatusEnum.ACTIVE));
		passengers.add(this.createPassenger("Rulo", "Lopez", StatusEnum.ACTIVE));
		passengers.add(this.createPassenger("Chava", "Serte", StatusEnum.ACTIVE));
		repository.insert(passengers);
	}

	@ChangeSet(order = "002", id = "seedLocations", author = "mehs-dev")
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
		this.locations = repository.insert(locations);
	}

	@ChangeSet(order = "003", id="seedDrivers", author = "mehs-dev")
	public void seedDrivers(DriverRepository repository){
		List<MongoDriver> drivers = new ArrayList<>();
		drivers.add(createDriver("Ramiro", "Palmas", StatusEnum.ACTIVE));
		drivers.add(createDriver("Josué", "Tellez", StatusEnum.INACTIVE));
		drivers.add(createDriver("Alicia", "Villarreal", StatusEnum.ACTIVE));
		drivers.add(createDriver("Marcela", "Panessi", StatusEnum.ACTIVE));
		repository.insert(drivers);
	}

	@ChangeSet(order = "004", id = "seedUsers", author = "mehs-dev")
	public void seedUsers(UserRepository repository){
		List<MongoUser> users = new ArrayList<>();
		users.add(this.createUser("user-passenger@user.com", "password"));
		users.add(this.createUser("user-passenger01@user.com", "password"));
		users.add(this.createUser("user-passenger02@user.com", "password"));
		users.add(this.createUser("user-driver@user.com", "password"));
		users.add(this.createUser("user-driver01@user.com", "password"));
		users.add(this.createUser("user-driver02@user.com", "password"));
		users.add(this.createUser("user-dirver03@user.com", "password"));
		repository.insert(users);
	}

	private MongoUser createUser(String username, String password){
		MongoUser user = new MongoUser();
		user.setUsername(username);
		user.setPassword(password);
		return user;
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
		driver.setLocations(this.locations);
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
