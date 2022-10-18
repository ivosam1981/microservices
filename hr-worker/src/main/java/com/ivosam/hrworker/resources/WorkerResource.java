package com.ivosam.hrworker.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivosam.hrworker.entities.Worker;
import com.ivosam.hrworker.services.WorkerService;

@RestController
@RequestMapping(value ="/workers")
public class WorkerResource {
	
	final WorkerService service;

	public WorkerResource(WorkerService service) {
		this.service = service;
	}
	
	@GetMapping
	ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	
	
	
	
}
