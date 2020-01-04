package com.jarvis.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.dto.BatchExecution;
import com.jarvis.repository.CustomRepository;

@RestController
public class StatApi {

	@Autowired
	CustomRepository customRepository;
	
	@GetMapping("/batch_status")
	public List<BatchExecution> getBatchStatus(){
		return customRepository.getBatchStatus();
	}
}
