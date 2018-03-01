package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.TicketType;

import javax.persistence.*;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Event event;

    private Float price;
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    public Ticket() {
    }

    public Ticket(Event event, Float price, TicketType ticketType) {
        this.event = event;
        this.price = price;
        this.ticketType = ticketType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
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

    @Override
    public String toString() {
        return "Ticket" +
                "\nid: " + id +
                "\nevent: " + event.getName() +
                "\nprice: " + price +
                "\nticketType: " + ticketType.toString().toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
        if (event != null ? !event.equals(ticket.event) : ticket.event != null) return false;
        if (price != null ? !price.equals(ticket.price) : ticket.price != null) return false;
        return ticketType == ticket.ticketType;
    }
}
