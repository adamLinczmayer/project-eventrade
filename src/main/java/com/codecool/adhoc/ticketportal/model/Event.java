package com.codecool.adhoc.ticketportal.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(name = "event_bands")
    private Set<Band> bands = new HashSet<>();
    @OneToOne
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
