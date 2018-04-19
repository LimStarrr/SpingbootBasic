package com.basic.springboot.web;

import com.basic.springboot.domain.User;
import com.basic.springboot.web.response.AccountsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.basic.springboot.service.AccountsService;
import com.basic.springboot.web.request.AccountPostRequest;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountsController {
	
	@Autowired
	AccountsService accountsService;
	
	@PostMapping
	@ResponseBody
	public void postAccounts(@RequestBody AccountPostRequest request) {
		accountsService.postAccounts(request);
	}
	
	@GetMapping
	@ResponseBody
	public void getAccounts() {
		accountsService.getAccounts();
	}

	@GetMapping("/all")
	@ResponseBody
	public List<AccountsResponse> getAllAccounts() {

		List<AccountsResponse> accountsResponses = new ArrayList<>();

		accountsService.getAllAccounts().forEach(user -> {
			accountsResponses.add(AccountsResponse.valueOf(user));
		});

		return accountsResponses;
	}
}
