package com.basic.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.basic.springboot.domain.User;
import com.basic.springboot.exception.CustomException;
import com.basic.springboot.repository.AccountRepository;
import com.basic.springboot.service.AccountsService;
import com.basic.springboot.web.request.AccountPostRequest;

@Service
public class AccountServiceImpl implements AccountsService {

	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public void postAccounts(AccountPostRequest request) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setPhone(request.getPhone());
		
		try {
			accountRepository.save(user);
		} catch(IllegalArgumentException e ) {
			throw new CustomException(HttpStatus.NO_CONTENT);
		}
		
		new CustomException(HttpStatus.BAD_REQUEST);
	}

	@Override
	public void getAccounts() {
		// TODO Auto-generated method stub
		throw new CustomException(HttpStatus.NO_CONTENT);	
	}

}
