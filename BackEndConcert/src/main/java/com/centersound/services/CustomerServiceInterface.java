package com.centersound.services;

import com.centersound.dtos.CustomerDto;
import com.centersound.entities.Customer;
import com.centersound.exceptions.CustomerWithEmailAlreadyExists;

public interface CustomerServiceInterface {
    CustomerDto getLoggedCustomerInfo(Long customerId);
    CustomerDto registerNewCustomer(Customer customer) throws CustomerWithEmailAlreadyExists;
}
