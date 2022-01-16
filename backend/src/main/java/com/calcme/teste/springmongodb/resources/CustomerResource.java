package com.calcme.teste.springmongodb.resources;

import com.calcme.teste.springmongodb.domain.Customer;
import com.calcme.teste.springmongodb.dto.CustomerDTO;
import com.calcme.teste.springmongodb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.Servlet;
import java.net.URI;
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

    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable String id) {
        Customer obj = service.findById(id);
        return ResponseEntity.ok().body(new CustomerDTO(obj));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerDTO objDto) {
        Customer obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
