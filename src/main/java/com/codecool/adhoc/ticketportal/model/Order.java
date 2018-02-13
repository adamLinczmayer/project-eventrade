package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;

import javax.persistence.*;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Order.findByUserId",
                    query = "SELECT o FROM Order o " +
                            "WHERE o.users = :users_id")
})
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User users;

    @ElementCollection
    private Set<LineItem> lineItems;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Order() {
    }

    public Order(User user, OrderStatus status) {
        this.users = user;
        this.status = status;
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

    public User getUser() {
        return users;
    }

    public void setUser(User user) {
        this.users = user;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "user: " + users.getFullName() +
                ",\nstatus: " + status;
    }
}
