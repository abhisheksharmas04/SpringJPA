package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.ICoronaVaccineManagementService;
import com.example.demo.type.ResultView;



@Component
public class CurdRepositoryRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineManagementService service;

	@Override
	public void run(String... args) throws Exception {
		List<ResultView>listVaccine =  service.searchVaccinesByStartPrice(500.0);
		listVaccine.forEach(vaccine ->{
			System.out.println("Country: " + vaccine.getCountry());
			System.out.println("Name: " + vaccine.getName());
		});
	}

}