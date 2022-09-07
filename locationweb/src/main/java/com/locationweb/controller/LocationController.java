package com.locationweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb.entities.Locations;
import com.locationweb.services.LocationService;
import com.locationweb.utility.EmailService;

@Controller
public class LocationController {

	@Autowired
	private LocationService locationservice;
	
	@Autowired
	private EmailService emailService;
	
	//Handler Methods
	@RequestMapping("/showLocationPage")
	public String showLocationPage() {
		return "create_location";
		
	}
//  Data Transfer Object - DTO
	@RequestMapping("/saveLocation")
	public String saveLocationData(@ModelAttribute("loc") Locations location, ModelMap model) {
		locationservice.saveLocation(location);
		emailService.sendSimpleMessage("vinayakaspadukone@gmail.com", "Test", "Welcome");
		model.addAttribute("msg", "Location is Saved!");
		return "create_location";
	}

//	@RequestMapping("/saveLocation")
//	public String saveLocationData(@RequestParam("id") long id, @RequestParam("name") String name,@RequestParam("codes") String code,@RequestParam("type") String type){
//		Locations location = new Locations();
//		location.setId(id);
//		location.setName(name);
//		location.setCodes(code);
//		location.setType(type);
//		locationservice.saveLocation(location);
//		return "create_location";	
//	}
	
	@RequestMapping("/listall")
	public String listall(ModelMap model) {
		List<Locations> locations = locationservice.getAllLocations();
		model.addAttribute("locations",locations);
		return "search_result";
		}
	
	@RequestMapping("/delete")
	public String deletelocation(@RequestParam("id") long id, ModelMap model) {
		locationservice.deleteLocationByID(id);
		List<Locations> locations = locationservice.getAllLocations();
		model.addAttribute("locations", locations);
		return "search_result";
	}
	
	@RequestMapping("/update")
	public String updatelocation(@RequestParam("id") long id, ModelMap model) {
		Locations location = locationservice.getLocationById(id);
		model.addAttribute("location", location);
		return "update_location";
	}
	
	@RequestMapping("/updateData")
	public String updateLocationData(@ModelAttribute("loc") Locations location, ModelMap model) {
		locationservice.saveLocation(location);
		model.addAttribute("msg", "Location is Updated!");
		return "update_location";
}
}
