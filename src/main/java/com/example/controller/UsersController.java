package com.example.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Users;
import com.example.serivice.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	private static int TOKEN_LENGTH = 16;
	
	@PostMapping("/signUp")
	@ResponseStatus(HttpStatus.CREATED)
	public void insertUser(@RequestBody Users users) {
		
		Users user = usersService.findByEmail(users.getEmail());
		
		if(user == null) {
			usersService.insertUserData(users);
		}
	}

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.CREATED)
	public String login(@RequestBody Users users) {
		Users user = usersService.findByEmailAndPassword(users.getEmail(), users.getPassword());
		byte token[] = new byte[TOKEN_LENGTH];
		StringBuffer buf = new StringBuffer();
		SecureRandom randm = null;
		
		
		if(user == null) {
			return null;
		} else {
			if(user.getAuth() != null) {
				return user.getAuth();
			} else {
				try {
					randm = SecureRandom.getInstance("SHA1PRNG");
					randm.nextBytes(token);
					
					for(int i = 0; i < token.length; i ++) {
						buf.append(String.format("%02x", token[i]));
					}
				} catch (NoSuchAlgorithmException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				usersService.updateAuth(buf.toString(), users.getEmail());
				return buf.toString();
			}
		}
	}
}
