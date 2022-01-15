package com.calcme.teste.springmongodb.config;

import com.calcme.teste.springmongodb.domain.Customer;
import com.calcme.teste.springmongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

        customerRepository.deleteAll();

        Customer obi = new Customer(null, "Obi Wan Kenoby", "21976896700", "obi@tatooine.com");
        Customer luke = new Customer(null, "Luke Skywalker", "21900992211", "luke@tatooine.com");
        Customer han = new Customer(null, "Han Solo", "21976896703", "solohan@milleniumfalcon.com");

        customerRepository.saveAll(Arrays.asList(obi, luke, han));
    }
}
