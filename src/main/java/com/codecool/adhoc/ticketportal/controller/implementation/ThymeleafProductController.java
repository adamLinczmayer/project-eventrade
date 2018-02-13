package com.codecool.adhoc.ticketportal.controller.implementation;

import com.codecool.adhoc.ticketportal.controller.ProductController;
import com.codecool.adhoc.ticketportal.model.Event;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThymeleafProductController implements ProductController{

    EntityManager em;

    public ThymeleafProductController(EntityManager em){
        this.em = em;
    }

    public  ModelAndView renderEvents(Request req, Response res) {
        //TODO
        // Create hashMap with all events with their name, location and date
        List<Event> events = em.createNamedQuery("Event.findAllEvents", Event.class).getResultList();
        Map<String, Object> params = new HashMap<>();
        params.put("events", events);
        return new ModelAndView(params, "all_events");
    }
}
