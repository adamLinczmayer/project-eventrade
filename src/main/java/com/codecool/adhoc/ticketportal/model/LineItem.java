package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;

@Embeddable
public class LineItem {

    @OneToOne
    private Ticket ticket;

    @ManyToOne
    private Order order;

    private Integer quantity;

    public LineItem() {
    }

    public LineItem(Ticket ticket, Integer quantity) {
        this.ticket = ticket;
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "LineItem: " +
                "\nticket: " + ticket.getEvent().getName() + " " + ticket.getTicketType() +
                "\nquantity: " + quantity;
    }
}
