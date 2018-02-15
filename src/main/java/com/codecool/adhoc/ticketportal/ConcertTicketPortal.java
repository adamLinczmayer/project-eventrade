package com.codecool.adhoc.ticketportal;

import com.codecool.adhoc.ticketportal.controller.ProductController;
import com.codecool.adhoc.ticketportal.controller.implementation.ThymeleafProductController;
import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.enums.UserType;
import com.codecool.adhoc.ticketportal.model.excepitons.NoObjectInDatabaseException;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.text.ParseException;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class ConcertTicketPortal {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("adhocPU");
        EntityManager em = emf.createEntityManager();
        try {
            populateDB(em);
        }catch (ParseException e){
            e.printStackTrace();
        }

        ProductController productController = new ThymeleafProductController(em);
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        get("/hello", (req, res) -> "Hello World");

        get("/events", (req, res) -> new ThymeleafTemplateEngine().render(productController.renderEvents(req, res)));

        get("/band/:id", (req, res) -> {
            try {
                return new ThymeleafTemplateEngine().render(productController.renderBandPage(req, res));
            } catch (NumberFormatException e) {
                res.status(404);
                return res.raw().getStatus();
            } catch (NoObjectInDatabaseException e) {
                res.status(404);
                return res.raw().getStatus() + e.getMessage();
            }
        });

        get("/event/:id", (req, res) -> {
            try {
                return new ThymeleafTemplateEngine().render(productController.renderEventPage(req, res));
            } catch (NumberFormatException e) {
                res.status(404);
                return res.raw().getStatus();
            } catch (NoObjectInDatabaseException e) {
                res.status(404);
                return res.raw().getStatus() + e.getMessage();
            }
        });


        enableDebugScreen();
    }

    private static void populateDB(EntityManager entityManager) throws ParseException {
        Band band1 = new Band("Lakodalmas Lajos", MusicStyle.ROLLICKING, "Támogatónk az E.ON! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pharetra porttitor aliquet. Sed finibus, nibh id dapibus euismod, dui erat bibendum turpis, non sodales tellus arcu et leo.");
        Band band2 = new Band("Bunyós Pityu", MusicStyle.ROLLICKING, "Gyere ki a hóra. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pharetra porttitor aliquet. Sed finibus, nibh id dapibus euismod, dui erat bibendum turpis, non sodales tellus arcu et leo.");
        Band band3 = new Band("Fásy Ádám", MusicStyle.ROLLICKING, "Fásy Mulató forever!!! Morbi ex lectus, vulputate id nisl vel, lobortis posuere diam. Sed suscipit eros ligula, a elementum ex auctor at. Nam ullamcorper blandit tincidunt. Aenean eget diam mauris.");
        Band band4 = new Band("AC/DC", MusicStyle.ROCK, "Thunderstuck!!! AC/DC are an Australian rock band, formed in Sydney in 1973 by brothers Malcolm and Angus Young. They refer to themselves as \"a rock and roll band, nothing more, nothing less\".");

        Location location1 = new Location("CodePub", "1064, Bp, Nagymező u. 44.", 150);
        Location location2 = new Location("Lakas", "Leninvaros, Panel u. 43421.", 5);
        Location location3 = new Location("Zúzda", "1011, Bp, Rúgdkiaházoldalát u. 42.", 150);

        Event event1 = new Event("Bunyós Pityu Hazibuli", location2, "2018-02-28-18:00", "Itt ugassál!");
        Event event2 = new Event("Lakodalom Lajossal", location2, "2019-02-28-18:00", "Az áram is belédcsap, olyan buli lesz");
        Event event3 = new Event("Rock or Bust World Tour", location2, "2018-02-16-10:00", "Rock or Bust World Tour was a 2015-2016 concert tour by Australian rock band AC/DC in support of the group's sixteenth studio album, Rock or Bust, released in November 2014.");
        event1.addBand(band2);
        event2.addBand(band1);
        event3.addBand(band4);
        event2.addBand(band3);
        Ticket ticket1 = new Ticket(event1, 200f, TicketType.NORMAL);
        Ticket ticket2 = new Ticket(event1, 100f, TicketType.STUDENT);
        User user = new User("Jancsika", "j@email.com", "Kukorica Jancsi", UserType.BUYER);
        Order order = new Order(user, OrderStatus.CART);

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(band1);
        entityManager.persist(band2);
        entityManager.persist(band3);
        entityManager.persist(band4);
        entityManager.persist(location1);
        entityManager.persist(location2);
        entityManager.persist(location3);
        entityManager.persist(event1);
        entityManager.persist(event2);
        entityManager.persist(event3);
        entityManager.persist(ticket1);
        entityManager.persist(ticket2);
        entityManager.persist(user);
        entityManager.persist(order);
        transaction.commit();
    }
}
