package com.ivosam.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ivosam.hroauth.entities.User;
import com.ivosam.hroauth.feignclients.UserFeignClients;

@Service
public class UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	final UserFeignClients userFeignClients;

	public UserService(UserFeignClients userFeignClients) {
		this.userFeignClients = userFeignClients;
	}
	
	public User findByEmail(String email) {
		User user = userFeignClients.findByEmail(email).getBody();
		
		if(user == null) {
			logger.error("Email não exite: " + email);
			throw new IllegalArgumentException("Email não encontrado");
		}
		logger.info("Email encontrado " + email);
		return user;
		
	}
	
	

}
