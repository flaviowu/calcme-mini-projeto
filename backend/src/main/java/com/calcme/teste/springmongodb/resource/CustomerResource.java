package com.calcme.teste.springmongodb.resource;

import com.calcme.teste.springmongodb.domain.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerResource {

    @GetMapping
    public ResponseEntity<List<Customer>> findAll() {
        Customer jj = new Customer("1", "John Jones", "11923457899","john@gmail.com");
        Customer op = new Customer("2", "Ota Pones", "31945678872", "opones@gmail.com");
        List<Customer> list = new ArrayList<>();
        list.addAll(Arrays.asList(jj, op));
        return ResponseEntity.ok().body(list);
    }
}
