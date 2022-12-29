package com.centersound.services.impl;

import com.centersound.dtos.*;
import com.centersound.entities.Concert;
import com.centersound.entities.Customer;
import com.centersound.entities.Order;
import com.centersound.enums.OrderStatus;
import com.centersound.exceptions.ToManyTicketsException;
import com.centersound.repositories.ConcertRepository;
import com.centersound.repositories.CustomerRepository;
import com.centersound.repositories.OrderRepository;
import com.centersound.services.OrderServiceInterface;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderServiceInterface {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ConcertRepository concertRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<OrderDto> findAllOrdersByCustomerID(Long customerID) {
        return orderRepository.findAllByCustomer(customerID).stream().map(order -> {
            CustomerDto customerDto = modelMapper.map(order.getCustomer(), CustomerDto.class);
            LocationDto locationDto = modelMapper.map(order.getConcert().getLocation(), LocationDto.class);
            MusicalCategoryDto musicalCategoryDto = modelMapper.map(order.getConcert().getCategory(), MusicalCategoryDto.class);
            ConcertDto concertDto = modelMapper.map(order.getConcert(), ConcertDto.class);
            concertDto.setLocationDto(locationDto);
            concertDto.setMusicalCategoryDto(musicalCategoryDto);
            OrderDto orderDto = modelMapper.map(order, OrderDto.class);
            orderDto.setCustomerDto(customerDto);
            orderDto.setConcertDto(concertDto);
            return orderDto;
        }).collect(Collectors.toList());
    }

    @Override
    public OrderDto buyConcertTicket(Long customerId, Long concertId, Long quantity) throws ToManyTicketsException {
        if(quantity>10){
            throw new ToManyTicketsException(quantity);
        }
        Customer customer = customerRepository.findById(customerId).get();
        Concert concert = concertRepository.findById(concertId).get();
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        LocationDto locationDto = modelMapper.map(concert.getLocation(), LocationDto.class);
        MusicalCategoryDto musicalCategoryDto = modelMapper.map(concert.getCategory(), MusicalCategoryDto.class);
        ConcertDto concertDto = modelMapper.map(concert, ConcertDto.class);
        concertDto.setMusicalCategoryDto(musicalCategoryDto);
        concertDto.setLocationDto(locationDto);
        Order order = new Order();
        order.setOrderStatus(OrderStatus.ACCEPTED);
        order.setConcert(concert);
        order.setCustomer(customer);
        order.setTickets(quantity);
        try{
            Order order1 = orderRepository.save(order);
            OrderDto orderDto = modelMapper.map(order1, OrderDto.class);
            orderDto.setCustomerDto(customerDto);
            orderDto.setConcertDto(concertDto);
            return orderDto;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public OrderDto cancelOrder(Long orderID) {
        Optional<Order> order = orderRepository.findById(orderID);
        if(order.isPresent()){
            try {
                Order orderToUpdate = order.get();
                orderToUpdate.setOrderStatus(OrderStatus.CANCELED);
                orderToUpdate = orderRepository.save(orderToUpdate);
                OrderDto orderDto = modelMapper.map(order, OrderDto.class);
                CustomerDto customerDto = modelMapper.map(orderToUpdate.getCustomer(), CustomerDto.class);
                LocationDto locationDto = modelMapper.map(orderToUpdate.getConcert().getLocation(), LocationDto.class);
                MusicalCategoryDto musicalCategoryDto = modelMapper.map(orderToUpdate.getConcert().getCategory(), MusicalCategoryDto.class);
                ConcertDto concertDto = modelMapper.map(orderToUpdate.getConcert(), ConcertDto.class);
                concertDto.setLocationDto(locationDto);
                concertDto.setMusicalCategoryDto(musicalCategoryDto);

                orderDto.setConcertDto(concertDto);
                orderDto.setConcertDto(concertDto);
                orderDto.setCustomerDto(customerDto);

                return orderDto;
            }
            catch (Exception e){
                throw e;
            }
        }
        return null;
    }
}
