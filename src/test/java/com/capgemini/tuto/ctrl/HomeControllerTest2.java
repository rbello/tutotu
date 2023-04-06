package com.capgemini.tuto.ctrl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(HomeController.class)
public class HomeControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidRoute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(content().contentType("text/plain;charset=UTF-8"));
    }

    @Test
    public void testInvalidRoute() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/obj/123"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()));
    }

}
