package com.ivosam.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
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
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	final Environment env;
	final WorkerService service;

	public WorkerResource(WorkerService service, Environment env) {
		this.service = service;
		this.env = env;
	}
	
	@GetMapping
	ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/{id}")
	ResponseEntity<Worker> findById(@PathVariable Long id){
		
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	
	
	
	
}
