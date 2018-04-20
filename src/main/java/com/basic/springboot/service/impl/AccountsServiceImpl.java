package com.basic.springboot.service.impl;

import com.basic.springboot.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.basic.springboot.domain.User;
import com.basic.springboot.exception.CustomException;
import com.basic.springboot.repository.AccountRepository;
import com.basic.springboot.service.AccountsService;
import com.basic.springboot.web.request.AccountPostRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CityMapper cityMapper;

	@Autowired
	RestTemplate restTemplate;

	@Override
	@Transactional
	public void postAccounts(AccountPostRequest request) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setPhone(request.getPhone());
		
		try {
			accountRepository.save(user);
		} catch(IllegalArgumentException e ) {
            throw new CustomException(HttpStatus.NO_CONTENT);
		}
	}

	@Override
	public List<User> getAllAccounts() {
		// TODO Auto-generated method stub
		System.out.println("getAllAccounts start : " + LocalDateTime.now());
		List<User> users = accountRepository.findAll();

		if(users.size() <= 0 || users == null)
		    throw new CustomException(HttpStatus.NO_CONTENT);

		System.out.println("getAllAccounts end : " + LocalDateTime.now());

		return users;
//		restTemplate.getForObject()
//		cityMapper.findbyState("");

	}

	@Override
	public void getAccounts() {

	}



}
