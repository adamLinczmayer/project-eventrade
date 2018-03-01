package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.model.Location;
import com.codecool.adhoc.ticketportal.model.Ticket;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.TicketType;
import com.codecool.adhoc.ticketportal.services.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
class ProductControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController;

    @Mock
    private BandService bandService;
    @Mock
    private EventService eventService;
    @Mock
    private LocationService locationService;
    @Mock
    private OrderService orderService;
    @Mock
    private TicketService ticketService;
    @Mock
    private UserService userService;
    @Mock
    private View mockView;

    private Band band1;
    private Band band2;
    private Event event1;
    private Event event2;
    private Location location1;
    private Location location2;

    @BeforeEach
    void setUp() throws ParseException {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .setSingleView(mockView)
                .build();
        band1 = new Band("band1", MusicStyle.JAZZ, "desc");
        band2 = new Band("band2", MusicStyle.LATIN, "desc");
        location1 = new Location("location1", "address", 500);
        location2 = new Location("location2", "address", 1200);
        event1 = new Event("event1", location1, "2020-10-10-10:10", "desc");
        event2 = new Event("event2", location2, "2019-01-01-01:01", "desc");
    }

    @Test
    void testRenderEvents() throws Exception {
        List<Event> expectedEvents = Arrays.asList(event1, event2);
        when(eventService.findUpcomingEvents()).thenReturn(expectedEvents);
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("events", expectedEvents));
    }

    @Test
    void testRenderEventsError() throws Exception {
        mockMvc.perform(get("/abc"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testRenderSpecificEventPage() throws Exception {
        Event expectedEvent = event1;
        when(eventService.findById(1L)).thenReturn(expectedEvent);
        mockMvc.perform(get("/event/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(model().attribute("event", expectedEvent));
    }

    @Test
    void testRenderSpecificEventPageError() throws Exception {
        Event expectedEvent = event1;
        when(eventService.findById(1L)).thenReturn(expectedEvent);
        mockMvc.perform(get("/event/{id}", 100000000))
                .andExpect(status().isNotFound());
    }

    @Test
    void testRenderBandPage() throws Exception {
        Band expectedBand = band1;
        when(bandService.findBandById(1L)).thenReturn(expectedBand);
        mockMvc.perform(get("/band/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(model().attribute("bandObject", expectedBand));
    }

    @Test
    void testRenderBandPageError() throws Exception {
        Band expectedBand = band1;
        when(bandService.findBandById(1L)).thenReturn(expectedBand);
        mockMvc.perform(get("/band/{id}", 1000000000))
                .andExpect(status().isNotFound());
    }

    @Test
    void testRenderAddEventPage() throws Exception {
        List<Band> expectedBands = Arrays.asList(band1, band2);
        List<Location> expectedLocations = Arrays.asList(location1, location2);
        when(bandService.findAllBand()).thenReturn(expectedBands);
        when(locationService.findAllLocation()).thenReturn(expectedLocations);
        mockMvc.perform(get("/addevent", 1))
                .andExpect(status().isOk())
                .andExpect(model().attribute("allBand", expectedBands))
                .andExpect(model().attribute("locations", expectedLocations))
                .andExpect(model().attribute("musicStyles", MusicStyle.values()));
    }

    @Test
    void testSaveEvent_SetsRightTicketPrice() throws Exception {
        when(locationService.findById(any(Long.class))).thenReturn(location1);
        when(bandService.findBandById(any(Long.class))).thenReturn(band1);

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("ticket-price", "100");
        queryParams.put("location", "345");
        queryParams.put("event-date", "2016-10-12");
        queryParams.put("event-time", "12:23");
        queryParams.put("band", "6");
        productController.saveEvent(queryParams);

        ArgumentCaptor<Ticket> argument = ArgumentCaptor.forClass(Ticket.class);
        verify(ticketService, times(3)).saveTicket(argument.capture());
        List<Ticket> tickets = argument.getAllValues();

        for (Ticket ticket: tickets) {
            if (ticket.getTicketType().equals(TicketType.NORMAL)) {
                assertEquals(100, ticket.getPrice(), 0);
            }
            if (ticket.getTicketType().equals(TicketType.STUDENT)) {
                assertEquals(50, ticket.getPrice(), 0);
            }
            if (ticket.getTicketType().equals(TicketType.GROUP)) {
                assertEquals(350, ticket.getPrice(), 0);
            }
        }
        assertEquals(3, tickets.size());
    }

    @Test
    void testSaveBand() throws Exception {
        Band addedBand = band2;
        when(bandService.saveBand(isA(Band.class))).thenReturn(addedBand);
        mockMvc.perform(post("/add-band")
                .param("name", "band2")
                .param("musicStyle", "LATIN")
                .param("description", "desc"))
                .andExpect(status().isOk());
        ArgumentCaptor<Band> formObjectArgument = ArgumentCaptor.forClass(Band.class);
        verify(bandService, times(1)).saveBand(formObjectArgument.capture());
        verifyNoMoreInteractions(bandService);
    }

    @Test
    void testSaveLocation() throws Exception {
        Location addedLocation = location2;
        when(locationService.saveLocation(isA(Location.class))).thenReturn(addedLocation);
        mockMvc.perform(post("/add-location")
                .param("name", "location2")
                .param("address", "address")
                .param("capacity", "1200"))
                .andExpect(status().isOk());
        ArgumentCaptor<Location> formObjectArgument = ArgumentCaptor.forClass(Location.class);
        verify(locationService, times(1)).saveLocation(formObjectArgument.capture());
        verifyNoMoreInteractions(locationService);

    }

}
