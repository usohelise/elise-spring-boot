package com.test.api.testapi.services;

import com.test.api.testapi.model.Location;
import com.test.api.testapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    //saving location
    public Location saveLocation(Location location) {
        return locationRepository.save(location);
    }

    //returning list of locations
    public List<String> getLocationsForUser(String user){
        List<String> result = new ArrayList<>();
        locationRepository.findByUser(user).forEach(location -> result.add(location.getLocation())); //adding everything to list then returning list
        return result;
    }
}
