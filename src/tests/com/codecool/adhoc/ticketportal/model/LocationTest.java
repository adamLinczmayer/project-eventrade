package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.utility.DatabaseTool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocationTest {

    private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
    private static EntityManager em = databaseTool.getEm();

    @BeforeAll
    static void populateDB(){
        Location location1 = new Location("testLocation1", "testAddress1", 100);
        Location location2 = new Location("testLocation2", "testAddress2", 110);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(location1);
        em.persist(location2);
        transaction.commit();
    }

    @Test
    void findLocationById() {
        Location location1 = em.find(Location.class, 1L);
        assertTrue(location1.getName().equals("testLocation1"));
    }

    @Test
    void findLocationByName() {
        Location result = em.createNamedQuery("Location.findByName", Location.class)
                .setParameter("name", "testLocation1").getSingleResult();
        assertTrue(result.getName().equals("testLocation1"));
    }

    @Test
    void findLocationByAddress() {
        Location result = em.createNamedQuery("Location.findByAddress", Location.class)
                .setParameter("address", "testAddress1").getSingleResult();
        assertTrue(result.getName().equals("testLocation1"));
    }

    @Test
    void findLocationsByName() {
        List<Location> results = em.createNamedQuery("Location.findByName", Location.class)
                .setParameter("name", "%testLocation%").getResultList();
        List<String> expectedResultsName = Arrays.asList("testLocation1", "testLocation2");
        assertTrue(results.get(0).getName().equals(expectedResultsName.get(0)));
        assertTrue(results.get(1).getName().equals(expectedResultsName.get(1)));
    }

    @Test
    void findLocationsByAddress() {
        List<Location> results = em.createNamedQuery("Location.findByAddress", Location.class)
                .setParameter("address", "%testAddress%").getResultList();
        List<String> expectedResultsName = Arrays.asList("testLocation1", "testLocation2");
        assertTrue(results.get(0).getName().equals(expectedResultsName.get(0)));
        assertTrue(results.get(1).getName().equals(expectedResultsName.get(1)));
    }

    @Test
    void findLocationByNameException() {
        assertThrows(NoResultException.class, () -> em.createNamedQuery("Location.findByName", Location.class)
                .setParameter("name", "testLocation").getSingleResult());
    }
}