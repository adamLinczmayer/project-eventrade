package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.Order;
import com.codecool.adhoc.ticketportal.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public void saveOrder(Order order){
        orderRepository.save(order);
    }
}
