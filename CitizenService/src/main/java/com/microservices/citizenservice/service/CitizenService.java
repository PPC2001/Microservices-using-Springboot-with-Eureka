package com.microservices.citizenservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.citizenservice.entity.Citizen;
import com.microservices.citizenservice.repository.CitizenRepository;

@Service
public class CitizenService {

	@Autowired
	CitizenRepository citizenRepository;

	public List<Citizen> getCitizenListById(Integer id) {
		return citizenRepository.findByVaccinationCenterId(id);
	}

	public Citizen addCitizen(Citizen citizen) {
		return citizenRepository.save(citizen);
	}

}
