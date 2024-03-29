package com.centersound.services.impl;

import com.centersound.dtos.CustomerDto;
import com.centersound.entities.Customer;
import com.centersound.exceptions.CustomerWithEmailAlreadyExists;
import com.centersound.repositories.CustomerRepository;
import com.centersound.services.CustomerServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerServiceInterface {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    PasswordEncoder passwordEncoder;



    @Override
    public CustomerDto getLoggedCustomerInfo(String email) {
        Optional<Customer> customer = customerRepository.findByEmail(email);
        if(Boolean.TRUE.equals(customer.isPresent())){
            CustomerDto customerDto = modelMapper.map(customer.get(), CustomerDto.class);
            return customerDto;
        }
        return null;
    }

    @Override
    public CustomerDto registerNewCustomer(Customer customer) throws CustomerWithEmailAlreadyExists {
        String email = customer.getEmail();
        boolean customerAlreadyExists = customerRepository.existsByEmail(email);
        if(Boolean.TRUE.equals(customerAlreadyExists)){
            throw new CustomerWithEmailAlreadyExists(email);
        }
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer customerSaved = customerRepository.save(customer);
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }
}
