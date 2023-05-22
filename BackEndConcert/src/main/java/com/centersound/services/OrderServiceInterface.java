package com.centersound.services;

import com.centersound.dtos.OrderDto;
import com.centersound.exceptions.ToManyTicketsException;

import java.util.List;

public interface OrderServiceInterface {
    List<OrderDto> findAllOrdersByCustomerID(Long customerID);
    OrderDto buyConcertTicket(Long customerId, Long concertId, Long quantity) throws ToManyTicketsException;
    OrderDto cancelOrder(Long orderID);
}
