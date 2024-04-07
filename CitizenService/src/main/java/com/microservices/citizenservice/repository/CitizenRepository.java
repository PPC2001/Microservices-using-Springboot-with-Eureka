package com.microservices.citizenservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microservices.citizenservice.entity.Citizen;

public interface CitizenRepository  extends JpaRepository<Citizen, Integer>{
	
	List<Citizen> findByVaccinationCenterId(int id);
}
