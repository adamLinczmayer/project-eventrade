package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Order;
import com.codecool.adhoc.ticketportal.model.User;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    /*
    TODO: Order queries

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

    @Transactional
    @Modifying
    @Query("UPDATE Order SET status = ?1 WHERE id = ?2")
    void updateOrderStatus(@Param("status")OrderStatus orderStatus, @Param("orderId")Long orderId);

    List<Order> getOrdersByUserId(Long userId);

    List<Order> getOrdersByUserIdAndStatus(Long userId, OrderStatus status);


}
