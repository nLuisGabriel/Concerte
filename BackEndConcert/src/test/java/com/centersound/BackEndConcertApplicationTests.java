package com.centersound;

import com.centersound.dtos.ArtistDto;
import com.centersound.dtos.CustomerDto;
import com.centersound.dtos.OrderDto;
import com.centersound.entities.Customer;
import com.centersound.enums.OrderStatus;
import com.centersound.exceptions.CustomerWithEmailAlreadyExists;
import com.centersound.exceptions.ToManyTicketsException;
import com.centersound.repositories.CustomerRepository;
import com.centersound.services.ArtistServiceInterface;
import com.centersound.services.CustomerServiceInterface;
import com.centersound.services.OrderServiceInterface;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ContextConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.MethodName.class)
class BackEndConcertApplicationTests {

    public static final String MAIL_MAIL_COM = "mail@mail.com";
    @Autowired
    CustomerServiceInterface customerServiceInterface;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    OrderServiceInterface orderServiceInterface;

    @Test
    void t1_createCustomer() throws CustomerWithEmailAlreadyExists {
        Customer customer = new Customer();
        customer.setPassword(passwordEncoder.encode("TestPassword1!"));
        customer.setName("NameTest");
        customer.setPhoneNumber("0760-252-777");
        customer.setEmail(MAIL_MAIL_COM);
        customer.setAge(23);
        CustomerDto customerDto = customerServiceInterface.registerNewCustomer(customer);
        Assertions.assertNotNull(customerDto);
        Assertions.assertNotNull(customerDto.getId());
    }
    @Test
    void t2_getLoggedCustomerInfo(){
        Optional<Customer> customer = customerRepository.findByEmail(MAIL_MAIL_COM);
        if(customer.isPresent()){
            CustomerDto customerDto = customerServiceInterface.getLoggedCustomerInfo(customer.get().getId());
            Assertions.assertNotNull(customerDto);
            Assertions.assertNotNull(customerDto.getId());
        }
        else{
            Assertions.fail("No customer found!");
        }
    }

    @Test
    void t3_buyConcertTicket() throws ToManyTicketsException {
        Optional<Customer> customer = customerRepository.findByEmail(MAIL_MAIL_COM);
        if(customer.isPresent()){
            OrderDto orderDto = orderServiceInterface.buyConcertTicket(customer.get().getId(), 1L,8L);
            Assertions.assertNotNull(orderDto);
            Assertions.assertEquals(orderDto.getTickets(),8L);
        }
    }
    @Test
    void t4_findAllOrderByCustomer(){
        Optional<Customer> customer = customerRepository.findByEmail(MAIL_MAIL_COM);
        if(customer.isPresent()){
            List<OrderDto> orderDtos = orderServiceInterface.findAllOrdersByCustomerID(customer.get().getId());
            Assertions.assertEquals(orderDtos.size(),1);
        }
    }
    @Test
    void t5_cancelOrder(){
        Optional<Customer> customer = customerRepository.findByEmail(MAIL_MAIL_COM);
        if(customer.isPresent()){
            List<OrderDto> orderDtos = orderServiceInterface.findAllOrdersByCustomerID(customer.get().getId());
            OrderDto order = orderServiceInterface.cancelOrder(orderDtos.get(0).getId());
            Assertions.assertEquals(order.getOrderStatus(), OrderStatus.CANCELED);
        }
        // remove
        customerRepository.deleteById(customer.get().getId());
    }

}
