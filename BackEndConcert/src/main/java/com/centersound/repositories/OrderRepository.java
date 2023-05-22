package com.centersound.repositories;

import com.centersound.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select * from orders\n " +
            "where customer_id = :customerID", nativeQuery = true)
    List<Order> findAllByCustomer(@Param("customerID")Long customerID);


}