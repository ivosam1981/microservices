package com.ivosam.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ivosam.hroauth.entities.User;
import com.ivosam.hroauth.feignclients.UserFeignClients;

@Service
public class UserService implements UserDetailsService{
	
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClients.findByEmail(username).getBody();
		if (user == null) {
			logger.error("Email not found: " + username);
			throw new UsernameNotFoundException("Email not found");
		}
		logger.info("Email found: " + username);
		return user;
	}
	
	

}
