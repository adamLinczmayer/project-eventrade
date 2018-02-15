package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.utility.DatabaseTool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventTest {

    private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
    private static EntityManager em = databaseTool.getEm();

    @BeforeAll
    static void populateDB() throws ParseException {
        Location testLocation = new Location("testLoc", "tedress", 300);
        Event event1 = new Event("testEvent1", testLocation, "2000-01-01-12:00", "test description");
        Event event2 = new Event("testEvent2", testLocation, "2018-02-14-12:00", "test description");
        Event event3 = new Event("testEvent3", testLocation, "2018-02-16-12:00", "test description");
        Event event4 = new Event("testEvent4", testLocation, "2100-01-01-12:00", "test description");

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(testLocation);
        em.persist(event1);
        em.persist(event2);
        em.persist(event3);
        em.persist(event4);
        transaction.commit();
    }

    @Test
    void testFindEventById() {
        Event event1 = em.find(Event.class, 1L);
        Event event4 = em.find(Event.class, 4L);
        assertTrue(event1.getName().equals("testEvent1"));
        assertTrue(event4.getName().equals("testEvent4"));
    }

    @Test
    void testFindAllEvents() {
        assertTrue(em.createNamedQuery("Event.findAllEvents", Event.class).getResultList().size() == 4);
    }

    @Test
    void testFindUpcomingEvents() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
        Date testDate = sdf.parse("2018-02-15-12:00");
        assertTrue(em.createNamedQuery("Event.findUpcomingEvents",
                Event.class).setParameter("currentDate", testDate).getResultList().size() == 2);
    }
}
