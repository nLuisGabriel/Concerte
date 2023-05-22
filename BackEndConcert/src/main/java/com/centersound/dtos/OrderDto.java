package com.centersound.dtos;

import com.centersound.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDto {
    private Long id;
    private ConcertDto concertDto;
    private CustomerDto customerDto;
    private LocalDateTime registeredAt;
    private OrderStatus orderStatus;
    private Long tickets;
    private BigDecimal total;

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Long getTickets() {
        return tickets;
    }

    public void setTickets(Long tickets) {
        this.tickets = tickets;
    }

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
