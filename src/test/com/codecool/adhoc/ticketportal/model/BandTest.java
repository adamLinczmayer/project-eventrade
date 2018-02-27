/*
package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BandTest {

    private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
    private static EntityManager em = databaseTool.getEm();

    @BeforeAll
    static void populateDB() {
        Band band = new Band("testBand", MusicStyle.LATIN,"test");
        Band band1 = new Band("SecondBand", MusicStyle.FOLK, "");
        Band band2 = new Band("ThirdBand", MusicStyle.HIPHOP,"testDescription");
        Band band3 = new Band("FourthBand", MusicStyle.HIPHOP, "Biggest HipHop Band");
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(band);
        em.persist(band1);
        em.persist(band2);
        em.persist(band3);
        transaction.commit();
    }


    @Test
    void test() {
        assertTrue(true);
    }

    @Test
    void testFindBand() {
        Band band1 = em.find(Band.class, 1L);
        assertTrue(band1.getName().equals("testBand"));
    }

    @Test
    void testFindAllBand() {
        assertTrue(em.createNamedQuery("Band.findAllBands", Band.class).getResultList().size() == 4);
    }

    @Test
    void testFindBandByName() {
        Band band = em.createNamedQuery("Band.findBandByName", Band.class).setParameter("bandName", "testBand").getSingleResult();
        Band band1 = em.createNamedQuery("Band.findBandByName", Band.class).setParameter("bandName", "%Second%").getSingleResult();
        assertTrue(band.getName().equals("testBand"));
        assertTrue(band1.getName().equals("SecondBand"));
    }

    @Test
    void testFindBandsWithSameMusicStyle() {
        List<Band> hipHopBands = em.createNamedQuery("Band.findBandsByMusicStyle", Band.class).setParameter("musicStyle", MusicStyle.HIPHOP).getResultList();
        assertTrue(hipHopBands.size()==2);
    }
}*/
