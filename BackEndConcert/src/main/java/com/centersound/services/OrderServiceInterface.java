package com.centersound.services;

import com.centersound.dtos.OrderDto;
import com.centersound.entities.Order;
import com.centersound.exceptions.ToManyTicketsException;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface OrderServiceInterface {
    List<OrderDto> findAllOrdersByCustomerID(Long customerID);
    OrderDto buyConcertTicket(Long customerId, Long concertId, Long quantity) throws ToManyTicketsException;
    OrderDto cancelOrder(Long orderID);
}
