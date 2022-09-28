package com.shopping.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.exception.LoginException;
import com.shopping.module.LoginData;
import com.shopping.service.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
public class LoginController {
    @Autowired
	private LoginService loginservice;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginData logindata) throws LoginException{
		
		String loginMessage = loginservice.logInAccount(logindata);
		
		return new ResponseEntity<>(loginMessage, HttpStatus.OK);
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logout(@RequestParam String key) throws LoginException{
		
		String logoutMessage = loginservice.logOutFromAccount(key);
		
		
		return new ResponseEntity<>(logoutMessage, HttpStatus.OK);
	}
	
}
