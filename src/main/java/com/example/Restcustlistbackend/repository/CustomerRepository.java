package com.example.Restcustlistbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Restcustlistbackend.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "SELECT * from customerlist where fullname =?1", nativeQuery = true)
    List<Customer> getCustomerForNames(String fullname);
}
