package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.model.Location;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.model.enums.OrderStatus;
import com.codecool.adhoc.ticketportal.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.mock.staticmock.AnnotationDrivenStaticEntityMockingControl.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ProductControllerTest {

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
        mockMvc = MockMvcBuilders.standaloneSetup(productController).setSingleView(mockView).build();
    }

    @Test
    void testListEvents() throws Exception {
        List<Event> expectedEvents = Arrays.asList(
                new Event("event1", new Location(), "2020-10-10-10:10", "desc"),
                new Event("event2", new Location(), "2019-01-01-01:01", "desc"));
        when(eventService.findUpcomingEvents()).thenReturn(expectedEvents);
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("events", expectedEvents));
    }

    /*@Test
    void testGetAllSuccess() throws Exception {
        List<Band> bands = Arrays.asList(
                new Band("band1", MusicStyle.JAZZ, "band1 desc"),
                new Band("band2", MusicStyle.JAZZ, "band2 desc")
        );
        when(bandService.findAllBand()).thenReturn(bands);
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
        verify();
        verifyNoMoreInteractions(bandService);
    }*/

}
