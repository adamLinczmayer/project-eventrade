package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.model.Ticket;
import com.codecool.adhoc.ticketportal.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public void saveTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    public List<Ticket> findTicketsByEvent(Event event) {
        return ticketRepository.findTicketsByEvent(event);
    }

    public Ticket findTicketById(Long id) {
        return ticketRepository.findOne(id);
    }

}
