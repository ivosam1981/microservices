package com.ivosam.payroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivosam.payroll.entities.Payment;
import com.ivosam.payroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value="/payments")
public class PaymentResource {
	
	
	final PaymentService service;
	
	public PaymentResource(PaymentService service) {
		this.service = service;
	}
	
	
	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping(value="/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId, @PathVariable Integer days){
		Payment payment = service.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
	public ResponseEntity<Payment> getPaymentAlternative(Long workerId, Integer days){
		Payment payment = new Payment("Brann", 200.0, days);
		return ResponseEntity.ok(payment);
	}

	

}
