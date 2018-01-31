package com.codecool.adhoc.ticketportal.model;

public class LineItem {

    private Long id;

    private Ticket ticket;

    private Integer quantity;

    public LineItem() {
    }

    public LineItem(Ticket ticket, Integer quantity) {
        this.ticket = ticket;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
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
}
