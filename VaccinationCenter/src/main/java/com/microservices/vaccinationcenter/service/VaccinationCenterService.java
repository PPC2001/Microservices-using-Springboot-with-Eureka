package com.microservices.vaccinationcenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.vaccinationcenter.entity.VaccinationCenter;
import com.microservices.vaccinationcenter.repository.VaccinationCenterRepository;

@Service
public class VaccinationCenterService {
	
	@Autowired
	VaccinationCenterRepository vaccinationCenterRepository;

	public VaccinationCenter addVaccinationCenter(VaccinationCenter vaccinationCenter) {
		return vaccinationCenterRepository.save(vaccinationCenter);
	}

	public VaccinationCenter getVaccinationCenterById(Integer id) {
		return vaccinationCenterRepository.findById(id).get();
	}

}
