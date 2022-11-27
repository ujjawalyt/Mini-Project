package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerNotFound;
import com.masai.exceptions.InvalidId;
import com.masai.model.Customer;



public interface CustomerService {

	public Customer insertCustomer(Customer customer)throws CustomerNotFound;
	public Customer updateCustomer(Customer customer, Integer id) throws CustomerNotFound ;
	public Customer deleteCustomer(Integer customerId) throws CustomerNotFound,InvalidId;
    public Customer viewCustomerById(Integer customerId) throws InvalidId, CustomerNotFound;


	
}
