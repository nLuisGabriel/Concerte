package com.centersound.controllers;

import com.centersound.dtos.OrderDto;
import com.centersound.exceptions.ToManyTicketsException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "orders")
public interface OrderControllerInterface {
    @GetMapping(value = "/getAll/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    List<OrderDto> ordersByCustomerId(@PathVariable Long customerId);
    @PostMapping(value = "/buy/{customerId}/{concertId}/{quantity}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDto buyConcertTicket(@PathVariable Long customerId, @PathVariable Long concertId, @PathVariable Long quantity) throws ToManyTicketsException;

    @PutMapping(value = "/cancelOrder/{orderID}", produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDto cancelConcertTicket(@PathVariable Long orderID);
}
