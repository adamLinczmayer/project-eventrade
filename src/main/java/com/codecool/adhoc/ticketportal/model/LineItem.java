package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "LineItem.findAllLineItems",
                query = "SELECT li FROM LineItem li ")
})
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Ticket ticket;

    @ManyToOne
    @Transient
    private Cart cart;

    @ManyToOne
    @Transient
    private Order order;

    private Integer quantity;

    public LineItem() {
    }

    public LineItem(Ticket ticket, Cart cart, Integer quantity) {
        this.ticket = ticket;
        this.cart = cart;
        this.quantity = quantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    @Override
    public String toString() {
        return "LineItem: " +
                "\nid:" + id +
                "\nticket: " + ticket.getEvent().getName() + " " + ticket.getTicketType() +
                "\nquantity: " + quantity;
    }
}
