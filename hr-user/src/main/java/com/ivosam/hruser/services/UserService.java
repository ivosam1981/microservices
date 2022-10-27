package com.ivosam.hruser.services;

import org.springframework.stereotype.Service;

import com.ivosam.hruser.entities.User;
import com.ivosam.hruser.repositories.UserRepository;

@Service
public class UserService {

	final UserRepository repository;

	public UserService(UserRepository repository) {
		this.repository = repository;
	}

	public User findById(Long id) {
		User user = repository.findById(id).get();
		return user;
	}

	public User findByEmail(String email) {
		User user = repository.findByEmail(email);
		return user;
	}

}
