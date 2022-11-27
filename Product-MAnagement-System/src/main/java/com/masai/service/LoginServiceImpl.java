package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.LoginException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.LoginDTO;
import com.masai.repository.CustomerRepository;
import com.masai.repository.SessionRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class LoginServiceImpl implements LoginService {
     
	@Autowired
	private CustomerRepository cRepo;
	
	@Autowired
	private SessionRepository sRepo;

	@Override
	public String logIntoAccount(LoginDTO ldo) throws LoginException {
		
		Customer existCustomer = cRepo.findByUsername(ldo.getUsername());
		
		if(existCustomer ==null) {
			throw new LoginException("Please Enter a Valid Username");
		}
		
		Optional<CurrentUserSession> validateCustomerSessionOpt = sRepo.findById(existCustomer.getCustomerId());
		
		if(validateCustomerSessionOpt.isPresent()) {
			throw new LoginException("user is already login with this username:" + existCustomer.getUsername());
		}
		if(existCustomer.getPassword().equals(ldo.getPassword())) {
			
			String key = RandomString.make(5);
			
			CurrentUserSession currentUserSession = new CurrentUserSession(existCustomer.getCustomerId(),key,LocalDateTime.now());
			
			sRepo.save(currentUserSession);
			
			return "Login is successfully and your unique login key is : " + currentUserSession.getUuid();
		}
		else
		
		throw new LoginException("Please Enter a vaild password");
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
	
		CurrentUserSession validCustomerSession = sRepo.findByUuid(key);
		if(validCustomerSession ==null) {
			throw new LoginException("user not Logged in with this key");
		}
		sRepo.delete(validCustomerSession);
		
		return "Logged out";
	}
	
	
}
