package com.codecool.adhoc.ticketportal.controller;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

public interface ProductController {

    ModelAndView renderEvents(Request request, Response response);
}
