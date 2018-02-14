package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.utility.DatabaseTool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BandTest {

    private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
    private static EntityManager em = databaseTool.getEm();

    @BeforeAll
    static void populateDB(){
        Band band = new Band("testBand", MusicStyle.LATIN);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(band);
        transaction.commit();
    }


    @Test
    void test(){
        assertTrue(true);
    }

    @Test
    void findBand() {
        Band band1 = em.find(Band.class, 1L);
        assertTrue(band1.getName().equals("testBand"));
    }
}