package com.ivosam.payroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ivosam.payroll.entities.Payment;
import com.ivosam.payroll.entities.Worker;

@Service
public class PaymentService {
	
	@Value("${hr-worker.host}")
	private String workerHost;
	
	final RestTemplate template;
	
	public PaymentService(RestTemplate template) {
		this.template = template;
	}
	
	
	public Payment getPayment(long workerId, int days) {
		
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));
		
		Worker worker = template.getForObject(workerHost+ "/workers/{id}", Worker.class, uriVariables);;
		return new Payment(worker.getName(), worker.getDailyIncome(), days); 
		
	}

}
