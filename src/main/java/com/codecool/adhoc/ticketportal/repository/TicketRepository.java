package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.model.Ticket;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{

    List<Ticket> findTicketsByEvent(Event event);
}
