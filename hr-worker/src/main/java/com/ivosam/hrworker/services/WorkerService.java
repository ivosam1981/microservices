package com.ivosam.hrworker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ivosam.hrworker.entities.Worker;
import com.ivosam.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {
	
	
	final WorkerRepository repository;

	public WorkerService(WorkerRepository repository) {
		this.repository = repository;
	}

	public List<Worker> findAll(){
		return repository.findAll();
	}
	
	public Worker findById(Long id){
		return repository.findById(id).get();
	}
	
	
	
	
	
	
	

}
