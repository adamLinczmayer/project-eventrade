package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.excepitons.NoObjectInDatabaseException;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public interface ProductController {

    ModelAndView renderEvents(Request request, Response response);

    ModelAndView renderEventPage(Request request, Response response) throws NoObjectInDatabaseException;

    ModelAndView renderBandPage(Request request, Response response) throws NoObjectInDatabaseException;
}
