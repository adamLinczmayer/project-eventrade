package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.Event;
import com.codecool.adhoc.ticketportal.model.Location;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.services.*;
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
import java.util.List;

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
        event1 = new Event("event1", new Location(), "2020-10-10-10:10", "desc");
        event2 = new Event("event2", new Location(), "2019-01-01-01:01", "desc");
        location1 = new Location("location1", "address", 500);
        location2 = new Location("location2", "address", 1200);
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
        MusicStyle[] expectedMusicStyles = {MusicStyle.FOLK, MusicStyle.SOUL};
        when(bandService.findAllBand()).thenReturn(expectedBands);
        // when(locationService.findAll()).thenReturn(expectedLocations);
        when(MusicStyle.values()).thenReturn(expectedMusicStyles);
        mockMvc.perform(get("/addevent", 1))
                .andExpect(status().isOk())
                .andExpect(model().attribute("allBand", expectedBands))
                .andExpect(model().attribute("locations", expectedLocations))
                .andExpect(model().attribute("musicStyles", expectedMusicStyles));
    }

    @Test
    void testSaveEvent() throws Exception {
        Event addedEvent = event2;
        when(eventService.saveEvent(isA(Event.class))).thenReturn(addedEvent);
        mockMvc.perform(post("/save-event")
                .param("event-name", "event2")
                .param("location", "?")
                .param("event-date", "2019-01-01")
                .param("event-time", "01:01")
                .param("event-description", "desc"))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/"));
        ArgumentCaptor<Event> formObjectArgument = ArgumentCaptor.forClass(Event.class);
        verify(eventService, times(1)).saveEvent(formObjectArgument.capture());
        verifyNoMoreInteractions(eventService);
    }

    @Test
    void testSaveBand() throws Exception {
        Band addedBand = band2;
        when(bandService.saveBand(isA(Band.class))).thenReturn(addedBand);
        mockMvc.perform(post("/add-band")
                .param("name", "band2")
                .param("musicStyle", "latin")
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
