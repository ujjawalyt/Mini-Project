package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.CustomerNotFound;
import com.masai.model.Customer;
import com.masai.service.CustomerService;

@RestController
public class CustomerController {
       @Autowired
	   CustomerService cuss ;
       
       @PostMapping("/save")
       public ResponseEntity<Customer> insertCustomerHandler(@Valid @RequestBody Customer customer) throws CustomerNotFound{
    	   
    	   Customer cus = cuss.insertCustomer(customer);
    	   
    	   return new ResponseEntity<Customer>(cus,HttpStatus.OK);
       }
	
}
