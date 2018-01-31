package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;

public class Order {

    private long id;

    private User user;

    private OrderStatus status;

    public Order() {
    }

    public Order(User user, OrderStatus status) {
        this.user = user;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
