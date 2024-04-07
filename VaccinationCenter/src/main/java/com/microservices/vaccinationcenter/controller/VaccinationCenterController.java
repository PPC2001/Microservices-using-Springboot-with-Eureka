package com.microservices.vaccinationcenter.controller;

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
import org.springframework.web.client.RestTemplate;

import com.microservices.vaccinationcenter.entity.VaccinationCenter;
import com.microservices.vaccinationcenter.model.Citizen;
import com.microservices.vaccinationcenter.model.RequiredResponse;
import com.microservices.vaccinationcenter.service.VaccinationCenterService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {
	private static final Logger logger = LoggerFactory.getLogger(VaccinationCenterController.class);

	@Autowired
	VaccinationCenterService vaccinationCenterService;

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/add")
	public ResponseEntity<VaccinationCenter> addVaccinationCenter(@RequestBody VaccinationCenter vaccinationCenter) {
		logger.info("Adding new vaccinationCenter: {}", vaccinationCenter);
		VaccinationCenter savedCenter = vaccinationCenterService.addVaccinationCenter(vaccinationCenter);
		logger.info("Added new vaccinationCenter with ID: {}", savedCenter.getId());
		return new ResponseEntity<>(savedCenter, HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/id/{id}")
	@CircuitBreaker(name = "citizenCircuitBreaker", fallbackMethod = "handleCitizenDownTime")
	public ResponseEntity<RequiredResponse> getAllDataBasedOnCenterId(@PathVariable Integer id) {
		RequiredResponse requiredResponse = new RequiredResponse();
		// 1 : Get the vaccination Center details based on the id
		VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterById(id);
		requiredResponse.setVaccinationCenter(vaccinationCenter);
		// 2 : Get all the citizen list registered to that vaccination center

//		List<Citizen> citizenList = restTemplate.getForObject("http://localhost:8081/citizen/id/" + id, List.class);
		List<Citizen> citizenList = restTemplate.getForObject("http://CITIZENSERVICE/citizen/id/" + id, List.class);
		requiredResponse.setCitizenList(citizenList);
		return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
	}

	public ResponseEntity<RequiredResponse> handleCitizenDownTime(@PathVariable Integer id, Throwable throwable) {
		RequiredResponse requiredResponse = new RequiredResponse();
		VaccinationCenter vaccinationCenter = vaccinationCenterService.getVaccinationCenterById(id);
		requiredResponse.setVaccinationCenter(vaccinationCenter);
		return new ResponseEntity<>(requiredResponse, HttpStatus.OK);
	}
}
