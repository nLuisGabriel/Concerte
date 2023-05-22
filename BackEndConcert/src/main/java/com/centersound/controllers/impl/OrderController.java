package com.centersound.controllers.impl;

import com.centersound.controllers.OrderControllerInterface;
import com.centersound.dtos.OrderDto;


import com.centersound.exceptions.ToManyTicketsException;
import com.centersound.services.OrderServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrderControllerInterface {
    @Autowired
    OrderServiceInterface orderServiceInterface;
    @Override
    public List<OrderDto> ordersByCustomerId(Long customerId) {
        return orderServiceInterface.findAllOrdersByCustomerID(customerId);
    }

    @Override
    public OrderDto buyConcertTicket(Long customerId, Long concertId, Long quantity) throws ToManyTicketsException {
        return orderServiceInterface.buyConcertTicket(customerId, concertId, quantity);
    }

    @Override
    public OrderDto cancelConcertTicket(Long orderID) {
       return  orderServiceInterface.cancelOrder(orderID);
    }
}
