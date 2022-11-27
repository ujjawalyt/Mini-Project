package com.masai.service;

import com.masai.exceptions.LoginException;
import com.masai.model.LoginDTO;

public interface LoginService {

	public String logIntoAccount(LoginDTO ldo) throws LoginException;

	public String logOutFromAccount(String key) throws LoginException;
}
