package com.codecool.adhoc.ticketportal.model;

public class Ticket {

    private Long id;
    private Event event;
    private Float price;

    public Ticket() {
    }

    public Ticket(Event event, Float price) {
        this.event = event;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
