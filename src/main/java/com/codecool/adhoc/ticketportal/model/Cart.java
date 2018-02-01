package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(
                name = "Cart.findAllCarts",
                query = "SELECT c FROM Cart c " +
                        "ORDER BY c.id"),
})
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart")
    @Transient
    private User user;

    @OneToMany
    private Set<LineItem> lineItems;

    public Cart() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(lineItem);

    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Cart:" +
                "\nid=" + id +
                "\nuser=" + user +
                "\nlineItems=" + lineItems;
    }
}
