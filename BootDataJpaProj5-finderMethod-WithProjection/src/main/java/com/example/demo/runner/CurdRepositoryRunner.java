package com.example.demo.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.ICoronaVaccineManagementService;
import com.example.demo.type.ResultView1;
import com.example.demo.type.ResultView2;



@Component
public class CurdRepositoryRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineManagementService service;

	@Override
	public void run(String... args) throws Exception {
		List<ResultView1>list1 =  service.searchVaccinesByCompany("pyzer", ResultView1.class);
		list1.forEach(view1 -> System.out.println(view1.getName() + "  " + view1.getCountry()));
		System.out.println("--------------------------------------------------------------------------------");
		service.searchVaccinesByCompany("Russie",ResultView2.class)
		.forEach(view2 -> System.out.println(view2.getPrice()));
	}

}