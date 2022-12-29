package com.centersound.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends User{
    @Column(name = "name", nullable = false)
    private String name;
    @Min(value = 4, message = "must be equal or greater than 4")
    @Column(name = "age", nullable = false)
    private Integer age;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "registration_date")
    @JsonFormat(pattern = "yyyy-MM-dd hh-mm-ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime localDateTime = LocalDateTime.now();

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
