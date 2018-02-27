package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.Location;
import com.codecool.adhoc.ticketportal.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    public Location saveLocation(Location location){
        return locationRepository.save(location);
    }

    public Location findLocationById(Long id) {
        return locationRepository.findOne(id);
    }

    public List<Location> findLocationsByNameIsLike(String name) {
        if(!Objects.equals(name.trim(), "")){
            return locationRepository.findLocationsByNameIsLike(name);
        }
        return null;
    }

}
