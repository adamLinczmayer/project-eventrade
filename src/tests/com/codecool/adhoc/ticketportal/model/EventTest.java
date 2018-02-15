package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.utility.DatabaseTool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class EventTest {
        private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
        private static EntityManager em = databaseTool.getEm();

        @BeforeAll
        static void populateDB() throws ParseException {
            Location testLocation = new Location("testLoc", "tedress", 300);
            Event event = new Event("testEvent", testLocation, "2000-01-01-12:00");

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(testLocation);
            em.persist(event);
            transaction.commit();
        }

    @Test
    void findBand() {
        Event event = em.find(Event.class, 1L);
        assertTrue(event.getName().equals("testEvent"));
    }

}
