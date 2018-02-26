package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.UserType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
    private static EntityManager em = databaseTool.getEm();

    @BeforeAll
    static void populateDB() throws ParseException {
        User testUser1 = new User("testUser1", "test1@mail.com", "Test User1", UserType.BUYER);
        User testUser2 = new User("testUser2", "test2@mail.com", "Test User2", UserType.BUYER);
        User testUser3 = new User("testUser3", "test3@mail.com", "Test User3", UserType.SELLER);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(testUser1);
        em.persist(testUser2);
        em.persist(testUser3);
        transaction.commit();
    }

    @Test
    void testFindUserById() {
        User user = em.find(User.class, 1L);
        assertTrue(user.getUserName().equals("testUser1"));
    }

    @Test
    void testFindAllUsers() {
        assertTrue(em.createNamedQuery("User.findAllUsers").getResultList().size() == 3);
    }

}
