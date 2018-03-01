package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.excepitons.NoObjectInDatabaseException;
import com.codecool.adhoc.ticketportal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.*;

import java.util.Map;


import static java.lang.Integer.parseInt;
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
                                          @PathVariable("id") String id) throws NoObjectInDatabaseException {
        Long eventId;
        eventId = parseLong(id);
        Event event = eventService.findById(eventId);
        List<Ticket> tickets = ticketService.findTicketsByEvent(event);
        model.addAttribute("event", event);
        model.addAttribute("tickets", tickets);
        if(event == null){
            throw new NoObjectInDatabaseException("There is no such Event");
        }
        model.addAttribute("event", event);
        return "event_page";
    }


    @GetMapping(value = "/band/{id}")
    public String renderBandPage(Model model,
                                 @PathVariable("id") String id) throws NoObjectInDatabaseException {
        Long bandId;
        bandId = parseLong(id);
        Band band = bandService.findBandById(bandId);
        if(band==null){
            throw new NoObjectInDatabaseException("There is no such Event");
        }
        model.addAttribute("bandObject", band);
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

    @GetMapping(value = "/addevent")
    public String renderAddEventPage(Model model){
        model.addAttribute("allBand", bandService.findAllBand());
        model.addAttribute("locations", locationService.findAllLocation());
        model.addAttribute("musicStyles", MusicStyle.values());
        return "add_event";
    }


    @PostMapping(value = "/save-event")
    public String saveEvent(@RequestParam Map<String, String> queryParameters) throws ParseException{
        System.out.println(queryParameters);
        Event newEvent = new Event(queryParameters.get("event-name"),
                                    locationService.findById(parseLong(queryParameters.get("location"))),
                                    queryParameters.get("event-date") + "-" + queryParameters.get("event-time"),
                                    queryParameters.get("event-description"));
        newEvent.addBand(bandService.findBandById(parseLong(queryParameters.get("band"))));
        newEvent = eventService.saveEvent(newEvent);
        Integer defaultTicketPrice = parseInt(queryParameters.get("ticket-price"));
        for(TicketType ticketType: TicketType.values()){

            Ticket ticket = new Ticket(newEvent, defaultTicketPrice * ticketType.getMultiplier(), ticketType);
            ticketService.saveTicket(ticket);
        }
        return "redirect:/";
    }


    @PostMapping(value = "/add-band")
    public @ResponseBody Band saveBand(@RequestParam Map<String, String> queryParameters){
        Band band = new Band(queryParameters.get("name"), MusicStyle.valueOf(queryParameters.get("musicStyle")), queryParameters.get("description"));
        Band savedBand = bandService.saveBand(band);
        System.out.println(savedBand);
        return savedBand;
    }

    
    @PostMapping(value = "/add-to-cart")
    public @ResponseBody void addToCart(@RequestParam Map<String, String> queryParameters) {
        Long ticketId = Long.parseLong(queryParameters.get("ticketId"), 10);
        Integer quantity = Integer.parseInt(queryParameters.get("quantity"));
        Order cart = orderService.getOrdersByUserIdAndStatus(userService.findUserById(1L),
                OrderStatus.CART).get(0);
        Set<LineItem> cartLineItems = cart.getLineItems();
        boolean isItExists = false;
        if (cartLineItems != null && cartLineItems.size() > 0) {
            for (LineItem lineItem : cartLineItems) {
                if (Objects.equals(lineItem.getTicket().getId(), ticketId)) {
                    lineItem.setQuantity(lineItem.getQuantity() + quantity);
                    isItExists = true;
                }
            }
        }

        if (!isItExists) {
            LineItem lineItem = new LineItem(ticketService.findTicketById(ticketId), quantity);
            cart.addLineItem(lineItem);
        }
        orderService.saveOrder(cart);
    }

    @PostMapping(value = "/add-location")
    public @ResponseBody Location saveLocation(@RequestParam Map<String, String> queryParameters){
        Location location = locationService.saveLocation(new Location(queryParameters.get("name"), queryParameters.get("address"), parseInt(queryParameters.get("capacity"))));
        return location;
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
        cart.setLineItems(cartLineItems);
        orderService.saveOrder(cart);
    }

    @PostMapping(value = "/delete-lineitem")
    public @ResponseBody void deleteLineItem(@RequestParam Map<String, String> queryParameters) {
        Long ticketId = Long.parseLong(queryParameters.get("ticketId"), 10);
        Order cart = orderService.getOrdersByUserIdAndStatus(userService.findUserById(1L),
                OrderStatus.CART).get(0);
        Set<LineItem>cartLineItems = cart.getLineItems();
        for(LineItem lineItem:cartLineItems) {
            if(Objects.equals(lineItem.getTicket().getId(), ticketId)) {
                cartLineItems.remove(lineItem);
            }
        }
        cart.setLineItems(cartLineItems);
        orderService.saveOrder(cart);
    }
}
