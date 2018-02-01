package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Event.findAllEvents",
                query = "SELECT e FROM Event e ")
})
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "event_bands")
    private Set<Band> bands = new HashSet<>();
    @OneToOne
    private Location location;
    private Date date;

    public Event() {
    }

    public Event(String name, Location location, Date date) {
        this.name = name;
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

    @Override
    public String toString() {
        return "\nEvent" +
                "\nid=" + id +
                "\nname=" + name +
                "\nbands=" + bands +
                "\nlocation=" + location +
                "\ndate=" + date;
    }
}
