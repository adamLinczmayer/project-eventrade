package com.codecool.adhoc.ticketportal.controller;

import com.codecool.adhoc.ticketportal.model.Band;
import com.codecool.adhoc.ticketportal.model.enums.MusicStyle;
import com.codecool.adhoc.ticketportal.services.BandService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class ProductControllerTesttttt {

    private MockMvc mockMvc;

    @InjectMocks
    private ProductController productController = new ProductController();

    /*@BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }*/

    @Test
    public void testHome() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void testEventPage() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        mockMvc.perform(get("/event/{id}", 1)).andExpect(status().isOk());
    }




/*    @Mock
    private BandService bandService;

    @InjectMocks
    private ProductController productController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {

        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();

    }*/

/*    private Band band;
    @Autowired
    private ProductController productController;
    @Autowired
    private BandService bandService;

    @Configuration
    static class ProductControllerTestConfiguration {
        @Bean
        public BandService bandService() {
            return Mockito.mock(BandService.class);
        }

        @Bean
        public ProductController loginController() {
            return new ProductController();
        }
    }

    @BeforeEach
    public void setup() throws Exception {
        this.band = new Band("name", MusicStyle.JAZZ, "description");


        Mockito.when(this.accountService.login("john", "secret")).thenReturn(this.band);
    }*/
}