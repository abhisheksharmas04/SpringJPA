package com.curd.example.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import com.curd.example.entity.CoronaVaccine;
import com.curd.example.service.ICoronaVaccineManagementService;

@Component
public class CurdRepositoryRunner implements CommandLineRunner {

	@Autowired
	private ICoronaVaccineManagementService service;

	@Override
	public void run(String... args) throws Exception {
		/*try {
			CoronaVaccine vaccine = new CoronaVaccine();
			vaccine.setName("Covisheld");
			vaccine.setCompany("Serum");
			vaccine.setCountry("India");
			vaccine.setPrice(500.0);
			vaccine.setRequiredDosesCount(2);
			
			service.SearchVaccinesByGivenData(vaccine, true, "price").forEach(System.out::println);
			
			// Get by ID
			CoronaVaccine vaccine = service.getVaccineByRegNo(51L);
			if(vaccine !=null) {
				System.out.println("Vaccine Details: " + vaccine);
			}else {
				System.out.println("Record Not Found");
			}
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}*/
		try {
			// delete by IDs
			System.out.println(service.removeVaccinesByRegNo(List.of(44L,55L)));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}

}
