package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.CoronaVaccineRepo;
import com.example.demo.type.ResultView;



@Service("vaccineManagementService")
public class CoronaVaccineManagementServiceImpl implements ICoronaVaccineManagementService {
	
	@Autowired
	private CoronaVaccineRepo coronaRepo;

	@Override
	public List<ResultView> searchVaccinesByStartPrice(double price) {
		return coronaRepo.findByPriceGreaterThanEqualOrderByPrice(price);
	}
}
