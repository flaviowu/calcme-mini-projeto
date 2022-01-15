package com.calcme.teste.springmongodb.resource;

import com.calcme.teste.springmongodb.domain.Customer;
import com.calcme.teste.springmongodb.dto.CustomerDTO;
import com.calcme.teste.springmongodb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/customers")
public class CustomerResource {

    @Autowired
    private CustomerService service;

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> findAll() {
        List<Customer> list = service.findAll();
        List<CustomerDTO> listDto = list.stream().map( x -> new CustomerDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }
}
