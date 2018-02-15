package com.codecool.adhoc.ticketportal.controller.implementation;

import com.codecool.adhoc.ticketportal.controller.ProductController;
import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.enums.UserType;
import com.codecool.adhoc.ticketportal.model.excepitons.NoObjectInDatabaseException;
import com.codecool.adhoc.ticketportal.utility.DatabaseTool;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ThymeleafProductControllerTest {

    private static DatabaseTool databaseTool = new DatabaseTool("testAdhocPU");
    private static EntityManager em = databaseTool.getEm();
    private static ProductController productController = new ThymeleafProductController(em);
    private static Request request;
    private static Response response;

    @BeforeAll
    static void populateDB() throws ParseException{
        Band band1 = new Band("TestBand1" , MusicStyle.RNB, "TestDescription1");
        Band band2 = new Band("TestBand2" , MusicStyle.FOLK, "TestDescription2");
        Location location1 = new Location("TestLocation1", "TestAddress1", 150);
        Location location2 = new Location("TestLocation2", "TestAddress2", 5);
        Event event1 = new Event("TestEvent1", location2, "2018-02-28-18:00", "asd");
        Event event2 = new Event("TestEvent2", location2, "2018-02-28-18:00", "asd");
        event1.addBand(band2);
        event2.addBand(band1);
        Ticket ticket1 = new Ticket(event1, 200f, TicketType.NORMAL);
        Ticket ticket2 = new Ticket(event2, 100f, TicketType.STUDENT);

        User user = new User("TestUser", "test@test.com", "Te St", UserType.BUYER);
        Order order = new Order(user, OrderStatus.CART);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(band1);
        em.persist(band2);
        em.persist(location1);
        em.persist(location2);
        em.persist(event1);
        em.persist(event2);
        em.persist(ticket1);
        em.persist(ticket2);
        em.persist(user);
        em.persist(order);
        transaction.commit();
    }

    @BeforeAll
    static void objectMocking(){
        request = Mockito.mock(Request.class);

    }

    @Test
    void renderEventPageThrowsNumberFormatException() throws NumberFormatException, NoObjectInDatabaseException{
        when(request.params(":id")).thenReturn("a");
        assertThrows(NumberFormatException.class, () -> productController.renderEventPage(request, response));
    }

    @Test
    void renderEventPageThrowsNoObjectInDatabaseException() throws NumberFormatException, NoObjectInDatabaseException{
        when(request.params(":id")).thenReturn("5");
        assertThrows(NoObjectInDatabaseException.class, () -> productController.renderEventPage(request, response));
    }

    @Test
    void renderBandPageThrowsNumberFormatException() throws NumberFormatException, NoObjectInDatabaseException{
        when(request.params(":id")).thenReturn("a");
        assertThrows(NumberFormatException.class, () -> productController.renderEventPage(request, response));
    }

    @Test
    void renderBandPageThrowsNoObjectInDatabaseException() throws NumberFormatException, NoObjectInDatabaseException{
        when(request.params(":id")).thenReturn("6");
        assertThrows(NoObjectInDatabaseException.class, () -> productController.renderEventPage(request, response));
    }
}