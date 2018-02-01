package com.codecool.adhoc.ticketportal;

import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.enums.UserType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcertTicketPortal {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("adhocPU");
        EntityManager em = emf.createEntityManager();

        populateBandDB(em);
        populateLocationDB(em);
        populateEventDB(em);
        populateTicketDB(em);

        populateUserDB(em);
        populateLineItemDB(em);
        populateOrderDB(em);
        populateCartDB(em);

        List<Ticket> allTickets = em.createNamedQuery(
                "Ticket.findAllTickets", Ticket.class)
                .getResultList();
        System.out.println(allTickets);

        List<User> allUsers = em.createNamedQuery(
                "User.findAllUsers", User.class)
                .getResultList();
        System.out.println(allUsers);

        List<Event> allEvents = em.createNamedQuery("Event.findAllEvents", Event.class).getResultList();
        System.out.println(allEvents);

        List<LineItem> allLineItems = em.createNamedQuery("LineItem.findAllLineItems", LineItem.class).getResultList();
        System.out.println(allLineItems);

        em.close();
        emf.close();
    }

    private static void populateBandDB(EntityManager em) {
        Band band = new Band("Lakodalmas Lajos" , MusicStyle.ROLLICKING);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(band);
        transaction.commit();

        System.out.println(em.createNamedQuery("Band.findAllBands").getResultList());
    }

    private static void populateLocationDB(EntityManager em) {
        Location location = new Location("CodePub", "1064, Bp, Nagymező u. 44.", 150);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();

        System.out.println(em.createNamedQuery("Location.findByName").setParameter("name", "code").getResultList());
    }

    private static void populateEventDB(EntityManager em) {
        Band band = new Band("Bunyós Pityu" , MusicStyle.ROLLICKING);
        Location location = new Location("laksn", "sdéalkm u. 43421.", 1);
        Event event = new Event("Bunyós Pityu koncert", location, new Date(1600, 13, 32));

        event.addBand(band);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        em.persist(band);
        em.persist(event);
        transaction.commit();

    }

    private static void populateTicketDB(EntityManager em){
        Event event = em.find(Event.class, 1L);
        Ticket ticket1 = new Ticket(event, 200f, TicketType.NORMAL);
        Ticket ticket2 = new Ticket(event, 100f, TicketType.STUDENT);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(ticket1);
        em.persist(ticket2);
        transaction.commit();

    }

    private static void populateLineItemDB(EntityManager em) {
        Ticket ticket1 = em.find(Ticket.class, 1L);
        Cart cart1 = em.find(Cart.class, 1L);

        LineItem lineItem1 = new LineItem(ticket1, cart1, 1);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(lineItem1);
        transaction.commit();
    }

    private static void populateCartDB(EntityManager em) {
        Cart cart1 = new Cart();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(cart1);
        transaction.commit();

        cart1.addLineItem(lineItem1);
        System.out.println(em.createNamedQuery("Cart.findAllCarts").getResultList());
    }

    private static void populateUserDB(EntityManager em) {
        Cart cart1 = new Cart();
        User user1 = new User("Jancsika", "j@email.com", "Kukorica Jancsi",
                UserType.BUYER, cart1, null);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user1);
        em.persist(cart1);
        transaction.commit();
    }

    private static void populateOrderDB(EntityManager em) {
        Ticket ticket1 = em.find(Ticket.class, 1L);
        Cart cart1 = em.find(Cart.class, 1L);
        LineItem lineItem1 = new LineItem(ticket1, cart1, 1);
        Set<LineItem> lineItems = new HashSet<>();
        lineItems.add(lineItem1);
        User user1 = em.find(User.class, 1L);

        Order order1 = new Order(user1, lineItems, OrderStatus.NEW);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(lineItem1);
        em.persist(order1);
        transaction.commit();
    }

}
