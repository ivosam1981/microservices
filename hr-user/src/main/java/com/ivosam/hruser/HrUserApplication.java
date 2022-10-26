package com.ivosam.hruser;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner{
	
	final BCryptPasswordEncoder passwordEncoder;
	
	public HrUserApplication(BCryptPasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("BRCRYPT = " + passwordEncoder.encode("123456"));
		
	}

}
