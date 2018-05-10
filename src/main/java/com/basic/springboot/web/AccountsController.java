package com.basic.springboot.web;

import com.basic.springboot.web.response.AccountsResponse;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.basic.springboot.service.AccountsService;
import com.basic.springboot.web.request.AccountPostRequest;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/accounts")
public class AccountsController {
	
	@Autowired
	AccountsService accountsService;

//	@ApiOperation(value = "postAccounts")
	@PostMapping
	@ResponseBody
	public void postAccounts(@RequestBody AccountPostRequest request) {
		accountsService.postAccounts(request);
	}

	@ApiOperation(value = "getAccounts")
	@GetMapping
	@ResponseBody
	public void getAccounts(@ApiIgnore HttpSession session) {
		session.setAttribute("userId","12345");
		session.getAttribute("userId");
		accountsService.getAccounts();
	}

//	@ApiOperation(value = "getAllAccounts")
	@GetMapping("/all")
	@ResponseBody
	public List<AccountsResponse> getAllAccounts() {

		List<AccountsResponse> accountsResponses = new ArrayList<>();

		accountsService.getAllAccounts().forEach(user -> {
			accountsResponses.add(AccountsResponse.valueOf(user));
		});

        System.out.println("getAllAccounts forEach end : " + LocalDateTime.now());

        return accountsResponses;
	}
}
