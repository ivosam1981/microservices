package com.ivosam.hruser.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ivosam.hruser.entities.User;
import com.ivosam.hruser.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	final UserService service;

	public UserResource(UserService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok(obj);
		
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		User obj = service.findByEmail(email);
		return ResponseEntity.ok(obj);
		
	}
	
	
	
	
	

}
