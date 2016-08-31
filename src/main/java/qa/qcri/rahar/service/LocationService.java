package qa.qcri.rahar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qa.qcri.rahar.entity.Location;
import qa.qcri.rahar.repository.LocationRepository;

@Service
@Transactional
public class LocationService{
	
	@Autowired
	private LocationRepository locationRepository;

	public void create(Location location) {
		locationRepository.save(location);
	}

}
