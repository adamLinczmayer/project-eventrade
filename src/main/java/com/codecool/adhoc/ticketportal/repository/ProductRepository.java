package com.codecool.adhoc.ticketportal.repository;

public interface ProductRepository {

    /*

    TODO: Band queries

    -* findBandById
    - findAllBands
    - findBandByName
    - findBandByMusicStyle
    -* findBandsByEvent

    @NamedQueries({
        @NamedQuery(
                name = "Band.findAllBands",
                query = "SELECT b FROM Band b " +
                        "ORDER BY b.id"),
        @NamedQuery(
                name="Band.findBandByName",
                query = "SELECT b FROM Band b " +
                        "WHERE b.name LIKE :bandName"),
        @NamedQuery(
                name="Band.findBandsByMusicStyle",
                query = "SELECT b FROM Band b " +
                        "WHERE b.musicStyle = :musicStyle")
    })

    TODO: Event queries

    -* findEventById
    - findAllEvents
    - findUpcomingEvents
    -* findEventsByBand

    @Entity
    @NamedQueries({
        @NamedQuery(
                name = "Event.findAllEvents",
                query = "SELECT e FROM Event e "),
        @NamedQuery(
                name="Event.findUpcomingEvents",
                query = "SELECT e FROM Event e " +
                        "WHERE e.date < :currentDate"
        )
    })

    TODO: Location queries

    -* findLocationById
    - findLocationByName
    -? findLocationByAddress

    @Entity
    @NamedQueries({
        @NamedQuery(name = "Location.findByName",
                    query = "SELECT l FROM Location l " +
                            "WHERE l.name LIKE :name"),
        @NamedQuery(name = "Location.findByAddress",
                    query = "SELECT l FROM Location l " +
                            "WHERE l.address LIKE :address")
    })

    TODO: Order queries

    - findOrderByUserId
    -* findOrdersByStatus
    -* findLineItemsByOrderId

    @Entity
    @NamedQueries({
        @NamedQuery(name = "Order.findByUserId",
                    query = "SELECT o FROM Order o " +
                            "WHERE o.users = :users_id")
    })

    TODO: Ticket queries

    - findTicketById
    - findAllTickets
    -* findTicketByEvent

    @Entity
    @NamedQueries({
        @NamedQuery(
                name="Ticket.findAllTickets",
                query="SELECT t FROM Ticket t " +
                        "ORDER BY t.id"),
        @NamedQuery(
                name="Ticket.findTicketById",
                query="SELECT t FROM Ticket t " +
                        "WHERE t.id = :ticketId"
        )
    })

    TODO: User queries

    - findAllUsers
    - findUserById
    -* findUserByName

    @Entity
    @Table(name = "users")
        @NamedQueries({
            @NamedQuery(
                name="User.findAllUsers",
                query="SELECT u FROM User u " +
                        "ORDER BY u.id"),
            @NamedQuery(
                name="User.findUserById",
                query="SELECT u FROM User u " +
                        "WHERE u.id = :userId"
           )
    })

    */
}
