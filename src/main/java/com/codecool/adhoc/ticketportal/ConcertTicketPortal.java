package com.codecool.adhoc.ticketportal;

import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.enums.UserType;

import javax.persistence.*;
import java.util.*;

public class ConcertTicketPortal {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("adhocPU");
        EntityManager em = emf.createEntityManager();

        populateDB(em);
        Scanner userInput = new Scanner(System.in);
        Integer chosenMenuOption = null;
        while(chosenMenuOption == null){
            int input = userInput.nextInt();
            switch (input){
                case 1: System.out.print("\033[H\033[2J"); System.out.println(em.createNamedQuery("User.findAllUsers", User.class).getResultList()); break;
                case 2: System.out.print("\033[H\033[2J"); System.out.println(em.createNamedQuery("Band.findAllBands", Band.class).getResultList()); break;
                case 3: System.out.print("\033[H\033[2J"); System.out.println(em.createNamedQuery("Location.findByName", Location.class).setParameter("name", "%"+"Code"+"%").getResultList()); break;
                case 4: System.out.print("\033[H\033[2J"); System.out.println(em.createNamedQuery("Event.findAllEvents", Event.class).getResultList()); break;
                case 5: System.out.print("\033[H\033[2J"); System.out.println(em.createNamedQuery("Ticket.findAllTickets", Ticket.class).getResultList()); break;
                case 7: chosenMenuOption = 0;
            }
        }
        
        em.close();
        emf.close();
    }

    private static void populateDB(EntityManager entityManager){
        Band band1 = new Band("Lakodalmas Lajos" , MusicStyle.ROLLICKING);
        Band band2 = new Band("Bunyós Pityu" , MusicStyle.ROLLICKING);
        Location location1 = new Location("CodePub", "1064, Bp, Nagymező u. 44.", 150);
        Location location2 = new Location("Lakas", "Leninvaros, Panel u. 43421.", 5);
        Event event = new Event("Bunyós Pityu Hazibuli", location2, new Date(1600, 13, 32));
        event.addBand(band2);
        Ticket ticket1 = new Ticket(event, 200f, TicketType.NORMAL);
        Ticket ticket2 = new Ticket(event, 100f, TicketType.STUDENT);
        User user = new User("Jancsika", "j@email.com", "Kukorica Jancsi", UserType.BUYER);
        Order order = new Order(user, OrderStatus.CART);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(band1);
        entityManager.persist(band2);
        entityManager.persist(location1);
        entityManager.persist(location2);
        entityManager.persist(event);
        entityManager.persist(ticket1);
        entityManager.persist(ticket2);
        entityManager.persist(user);
        entityManager.persist(order);
        transaction.commit();
    }
}
