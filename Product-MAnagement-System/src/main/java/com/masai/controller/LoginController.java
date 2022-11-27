package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDTO;
import com.masai.service.LoginServiceImpl;

@RestController
public class LoginController {

	@Autowired
	private LoginServiceImpl loginImpl;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginHandler(@RequestBody LoginDTO logindto) throws LoginException{
		
		String login = loginImpl.logIntoAccount(logindto);
		
		return new  ResponseEntity<String>(login,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/logout/{key}")
	public ResponseEntity<String>logOutHandler(@PathVariable("key") String key) throws LoginException{
		
		String logout = loginImpl.logOutFromAccount(key);
		
		return new ResponseEntity<String>(logout,HttpStatus.OK);
	}
	
}
