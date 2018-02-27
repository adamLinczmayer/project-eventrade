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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;

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
    public String renderEvents(Model model){
        model.addAttribute("events", eventService.findAll());
        return "all_events";
    }


    @GetMapping(value = "/event/{id}")
    public String renderSpecificEventPage(Model model,
                                          @PathVariable("id") String id) {
        Long eventId;
        eventId = parseLong(id);
        model.addAttribute("event", eventService.findById(eventId));
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






}
