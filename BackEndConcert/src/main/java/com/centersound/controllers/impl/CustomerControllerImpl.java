package com.centersound.controllers.impl;

import com.centersound.controllers.CustomerControllerInterface;
import com.centersound.dtos.CustomerDto;
import com.centersound.entities.Customer;
import com.centersound.exceptions.CustomerWithEmailAlreadyExists;
import com.centersound.services.CustomerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControllerImpl implements CustomerControllerInterface {
    @Autowired
    CustomerServiceInterface customerServiceInterface;
    @Override
    public CustomerDto getLoggedCustomerInfo(Long customerId) {
        return customerServiceInterface.getLoggedCustomerInfo(customerId);
    }

    @Override
    public CustomerDto registerCustomer(Customer customer) throws CustomerWithEmailAlreadyExists {
        return customerServiceInterface.registerNewCustomer(customer);

    }
}
