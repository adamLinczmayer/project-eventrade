package com.codecool.adhoc.ticketportal;

import com.codecool.adhoc.ticketportal.controller.ProductController;
import com.codecool.adhoc.ticketportal.controller.implementation.ThymeleafProductController;
import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.enums.UserType;
import com.codecool.adhoc.ticketportal.utility.DatabaseTool;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class ConcertTicketPortal {
    public static void main(String[] args) {
        DatabaseTool databaseTool = new DatabaseTool("adhocPU");
        EntityManager em = databaseTool.getEm();

        populateDB(em);


        ProductController productController = new ThymeleafProductController(em);
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        get("/hello", (req, res) -> "Hello World");

        get("/index", (req, res) -> new ThymeleafTemplateEngine().render(productController.renderEvents(req, res)));

        enableDebugScreen();
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
