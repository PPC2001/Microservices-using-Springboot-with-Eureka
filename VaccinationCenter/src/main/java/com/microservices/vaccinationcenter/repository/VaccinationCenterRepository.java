package com.microservices.vaccinationcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.vaccinationcenter.entity.VaccinationCenter;

public interface VaccinationCenterRepository extends JpaRepository<VaccinationCenter, Integer>{

}
