package com.example.Restcustlistbackend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Restcustlistbackend.entity.Customer;
import com.example.Restcustlistbackend.repository.CustomerRepository;

import lombok.Data;

@Data
@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> getCustomerByName(String fullname){
        List<Customer> c = customerRepo.getCustomerForNames(fullname);
        if(c.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer was not found");
        }else{
            return c;
        }
    }

    public Customer addCustomer(Customer s){
        return customerRepo.save(s);
    }

    public List<Customer> getAll(){
        return customerRepo.findAll();
    }

    public Optional<Customer> findById(Integer custId){
        return customerRepo.findById(custId);
    }

    public void deleteById(Integer custId){
        customerRepo.deleteById(custId);
    }

}
