package com.tts.week9day2.controller;


import com.tts.week9day2.model.Customer;
import com.tts.week9day2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
public class MainController {


    @Autowired
    CustomerRepository customerRepository;

//    @GetMapping("/")
//    public String getHome(){
//        return "Hello World";
//    }

    @GetMapping("/random")
    public Integer getRandomInteger(){
        Random random = new Random();
        return random.nextInt(999);
    }

    @GetMapping("/customer/all")
    public List<Customer> getAllCustomers(){
        return (List<Customer>) customerRepository.findAll();
    }


    //This mapping has dynamic element
    //the dynamic element is the "path variable"
    //while it is bound to a parameter, the literal value
    //is completely dynamic
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).orElseThrow();
    }



}
