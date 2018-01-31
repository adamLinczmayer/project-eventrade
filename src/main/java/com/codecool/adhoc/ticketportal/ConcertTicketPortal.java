package com.codecool.adhoc.ticketportal;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.model.Location;
import com.codecool.adhoc.ticketportal.model.Ticket;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;

import javax.persistence.*;
import java.util.Date;

public class ConcertTicketPortal {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("adhocPU");
        EntityManager em = emf.createEntityManager();

        populateBandDB(em);
        populateLocationDB(em);
        populateEventDB(em);
        populateTicketDB(em);
    }

    private static void populateBandDB(EntityManager em) {
        Band band = new Band("Lakodalmas Lajos" , MusicStyle.ROLLICKING);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(band);
        transaction.commit();
    }

    private static void populateLocationDB(EntityManager em) {
        Location location = new Location("CodePub", "1064, Bp, Nagymező u. 44.", 150);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
    }

    private static void populateEventDB(EntityManager em) {
        Band band = new Band("Bunyós Pityu" , MusicStyle.ROLLICKING);
        Location location = new Location("laksn", "sdéalkm u. 43421.", 1);
        Event event = new Event(location, new Date(1600, 13, 32));

        event.addBand(band);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        em.persist(band);
        em.persist(event);
        transaction.commit();

    }

    public static void populateTicketDB(EntityManager em){
        Event event = em.find(Event.class, 1L);
        Ticket ticket1 = new Ticket(event, 200f, TicketType.NORMAL);
        Ticket ticket2 = new Ticket(event, 100f, TicketType.STUDENT);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticket1);
        em.persist(ticket2);
        transaction.commit();

    }

}
