package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    /*
    TODO: Order queries

    - findOrdersByUserId
    -* findOrdersByStatus
    -* findLineItemsByOrderId

    ??? find by exact statuses
     */
}
