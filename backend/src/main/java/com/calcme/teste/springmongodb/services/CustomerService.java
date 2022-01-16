package com.calcme.teste.springmongodb.services;

import com.calcme.teste.springmongodb.domain.Customer;
import com.calcme.teste.springmongodb.dto.CustomerDTO;
import com.calcme.teste.springmongodb.repository.CustomerRepository;
import com.calcme.teste.springmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public List<Customer> findAll(){

        return repo.findAll();
    }

    public Customer findById(String id) {
        Optional<Customer> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado"));
    }

    public Customer insert(Customer obj) {
        return repo.insert(obj);
    }

    public Customer fromDTO(CustomerDTO objDto) {
        return new Customer(objDto.getId(), objDto.getName(), objDto.getPhoneNumber(), objDto.getEmail() );
    }

}
