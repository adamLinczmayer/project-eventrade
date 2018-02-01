package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name="Ticket.findAllTickets",
                query="SELECT t FROM Ticket t " +
                        "ORDER BY t.id"),
        @NamedQuery(
                name="Ticket.findTicketById",
                query="SELECT t FROM Ticket t " +
                        "WHERE t.id = :ticketId"
        )
})
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

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
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

    @Override
    public String toString() {
        return "Ticket" +
                "\nid: " + id +
                "\nevent: " + event.getName() +
                "\nprice: " + price +
                "\nticketType: " + ticketType.toString().toLowerCase();
    }
}
