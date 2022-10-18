package com.ivosam.payroll.services;

import org.springframework.stereotype.Service;

import com.ivosam.payroll.entities.Payment;

@Service
public class PaymentService {
	
	public Payment getPayment(long id, int days) {
		return new Payment("Bob", 200.0, days); 
		
	}

}
