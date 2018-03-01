package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.enums.UserType;
import com.codecool.adhoc.ticketportal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Long.parseLong;

@Controller
public class ProductController {
    @Autowired
    BandService bandService;

    @Autowired
    EventService eventService;

    @Autowired
    LocationService locationService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    TicketService ticketService;


    @GetMapping(value = "")
    public String renderEvents(Model model) throws ParseException {
        model.addAttribute("events", eventService.findUpcomingEvents());
        return "all_events";
    }


    @GetMapping(value = "/event/{id}")
    public String renderSpecificEventPage(Model model,
                                          @PathVariable("id") String id) {
        Long eventId;
        eventId = parseLong(id);
        Event event = eventService.findById(eventId);
        List<Ticket> tickets = ticketService.findTicketsByEvent(event);
        model.addAttribute("event", event);
        model.addAttribute("tickets", tickets);
        return "event_page";
    }


    @GetMapping(value = "/band/{id}")
    public String renderBandPage(Model model,
                                 @PathVariable("id") String id){
        Long bandId;
        bandId = parseLong(id);
        System.out.println(bandId);
        model.addAttribute("bandObject", bandService.findBandById(bandId));
        return "band_page";
    }


    @GetMapping(value = "/cart")
    public String renderCartPage(Model model) {
        User user = userService.findUserById(1L);
        List<Order> orders = orderService.getOrdersByUserIdAndStatus(user, OrderStatus.CART);
        Order order = orders.get(0); // There is only 1 order with cart status
        Set<LineItem> lineItems = order.getLineItems();
        model.addAttribute("lineItems", lineItems);
        return "cart_page";
    }


    @GetMapping(value = "/checkout")
    public String purchasing() {
        User user = userService.findUserById(1L);
        List<Order> orders = orderService.getOrdersByUserIdAndStatus(user, OrderStatus.CART);
        Order order = orders.get(0);
        order.setStatus(OrderStatus.CHECKOUT);
        orderService.saveOrder(order);
        Order newOrder = new Order(user, OrderStatus.CART);
        orderService.saveOrder(newOrder);
        return "redirect:/";
    }


    @PostMapping(value = "/add-to-cart")
    public @ResponseBody void addToCart(@RequestParam Map<String, String> queryParameters){
        Long ticketId = Long.parseLong(queryParameters.get("ticketId"), 10);
        Integer quantity = Integer.parseInt(queryParameters.get("quantity"));
        Order cart = orderService.getOrdersByUserIdAndStatus(userService.findUserById(1L),
                OrderStatus.CART).get(0);
        Set<LineItem>cartLineItems = cart.getLineItems();
        boolean isItExists = false;
        if(cartLineItems != null && cartLineItems.size() > 0) {
            for(LineItem lineItem:cartLineItems) {
                if(Objects.equals(lineItem.getTicket().getId(), ticketId)) {
                    lineItem.setQuantity(lineItem.getQuantity()+quantity);
                    isItExists = true;
                }
            }
        }

        if(!isItExists) {
            LineItem lineItem = new LineItem(ticketService.findTicketById(ticketId), quantity);
            cart.addLineItem(lineItem);
        }
        orderService.saveOrder(cart);
    }

    @PostMapping(value = "/change-quantity")
    public @ResponseBody void changeQuantity(@RequestParam Map<String, String> queryParameters) {
        Long ticketId = Long.parseLong(queryParameters.get("ticketId"), 10);
        Integer quantity = Integer.parseInt(queryParameters.get("quantity"));
        Order cart = orderService.getOrdersByUserIdAndStatus(userService.findUserById(1L),
                OrderStatus.CART).get(0);
        Set<LineItem>cartLineItems = cart.getLineItems();
        for(LineItem lineItem:cartLineItems) {
            if(Objects.equals(lineItem.getTicket().getId(), ticketId)) {
                lineItem.setQuantity(quantity);
            }
        }
    }
}
