package com.basic.springboot.service;

import com.basic.springboot.domain.User;
import org.springframework.stereotype.Component;

import com.basic.springboot.web.request.AccountPostRequest;

import java.util.List;

@Component
public interface AccountsService {
	void postAccounts(AccountPostRequest request);
	List<User> getAllAccounts();
	void getAccounts();
}
