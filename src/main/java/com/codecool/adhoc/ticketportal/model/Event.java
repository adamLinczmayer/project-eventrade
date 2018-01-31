package com.codecool.adhoc.ticketportal.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Event {
    private Long id;
    private Set<Band> bands = new HashSet<>();
    private Location location;
    private Date date;

    public Event() {
    }

    public Event(Location location, Date date) {
        this.location = location;
        this.date = date;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Band> getBands() {
        return bands;
    }

    public void addBand(Band band) {
        bands.add(band);
    }
}
