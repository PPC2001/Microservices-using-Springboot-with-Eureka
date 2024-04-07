package com.microservices.citizenservice.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.citizenservice.entity.Citizen;
import com.microservices.citizenservice.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {

	private static final Logger logger = LoggerFactory.getLogger(CitizenController.class);

	@Autowired
	CitizenService citizenService;

	@GetMapping("/id/{id}")
	public ResponseEntity<List<Citizen>> getCitizenListById(@PathVariable Integer id) {
        logger.info("Fetching citizen list by ID: {}", id);
		List<Citizen> citizenList = citizenService.getCitizenListById(id);
        logger.info("Fetched {} citizens by ID: {}", citizenList.size(), id);
		return new ResponseEntity<>(citizenList, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Citizen> addCitizen(@RequestBody Citizen citizen) {
        logger.info("Adding new citizen: {}", citizen);
		Citizen savedCitizen = citizenService.addCitizen(citizen);
        logger.info("Added new citizen with ID: {}", savedCitizen.getId());
		return new ResponseEntity<>(savedCitizen, HttpStatus.OK);
	}
}