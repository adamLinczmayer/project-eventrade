package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.Location;
import com.codecool.adhoc.ticketportal.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Location saveLocation(Location location){
        return locationRepository.save(location);
    }
}
