package com.codecool.adhoc.ticketportal.services;

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

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void changeOrderStatus(Order order, OrderStatus orderStatus) {
        orderRepository.updateOrderStatus(orderStatus, order.getId());
    }

    public List<Order> getOrderByUserId(User user) {
        return orderRepository.getOrdersByUsers(user);

    }

    public List<Order> getOrdersByUserIdAndStatus(User user, OrderStatus status) {
        return orderRepository.getOrdersByUsersAndStatus(user, status);
    }

}
