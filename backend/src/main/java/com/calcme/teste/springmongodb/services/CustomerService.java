package com.calcme.teste.springmongodb.services;

import com.calcme.teste.springmongodb.domain.Customer;
import com.calcme.teste.springmongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> findAll(){
        return repo.findAll();
    }

}
