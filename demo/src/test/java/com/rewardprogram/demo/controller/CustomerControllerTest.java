package com.rewardprogram.demo.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@WebMvcTest
public class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getAllCustomers() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/customers")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}