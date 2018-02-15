package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.utility.DatabaseTool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicketTest {

    private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
    private static EntityManager em = databaseTool.getEm();
    private static Ticket ticket1;

    @BeforeAll
    static void populateDB(){
        Event event1 = new Event();
        ticket1 = new Ticket(event1, 2500f, TicketType.NORMAL);
        Ticket ticket2 = new Ticket(event1, 2500f, TicketType.NORMAL);
        Ticket ticket3 = new Ticket(event1, 1500f, TicketType.STUDENT);
        Ticket ticket4 = new Ticket(event1, 1000f, TicketType.GROUP);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(event1);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(ticket3);
        em.persist(ticket4);
        transaction.commit();
    }

    @Test
    void findTicketById() {
        Ticket result = em.find(Ticket.class, 1L);
        assertTrue(result.equals(ticket1));
    }

    @Test
    void findAllTickets() {
        List<Ticket> results = em.createNamedQuery("Ticket.findAllTickets", Ticket.class).getResultList();
        assertTrue(results.size() == 4);
    }
}