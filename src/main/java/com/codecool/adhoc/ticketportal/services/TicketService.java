package com.codecool.adhoc.ticketportal.services;

import com.codecool.adhoc.ticketportal.model.Ticket;
import com.codecool.adhoc.ticketportal.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }
}
