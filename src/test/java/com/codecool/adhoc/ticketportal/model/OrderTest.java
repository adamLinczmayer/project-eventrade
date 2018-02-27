package com.codecool.adhoc.ticketportal.model;

import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.UserType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderTest {
    private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
    private static EntityManager em = databaseTool.getEm();

    private static Order testOrder;

    @BeforeAll
    static void populateDB() throws ParseException {
        User testUser = new User();
        testOrder = new Order(testUser, OrderStatus.CHECKOUT);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(testUser);
        em.persist(testOrder);
        transaction.commit();
    }

    @Test
    void testFindOrderById() {
        Order order = em.find(Order.class, 1L);
        assertTrue(order.equals(testOrder));
    }
}
