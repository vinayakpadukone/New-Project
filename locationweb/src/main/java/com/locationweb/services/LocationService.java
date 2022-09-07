package com.locationweb.services;

import com.locationweb.entities.Locations;

import java.util.List;

public interface LocationService {
	
	public void saveLocation(Locations location);

	public List<Locations> getAllLocations();

	public void deleteLocationByID(long id);

	public Locations getLocationById(long id);

}
