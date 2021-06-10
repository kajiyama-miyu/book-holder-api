package com.example.serivice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Users;
import com.example.repository.UsersRepository;

@Service
@Transactional
public class UsersService {

	
	@Autowired
	private UsersRepository usersRepository;
	
	
	public void insertUserData (Users users) {
		usersRepository.save(users);
	}
	
	public Users findByEmail (String email) {
		List<Users> usersList = usersRepository.findByEmail(email);
		if(usersList.isEmpty()) {
			return null;
		}
		return usersList.get(0);
	}
	
	public Users findByEmailAndPassword(String email, String password) {
		List<Users> usersList = usersRepository.findByEmailAndPassword(email, password);
		
		if(usersList.isEmpty()) {
			return null;
		}
		
		return usersList.get(0);
	}
	
	public void updateAuth (String auth, String email) {
		usersRepository.updateAuth(auth, email);
	}
	
	
}
