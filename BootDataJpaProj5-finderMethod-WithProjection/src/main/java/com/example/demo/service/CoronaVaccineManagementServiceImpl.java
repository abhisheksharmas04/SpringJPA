package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.CoronaVaccineRepo;
import com.example.demo.type.View;



@Service("vaccineManagementService")
public class CoronaVaccineManagementServiceImpl implements ICoronaVaccineManagementService {
	
	@Autowired
	private CoronaVaccineRepo coronaRepo;

	@Override
	public <T extends View> List<T> searchVaccinesByCompany(String companyName, Class<T> clazz) {
		return coronaRepo.findByCompanyOrderByCompanyDesc(companyName, clazz);
	}
}
