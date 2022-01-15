package com.calcme.teste.springmongodb.dto;

import com.calcme.teste.springmongodb.domain.Customer;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;

    public CustomerDTO() {

    }

    public CustomerDTO(Customer obj) {
        id = obj.getId();
        name = obj.getName();
        phoneNumber = obj.getPhoneNumber();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
