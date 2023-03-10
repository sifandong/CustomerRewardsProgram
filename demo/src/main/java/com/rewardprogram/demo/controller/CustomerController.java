package com.rewardprogram.demo.controller;


import com.rewardprogram.demo.domain.Customer;
import com.rewardprogram.demo.domain.dto.CustomerDTO;
import com.rewardprogram.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public ResponseEntity<Integer> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return new ResponseEntity<>(customerService.createCustomer(customerDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomerById(@PathVariable int id) {
        customerService.deleteCustomerById(id);
    }

    @GetMapping("/customers/rewards")
    public ResponseEntity<Integer> getCustomerRewardsBetweenDates(@RequestParam int id,
                                              @RequestParam Date startDate,
                                              @RequestParam Date endDate) {
        return new ResponseEntity<>(customerService.getRewardsBetweenStartDateAndEndDate(id,startDate,endDate), HttpStatus.OK);
    }
}
