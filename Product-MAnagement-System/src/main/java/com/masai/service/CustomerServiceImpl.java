package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.CustomerNotFound;
import com.masai.exceptions.InvalidId;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
      @Autowired
	 CustomerRepository customerRepo;
      
	
	@Override
	public Customer insertCustomer(Customer customer) throws CustomerNotFound {
	   Customer c = customerRepo.findByUsername(customer.getUsername());
	   
	   if(c==null) {
		   return customerRepo.save(customer);
	   }
		 throw new CustomerNotFound("Customer already exists with this username " + customer.getUsername());
		
		
	}

	@Override
	public Customer updateCustomer(Customer customer, Integer id) throws CustomerNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer deleteCustomer(Integer customerId) throws CustomerNotFound, InvalidId {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomerById(Integer customerId) throws InvalidId, CustomerNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	
}
