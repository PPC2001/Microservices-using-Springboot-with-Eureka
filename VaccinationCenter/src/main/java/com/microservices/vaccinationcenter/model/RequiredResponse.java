package com.microservices.vaccinationcenter.model;

import java.util.List;

import com.microservices.vaccinationcenter.entity.VaccinationCenter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequiredResponse {

	private VaccinationCenter vaccinationCenter;

	private List<Citizen> citizenList;
}
