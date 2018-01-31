package com.codecool.adhoc.ticketportal;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.Location;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;

import javax.persistence.*;

public class ConcertTicketPortal {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("adhocPU");
        EntityManager em = emf.createEntityManager();

        populateBandDB(em);
        populateLocationDB(em);

    }

    public static void populateBandDB(EntityManager em) {
        Band band = new Band("Lakodalmas Lajos" , MusicStyle.ROLLICKING);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(band);
        transaction.commit();
    }

    public static void populateLocationDB(EntityManager em) {
        Location location = new Location("CodePub", "1064, Bp, Nagymező u. 44.", 150);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location);
        transaction.commit();
    }
}
