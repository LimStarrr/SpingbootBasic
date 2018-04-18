package com.basic.springboot.service;

import org.springframework.stereotype.Component;

import com.basic.springboot.web.request.AccountPostRequest;

@Component
public interface AccountsService {
	public void postAccounts(AccountPostRequest request);
	public void getAccounts();
}
