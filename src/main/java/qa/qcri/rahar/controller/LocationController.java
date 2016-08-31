package qa.qcri.rahar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import qa.qcri.rahar.entity.Location;
import qa.qcri.rahar.service.LocationService;

@RestController
@RequestMapping(value="/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String testCall() {
		return "this is a test mapping";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String create() {
		Location location = new Location();
		location.setDescription("Description");
		location.setLocationCode("code");
		locationService.create(location);
		return "Locatin Created Successfully !!";
	}
	
}
