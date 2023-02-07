package com.rewardprogram.demo.controller;


import com.rewardprogram.demo.domain.Customer;
import com.rewardprogram.demo.domain.dto.CustomerDTO;
import com.rewardprogram.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return new ResponseEntity(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable int id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public void createCustomer(@RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomerById(@PathVariable int id) {
        customerService.deleteCustomerById(id);
    }

    @GetMapping("/customers/rewards")
    public int getCustomerRewardsBetweenDates(@RequestParam int id,
                                              @RequestParam String startDate,
                                              @RequestParam String endDate) {
        return customerService.getRewardsBetweenStartDateAndEndDate(id,startDate,endDate);
    }
}
