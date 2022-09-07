package com.locationweb.services;

import com.locationweb.entities.Locations;
import com.locationweb.repositories.LocationRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepo;
	
	@Override
	public void saveLocation(Locations location) {
		locationRepo.save(location);
	}

	@Override
	public List<Locations> getAllLocations() {
		List<Locations> locations = locationRepo.findAll();
		return locations;
	}
	
	@Override
	public void deleteLocationByID(long id) {
		locationRepo.deleteById(id);
	}

	@Override
	public Locations getLocationById(long id) {
		Optional<Locations> findById = locationRepo.findById(id);
		Locations location= findById.get();
		return location;
		
	}

}
