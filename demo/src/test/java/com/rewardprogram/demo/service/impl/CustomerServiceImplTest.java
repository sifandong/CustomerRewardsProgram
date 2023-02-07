package com.rewardprogram.demo.service.impl;

import com.rewardprogram.demo.controller.CustomerController;
import com.rewardprogram.demo.domain.Customer;
import com.rewardprogram.demo.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerServiceImplTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;
    private Customer customer;
    @Before
    public void setUp() {
        customer = new Customer();
        customer.setId(1);
        customer.setName("John");
    }
    @Test
    public void getCustomerById() throws Exception{

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id", is(1)))
                .andExpect(jsonPath("username", is("John")));

    }

}