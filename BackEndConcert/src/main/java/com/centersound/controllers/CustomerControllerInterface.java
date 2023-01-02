package com.centersound.controllers;

import com.centersound.dtos.CustomerDto;
import com.centersound.entities.Customer;
import com.centersound.exceptions.CustomerWithEmailAlreadyExists;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "customer")
public interface CustomerControllerInterface {
   @GetMapping(value = "/details/{email}", produces = MediaType.APPLICATION_JSON_VALUE )
    CustomerDto getLoggedCustomerInfo(@PathVariable String email);
   @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDto registerCustomer(@Valid @RequestBody Customer customer) throws CustomerWithEmailAlreadyExists;
}
