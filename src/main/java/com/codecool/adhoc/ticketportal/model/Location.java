package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Location.findByName",
                    query = "SELECT l FROM Location l " +
                            "WHERE l.name LIKE :name"),
        @NamedQuery(name = "Location.findByAddress",
                    query = "SELECT l FROM Location l " +
                            "WHERE l.address LIKE :address")
})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Integer capacity;

    @OneToMany(mappedBy = "location")
    private List<Event> event;

    public Location() {
    }

    public Location(String name, String address, Integer capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Location: " +
                "\nname: " + name +
                ",\naddress: " + address +
                ",\ncapacity: " + capacity;
    }
}
