package com.ivosam.payroll.services;

import org.springframework.stereotype.Service;

import com.ivosam.payroll.entities.Payment;
import com.ivosam.payroll.entities.Worker;
import com.ivosam.payroll.feignclients.WorkerFeignClient;	

@Service
public class PaymentService {
	
	final WorkerFeignClient workerFeignClient;
	
	public PaymentService(WorkerFeignClient workerFeignClient) {
		this.workerFeignClient = workerFeignClient;
	}
	
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days); 
		
	}

}
