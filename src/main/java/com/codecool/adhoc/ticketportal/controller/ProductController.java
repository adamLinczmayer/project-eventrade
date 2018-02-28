package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.enums.UserType;
import com.codecool.adhoc.ticketportal.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;

import java.util.Map;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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
        eventService.saveEvent(newEvent);
        return "redirect:/";
    }

    @PostMapping(value = "/add-band")
    public @ResponseBody Band saveBand(@RequestParam Map<String, String> queryParameters){
        Band band = new Band(queryParameters.get("name"), MusicStyle.valueOf(queryParameters.get("musicStyle")), queryParameters.get("description"));
        Band savedBand = bandService.saveBand(band);
        System.out.println(savedBand);
        return savedBand;
    }

}
