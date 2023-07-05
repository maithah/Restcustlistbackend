package com.example.Restcustlistbackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restcustlistbackend.entity.Customer;
import com.example.Restcustlistbackend.services.CustomerServices;



@CrossOrigin
@RestController
@RequestMapping("api/customer")
public class CustomerController {
    @Autowired
    private CustomerServices customerServices;

    @GetMapping("/getCustomerByName/{fullname}")
    public List<Customer> getCustomerByName(@PathVariable("fullname") String fullname){
        List<Customer> c = customerServices.getCustomerByName(fullname);
        return c;
    }

    @PostMapping("/")
    public Customer addCustomer(@RequestBody Customer s){
        return customerServices.addCustomer(s);
    }

    @GetMapping("/")
    public List<Customer> getAll(){
        return customerServices.getAll();
    }

    @GetMapping("/{custId}")
    public Optional<Customer> getById(@PathVariable Integer custId){
        return customerServices.findById(custId);
    }

    @PutMapping("/{custId}")
    public Customer updateCustomer(@RequestBody Customer s ,@PathVariable Integer custId){
        s.setCustId(custId);
        return customerServices.addCustomer(s);
    }
    
    @DeleteMapping("/{custId}")
    public void deleteMe(@PathVariable Integer custId){
        customerServices.deleteById(custId);
    }
}
