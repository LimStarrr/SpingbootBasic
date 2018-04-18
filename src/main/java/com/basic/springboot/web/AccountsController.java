package com.basic.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.basic.springboot.service.AccountsService;
import com.basic.springboot.web.request.AccountPostRequest;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
	
	@Autowired
	AccountsService accountService; 
	
	@PostMapping
	@ResponseBody
	public void postAccounts(@RequestBody AccountPostRequest request) {
		accountService.postAccounts(request);
	}
	
	@GetMapping
	@ResponseBody
	public void getAccounts() { 
		accountService.getAccounts();
	}
}
