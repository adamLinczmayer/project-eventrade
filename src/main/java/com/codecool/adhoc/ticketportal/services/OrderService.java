package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.LineItem;
import com.codecool.adhoc.ticketportal.model.Order;
import com.codecool.adhoc.ticketportal.model.User;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public void changeOrderStatus(Order order, OrderStatus orderStatus) {
        orderRepository.updateOrderStatus(orderStatus, order.getId());
    }

    public List<Order> getOrdersByUser(User user) {
        return orderRepository.getOrdersByUser(user);
    }

    public List<Order> getOrdersByUserAndStatus(User user, OrderStatus status) {
        return orderRepository.getOrdersByUserAndStatus(user, status);
    }


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
}
