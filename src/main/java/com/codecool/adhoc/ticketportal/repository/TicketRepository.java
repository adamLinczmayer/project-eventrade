package com.codecool.adhoc.ticketportal.repository;

import com.codecool.adhoc.ticketportal.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
