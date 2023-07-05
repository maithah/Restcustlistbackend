package com.example.Restcustlistbackend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "customer")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String fullname;
    private String address;
    private String email;
    private int phone;
    private String gender;
    private int age;
    private int tableno;
    private int totalcost;
    
}
