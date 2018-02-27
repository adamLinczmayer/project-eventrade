package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    /*
    TODO: Order queries

    - createOrder
    - changeOrderStatus
    - findOrdersByUserId
    - findOrdersByStatusAndUserId
    - addLineItemToOrder
    - deleteLineItemFromOrder
    - clearLineItemsFromOrder
    - increaseLineItemQuantity
    - decreaseLineItemQuantity
    - setLineItemQuantity

     */


}
