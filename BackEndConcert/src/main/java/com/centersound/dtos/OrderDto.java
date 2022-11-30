package com.centersound.dtos;

import com.centersound.enums.OrderStatus;

import java.time.LocalDateTime;

public class OrderDto {
    private Long id;
    private ConcertDto concertDto;
    private CustomerDto customerDto;
    private LocalDateTime registeredAt;
    private OrderStatus orderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConcertDto getConcertDto() {
        return concertDto;
    }

    public void setConcertDto(ConcertDto concertDto) {
        this.concertDto = concertDto;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
