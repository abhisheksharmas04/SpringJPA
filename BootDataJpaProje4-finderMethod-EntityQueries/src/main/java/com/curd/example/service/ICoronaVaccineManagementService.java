package com.curd.example.service;

import java.util.List;

import com.curd.example.entity.CoronaVaccine;

public interface ICoronaVaccineManagementService {
	public List<CoronaVaccine>fetchVaccinesByCompany(String company);
	
}
