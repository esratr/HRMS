package com.hrms.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrms.hrms.business.abstratcs.CandidateService;
import com.hrms.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")


public class CandidateContoller {
	
	private CandidateService candidateService;
	

	@Autowired
	public CandidateContoller(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	
	@GetMapping("/getall")
	public List<Candidate> getAll(){
		return this.candidateService.getAll();
	}
	
	

}
