package com.centersound.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends User{
    @Column(name = "name", nullable = false)
    String name;
    @Min(value = 4, message = "must be equal or greater than 4")
    @Column(name = "age", nullable = false)
    Integer age;
    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @OneToMany(mappedBy = "customer")
    Set<Order> orders;

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
