package com.codecool.adhoc.ticketportal.utils;

import com.codecool.adhoc.ticketportal.model.*;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.model.enums.UserType;
import com.codecool.adhoc.ticketportal.services.*;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class InitializerBean {

    public InitializerBean(BandService bandService,
                           EventService eventService,
                           LocationService locationService,
                           OrderService orderService,
                           TicketService ticketService,
                           UserService userService) throws ParseException{
        Band band1 = new Band("Lakodalmas Lajos", MusicStyle.ROLLICKING, "Támogatónk az E.ON! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pharetra porttitor aliquet.\nSed finibus, nibh id dapibus euismod, dui erat bibendum turpis, non sodales tellus arcu et leo.");
        Band band2 = new Band("Bunyós Pityu", MusicStyle.ROLLICKING, "Gyere ki a hóra. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pharetra porttitor aliquet.\nSed finibus, nibh id dapibus euismod, dui erat bibendum turpis, non sodales tellus arcu et leo.");
        Band band3 = new Band("Fásy Ádám", MusicStyle.ROLLICKING, "Fásy Mulató forever!!! Morbi ex lectus, vulputate id nisl vel, lobortis posuere diam. Sed suscipit eros ligula, a elementum ex auctor at.\nNam ullamcorper blandit tincidunt. Aenean eget diam mauris.");
        Band band4 = new Band("AC/DC", MusicStyle.ROCK, "Thunderstuck!!! AC/DC are an Australian rock band, formed in Sydney in 1973 by brothers Malcolm and Angus Young. They refer to themselves as \"a rock and roll band, nothing more, nothing less\".");

        Location location1 = new Location("CodePub", "1064, Bp, Nagymező u. 44.", 150);
        Location location2 = new Location("Lakas", "Leninvaros, Panel u. 43421.", 5);
        Location location3 = new Location("Zúzda", "1011, Bp, Rúgdkiaházoldalát u. 42.", 150);
        Event event1 = new Event("Bunyós Pityu Hazibuli", location2, "2018-04-28-18:00", "Itt ugassál!");
        Event event2 = new Event("Lakodalom Lajossal", location2, "2019-02-28-18:00", "Az áram is belédcsap, olyan buli lesz");
        Event event3 = new Event("Rock or Bust World Tour", location2, "2018-03-16-10:00", "Rock or Bust World Tour was a 2015-2016 concert tour by Australian rock band AC/DC in support of the group's sixteenth studio album, Rock or Bust, released in November 2014.");
        event1.addBand(band2);
        event2.addBand(band1);
        event3.addBand(band4);
        event2.addBand(band3);
        Ticket ticket1 = new Ticket(event1, 200f, TicketType.NORMAL);
        Ticket ticket2 = new Ticket(event1, 100f, TicketType.STUDENT);
        User user = new User("Jancsika", "j@email.com", "Kukorica Jancsi", UserType.BUYER);
        Order order = new Order(user, OrderStatus.CART);

        bandService.saveBand(band1);
        bandService.saveBand(band2);
        bandService.saveBand(band3);
        bandService.saveBand(band4);

        location1 = locationService.saveLocation(location1);
        location2 = locationService.saveLocation(location2);
        location3 = locationService.saveLocation(location3);

        eventService.saveEvent(event1);
        eventService.saveEvent(event2);
        eventService.saveEvent(event3);
        

        ticketService.saveTicket(ticket1);
        ticketService.saveTicket(ticket2);

        userService.saveUser(user);

        orderService.saveOrder(order);
    }
}
