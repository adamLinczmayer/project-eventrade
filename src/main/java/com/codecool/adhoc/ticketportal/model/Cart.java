package com.codecool.adhoc.ticketportal.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @Transient
    private User user;

    @OneToMany(mappedBy = "cart")
    private Set<LineItem> lineItems;

    public Cart(User user, Set<LineItem> lineItems) {
        this.user = user;
        this.lineItems = lineItems;
    }

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
        lineItems.add(lineItem);

    }

    public long getId() {
        return id;
    }


}
