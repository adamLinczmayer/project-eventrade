package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{
    /*
    TODO: Event queries

    -* findEventById
    - findAllEvents
    - findUpcomingEvents
    -* findEventsByBand

     */
}
