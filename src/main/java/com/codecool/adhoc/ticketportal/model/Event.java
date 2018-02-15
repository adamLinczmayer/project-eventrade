package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Event.findAllEvents",
                query = "SELECT e FROM Event e "),
        @NamedQuery(
                name="Event.findUpcomingEvents",
                query = "SELECT e FROM Event e " +
                        "WHERE e.date < :currentDate"
        )
})
public class Event {
    @Transient
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm");

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "event_bands")
    private List<Band> bands = new ArrayList<>();
    @ManyToOne
    private Location location;
    private Date date;
    private String description;

    public Event() {
    }


    public Event(String name, Location location, String date, String description) throws ParseException{
        this.name = name;
        this.location = location;
        this.date = simpleDateFormat.parse(date);
        this.description = description;

    }

    public Long getId() { return id; }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String date) throws ParseException {
        this.date = simpleDateFormat.parse(date);
    }

    public List<Band> getBands() {
        return bands;
    }

    public void addBand(Band band) {
        bands.add(band);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Event:" +
                "\nid: " + id +
                ",\nname: " + name +
                ",\nbands: " + bands +
                ",\nlocation: " + location +
                ",\ndate: " + date +
                ",\ndescription: " + description;
    }
}
