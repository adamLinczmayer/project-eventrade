package com.codecool.adhoc.ticketportal.controller.implementation;

import com.codecool.adhoc.ticketportal.controller.ProductController;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ThymeleafProductController implements ProductController{

    public  ModelAndView renderEvents(Request req, Response res) {
        //TODO
        // Create hashMap with all events with their name, location and date
        Map params = new HashMap<>();
        return new ModelAndView(params, "all_events");
    }
}
