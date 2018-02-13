package com.codecool.adhoc.ticketportal.controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;

public class ProductController {
    public static ModelAndView renderEvents(Request req, Response res) {
        //TODO
        // Create hashMap with all events with their name, location and date
        return new ModelAndView(new HashMap<>(), "all_events");
    }
}
