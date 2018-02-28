package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.model.Location;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.services.*;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .setSingleView(mockView)
                .build();
    }

    @Test
    void testViewEvents() throws Exception {
        List<Event> expectedEvents = Arrays.asList(
                new Event("event1", new Location(), "2020-10-10-10:10", "desc"),
                new Event("event2", new Location(), "2019-01-01-01:01", "desc"));
        when(eventService.findUpcomingEvents()).thenReturn(expectedEvents);
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("events", expectedEvents));
    }

    @Test
    void testViewEventsError() throws Exception {
        mockMvc.perform(get("/abc"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testViewEvent() throws Exception {
        Event expectedEvent = new Event("event1", new Location(), "2020-10-10-10:10", "desc");
        when(eventService.findById(1L)).thenReturn(expectedEvent);
        mockMvc.perform(get("/event/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(model().attribute("event", expectedEvent));
    }

    /*@Test
    void testViewEventError() throws Exception {
        mockMvc.perform(get("/event/{id}", 100000000L))
                .andExpect(status().isNotFound());
    }*/

    @Test
    void testViewBand() throws Exception {
        Band expectedBand = new Band("band1", MusicStyle.JAZZ, "desc");
        when(bandService.findBandById(1L)).thenReturn(expectedBand);
        mockMvc.perform(get("/band/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(model().attribute("bandObject", expectedBand));
    }

    /*@Test
    void testViewBandError() throws Exception {
        mockMvc.perform(get("/band/{id}", 1000000000L))
                .andExpect(status().isNotFound());
    }*/

}
